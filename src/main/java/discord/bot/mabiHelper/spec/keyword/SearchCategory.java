package discord.bot.mabiHelper.spec.keyword;

import lombok.Getter;

@Getter
public enum SearchCategory {
    //
    NONE("none", "initialize Value"),

    MASTER("master", "그랜드 마스터"),
    TALENT("talent", "재능"),

    COMMAND_GUIDE("commandGuide", "명령어 가이드"),
    CLEAR_MESSAGE("clearMessage", "메시지 삭제");

    private String category;
    private String describe;

    SearchCategory(String category, String describe) {
        //
        this.category = category;
        this.describe = describe;
    }
}
