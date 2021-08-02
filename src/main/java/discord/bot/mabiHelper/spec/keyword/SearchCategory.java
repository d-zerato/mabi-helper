package discord.bot.mabiHelper.spec.keyword;

import lombok.Getter;

@Getter
public enum SearchCategory {
    //
    NONE("none", "initialize Value", KeywordType.UNKNOWN),

    MASTER("master", "그랜드 마스터", KeywordType.CONTENTS),
    TALENT("talent", "재능", KeywordType.CONTENTS),

    COMMAND_GUIDE("commandGuide", "명령어 가이드", KeywordType.COMMAND),
    CLEAR_MESSAGE("clearMessage", "메시지 삭제", KeywordType.COMMAND);

    private String category;
    private String describe;
    private KeywordType keywordType;

    SearchCategory(String category, String describe, KeywordType keywordType) {
        //
        this.category = category;
        this.describe = describe;
        this.keywordType = keywordType;
    }
}
