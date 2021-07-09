package discord.bot.mabihelper.spec.share;

import lombok.Getter;

@Getter
public class Offset {
    //
    private long offset;
    private long limit;

    public Offset() {
        //
        this.offset = 0;
        this.limit = 0;
    }

    public Offset(long offset, long limit) {
        //
        this.offset = offset;
        this.limit = limit;
    }
}
