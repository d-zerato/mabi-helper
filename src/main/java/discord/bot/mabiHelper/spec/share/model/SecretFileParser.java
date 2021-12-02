package discord.bot.mabiHelper.spec.share.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
        return this.discord != null ? this.discord.getToken() : "";
    }

    class DiscordSecretModel {
        private String token;

        public DiscordSecretModel() {
            //
        }

        public String getToken() {
            return token;
        }
    }
}
