package discord.bot.mabiHelper.spec.discord;

import discord.bot.mabiHelper.exception.ErrorMessage;
import discord.bot.mabiHelper.exception.ParsingMessageException;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class ParsingMessage {
    //
    // !마스터 근접전투 x x
    private String command;
    private List<String> parameterList;

    public ParsingMessage(String command, List<String> parameterList) {
        //
        this.command = command;
        this.parameterList = parameterList;
    }
}
