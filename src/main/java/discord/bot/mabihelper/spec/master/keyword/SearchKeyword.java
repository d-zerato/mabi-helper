package discord.bot.mabihelper.spec.master.keyword;

import discord.bot.mabihelper.spec.share.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SearchKeyword extends DomainEntity {
    //
    private SearchCategory category;
    private String type;
    private String keyword;

    public SearchKeyword() {
        super();
        this.category = SearchCategory.NONE;
        this.type = "";
        this.keyword = "";
    }

    public SearchKeyword(SearchCategory category,
                         String keyword) {
        //
        this.category = category;
        this.type = null;
        this.keyword = keyword;
    }

    public SearchKeyword(SearchCategory category,
                         String type,
                         String keyword) {
        //
        this.category = category;
        this.type = type;
        this.keyword = keyword;
    }
}
