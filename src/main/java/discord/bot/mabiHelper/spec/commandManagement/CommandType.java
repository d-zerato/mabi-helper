package discord.bot.mabiHelper.spec.commandManagement;

import lombok.Getter;

@Getter
public enum CommandType {
    //
    NONE("none", "initialize Value"),

    MASTER("master", "그랜드 마스터"),

    COMMAND_GUIDE("commandGuide", "명령어 가이드"),
    CLEAR_MESSAGE("clearMessage", "메시지 삭제");

    private String commandName;
    private String describe;

    CommandType(String commandName, String describe) {
        //
        this.commandName = commandName;
        this.describe = describe;
    }
}
