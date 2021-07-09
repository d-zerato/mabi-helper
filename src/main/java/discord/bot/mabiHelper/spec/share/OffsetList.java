package discord.bot.mabiHelper.spec.share;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class OffsetList<T> {
    //
    private List<T> list;
    private int totalCount;

    public OffsetList() {
        //
        this.list = new ArrayList<>();
        this.totalCount = 0;
    }

    public OffsetList(List<T> list) {
        this();
        this.list = list;

        if (list != null) {
            this.totalCount = list.size();
        }
    }

    public OffsetList(List<T> list, int totalCount) {
        this();
        this.list = list;
        this.totalCount = totalCount;
    }
}
