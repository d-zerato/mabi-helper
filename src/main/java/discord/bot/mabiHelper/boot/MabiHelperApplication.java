package discord.bot.mabiHelper.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.annotation.PostConstruct;
import java.util.TimeZone;

@SpringBootApplication(scanBasePackages = "discord.bot.mabiHelper")
@EnableJpaRepositories("discord.bot.mabiHelper")
@EntityScan("discord.bot.mabiHelper")
@ComponentScan(basePackages = "discord.bot.mabiHelper")
@EnableSwagger2
public class MabiHelperApplication {
    public static void main(String[] args) {
        //
        SpringApplication.run(MabiHelperApplication.class, args);
    }

    //
    @PostConstruct
    public void started() {
        //
        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Seoul"));
    }
}
