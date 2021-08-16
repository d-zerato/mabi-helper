package discord.bot.mabiHelper.spec.botCommand;

import lombok.Getter;

@Getter
public enum CommandCategory {
    //
    // Management
    CLEAR_CHATTING("clearChatting")

    // Contents
    ,MASTER_QUEST("masterQuest")

    ;

    private String category;

    CommandCategory(String category) {
        //
        this.category = category;
    }
}
