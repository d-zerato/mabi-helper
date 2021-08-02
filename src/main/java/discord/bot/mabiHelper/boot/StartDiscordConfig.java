package discord.bot.mabiHelper.boot;

import discord.bot.mabiHelper.discord.EventListener;
import net.dv8tion.jda.api.JDABuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class StartDiscordConfig implements CommandLineRunner {
    //
    @Autowired
    private EventListener eventListener;

    @Override
    public void run(String... args) throws Exception {
        //
        JDABuilder.createDefault("NzY5NDM2MDA4NjcxMzQ2NzM4.X5O_Hw.Ntm40hS6AQ5l6MEsPMvaPeOSEx4")
                .addEventListeners(eventListener)
                .build();
    }
}

