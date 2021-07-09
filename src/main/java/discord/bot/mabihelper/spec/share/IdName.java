package discord.bot.mabihelper.spec.share;

import com.sun.beans.decoder.ValueObject;
import lombok.Getter;
import lombok.NoArgsConstructor;

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
