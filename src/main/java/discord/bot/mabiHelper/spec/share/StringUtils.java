package discord.bot.mabiHelper.spec.share;

public class StringUtils {
    //
    public static boolean isEmpty(String value) {
        return value == null || value.equals("");
    }

    public static boolean isNotEmpty(String value) {
        return value != null && !value.equals("");
    }
}
