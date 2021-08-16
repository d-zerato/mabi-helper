package discord.bot.mabiHelper.spec.botCommand;

import lombok.Getter;

@Getter
public enum  CommandType {
    //
    MANAGEMENT("management", "discord 관리"),
    CONTENTS("contents", "마비노기 컨텐츠");

    private String command;
    private String describe;

    CommandType(String command, String describe) {
        //
        this.command = command;
        this.describe = describe;
    }
}
