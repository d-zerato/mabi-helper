package discord.bot.mabiHelper.spec.keyword;

import discord.bot.mabiHelper.spec.share.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SearchKeyword extends DomainEntity {
    //
    private SearchCategory category;
    private KeywordType type;
    private String keyword;

    public SearchKeyword() {
        super();
        this.category = SearchCategory.NONE;
        this.type = this.category.getKeywordType();
        this.keyword = "";
    }

    public SearchKeyword(SearchCategory category,
                         String keyword) {
        //
        super();
        this.keyword = keyword;
        this.category = category;
        this.type = this.category.getKeywordType();
    }

    public void setCategory(SearchCategory searchCategory) {
        //
        this.category = searchCategory;
        this.type = this.category.getKeywordType();
    }
}