package discord.bot.mabiHelper.boot;

import discord.bot.mabiHelper.discord.EventListener;
import discord.bot.mabiHelper.spec.commandManagement.CommandType;
import discord.bot.mabiHelper.spec.share.model.SecretFileParser;
import discord.bot.mabiHelper.spec.share.util.SimpleFileReader;
import lombok.extern.slf4j.Slf4j;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.CommandData;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;
import net.dv8tion.jda.api.requests.restaction.CommandListUpdateAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Slf4j
@Component
public class StartDiscordConfig implements CommandLineRunner {
    //
    @Autowired
    private EventListener eventListener;

    private String token;

    private String applicationId;

    @Override
    public void run(String... args) throws Exception {
        //
        try {
            ClassPathResource resource = new ClassPathResource("secret/secret.json");
            SecretFileParser discordToken = SimpleFileReader.readFileToJson(resource.getURI(), SecretFileParser.class);

            log.debug("* Discord Token : " + discordToken.getToken());
            log.debug("* Discord Application Id : " + discordToken.getApplicationId());
            this.token = discordToken.getToken();
            this.applicationId = discordToken.getApplicationId();

            JDA jda = JDABuilder
                    .createDefault(discordToken.getToken())
                    .setRawEventsEnabled(true)
                    .addEventListeners(eventListener).build();

            this.initCommand(jda);

        } catch (IOException | NullPointerException e) {
            log.error("Failed Parsing Target File");
        }
    }

    public void initCommand(JDA jda) {
        //
        CommandListUpdateAction commands = jda.updateCommands();

        commands.addCommands(
                new CommandData(CommandType.MASTER.getCommandName(), "그랜드 마스터 퀘스트 목록과 추천도를 전달드립니다.")
                        .addOptions(new OptionData(OptionType.STRING, "talent", "재능을 선택해주세요.")
                                .setRequired(true)) // This command requires a parameter
                        .addOptions(new OptionData(OptionType.INTEGER, "number", "퀘스트 번호를 선택해주세요.")
                                .setRequired(false))
        );

        commands.addCommands(
                new CommandData(CommandType.NONE.getCommandName(), "그랜드 마스터 퀘스트 목록과 추천도를 전달드립니다.")
                        .addOptions(new OptionData(OptionType.STRING, "talent", "재능을 선택해주세요.")
                                .setRequired(true)) // This command requires a parameter
                        .addOptions(new OptionData(OptionType.INTEGER, "number", "퀘스트 번호를 선택해주세요.")
                                .setRequired(false))
        );

        commands.queue();

    }
}

