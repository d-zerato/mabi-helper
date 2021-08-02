package discord.bot.mabiHelper.spec.keyword;

public enum KeywordType {
    //
    UNKNOWN("unknown"),

    CONTENTS("contents"),
    COMMAND("command");

    private String type;

    KeywordType(String type) {
        //
        this.type = type;
    }
}
