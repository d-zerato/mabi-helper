package discord.bot.mabiHelper.spec.share.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Optional;

@Getter
@Setter
@AllArgsConstructor
public class SecretFileParser {
    //
    private DiscordSecretModel discord;

    public SecretFileParser() {
        //
        this.discord = new DiscordSecretModel();
    }

    public String getToken() {
        //
        return Optional.ofNullable(discord.getToken()).map(String::toString).orElse(null);
    }

    public String getApplicationId() {
        //
        return Optional.ofNullable(discord.getApplicationId()).map(String::toString).orElse(null);
    }

    class DiscordSecretModel {
        private String token;
        private String applicationId;

        public DiscordSecretModel() {
            //
        }

        public String getToken() {
            return token;
        }

        public String getApplicationId() {
            return this.applicationId;
        }
    }
}
