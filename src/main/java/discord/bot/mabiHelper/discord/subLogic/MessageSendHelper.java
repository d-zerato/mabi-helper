package discord.bot.mabiHelper.discord.subLogic;

import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.entities.TextChannel;
import org.springframework.stereotype.Component;

@Component
public class MessageSendHelper {
    //
    public static void sendMessage(TextChannel textChannel, String message) {
        //
        textChannel.sendMessage(message).queue();
    }

    public static void sendMessage(TextChannel textChannel, MessageEmbed message) {
        //
        textChannel.sendMessage(message).queue();
    }
}
