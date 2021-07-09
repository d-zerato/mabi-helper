package discord.bot.mabihelper.spec.master.sdo;

import discord.bot.mabihelper.spec.master.keyword.SearchCategory;
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
