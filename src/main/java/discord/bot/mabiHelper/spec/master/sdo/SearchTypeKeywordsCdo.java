package discord.bot.mabiHelper.spec.master.sdo;

import discord.bot.mabiHelper.spec.master.keyword.SearchCategory;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SearchTypeKeywordsCdo {
    //
    private SearchCategory category;
    private String type;
    private List<String> keywords;
}
