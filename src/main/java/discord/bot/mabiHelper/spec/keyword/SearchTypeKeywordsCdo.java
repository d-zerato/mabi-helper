package discord.bot.mabiHelper.spec.keyword;

import discord.bot.mabiHelper.spec.keyword.SearchCategory;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SearchTypeKeywordsCdo {
    //
    private SearchCategory category;
    private List<String> keywords;
}
