package discord.bot.mabiHelper.spec.share;

import lombok.Getter;

@Getter
public class IdName {
    //
    private String id;
    private String name;

    public IdName() {
        //
        this.id = null;
        this.name = null;
    }

    public IdName(String id, String name) {
        //
        this.id = id;
        this.name = name;
    }
}
