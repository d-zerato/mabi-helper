package discord.bot.mabihelper.spec.master.sdo;

import discord.bot.mabihelper.spec.master.keyword.SearchCategory;
import discord.bot.mabihelper.spec.share.DomainEntity;
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
