package discord.bot.mabiHelper.boot;

import discord.bot.mabiHelper.discord.EventListener;
import discord.bot.mabiHelper.spec.share.model.SecretFileParser;
import discord.bot.mabiHelper.spec.share.util.SimpleFileReader;
import lombok.extern.slf4j.Slf4j;
import net.dv8tion.jda.api.JDABuilder;
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

    @Override
    public void run(String... args) throws Exception {
        //
        try {
            ClassPathResource resource = new ClassPathResource("secret/secret.json");
            SecretFileParser discordToken = SimpleFileReader.readFileToJson(resource.getURI(), SecretFileParser.class);

            log.debug("* Discord Token : " + discordToken.getToken());

            JDABuilder.createDefault(discordToken.getToken())
                    .addEventListeners(eventListener)
                    .build();

        } catch (IOException e) {
            log.error("Failed Parsing Target File");
        }
    }
}

