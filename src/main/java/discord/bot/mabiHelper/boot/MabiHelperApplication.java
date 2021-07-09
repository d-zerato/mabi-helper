package discord.bot.mabiHelper.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("discord.bot.mabiHelper")
public class MabiHelperApplication {
    public static void main(String[] args) {
        SpringApplication.run(MabiHelperApplication.class, args);
    }
}
