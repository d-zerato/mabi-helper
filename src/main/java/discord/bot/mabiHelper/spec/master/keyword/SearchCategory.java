package discord.bot.mabiHelper.spec.master.keyword;

public enum SearchCategory {
    //
    NONE("none", "initialize Value"),
    MASTER("master", "그랜드 마스터"),
    TALENT("talent", "재능");

    private String keyword;
    private String describe;

    SearchCategory(String keyword, String describe) {
        //
        this.keyword = keyword;
        this.describe = describe;
    }
}
