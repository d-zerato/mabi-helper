package discord.bot.mabiHelper.spec.keyword.sdo;

import discord.bot.mabiHelper.spec.keyword.SearchCategory;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SearchKeywordCdo {
    //
    private SearchCategory category;
    private String keyword;
}
