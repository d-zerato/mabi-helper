package discord.bot.mabiHelper.spec.share;

public interface JsonSerializable {
    //
    default String toJson() {
        return JsonUtil.toJson(this);
    }
}
