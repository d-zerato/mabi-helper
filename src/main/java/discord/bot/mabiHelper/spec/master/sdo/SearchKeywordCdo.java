package discord.bot.mabiHelper.spec.master.sdo;

import discord.bot.mabiHelper.spec.master.keyword.SearchCategory;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SearchKeywordCdo {
    //
    private SearchCategory category;
    private String type;
    private String keyword;
}
