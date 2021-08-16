package discord.bot.mabiHelper.spec.botCommand;

import discord.bot.mabiHelper.spec.share.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BotCommand extends DomainEntity {
    //
    private String commandWord;
    private CommandCategory commandCategory;
    private CommandType commandType;

    public BotCommand() {
        super();
    }

    public BotCommand(String commandWord,
                      CommandCategory commandCategory,
                      CommandType commandType) {
        this();
        this.commandWord = commandWord;
        this.commandCategory = commandCategory;
        this.commandType = commandType;
    }

}
