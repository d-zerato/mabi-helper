package discord.bot.mabiHelper.exception;

import lombok.Getter;

@Getter
public enum ErrorMessage {
    //
    DISCORD_EXCEPTION_200(200, "채널 정보를 알 수 없습니다."),

    DISCORD_EXCEPTION_100(100, "명령어를 확인해주세요."),
    DISCORD_EXCEPTION_101(101, "명령어 요구 항목이 부족합니다."),
    DISCORD_EXCEPTION_102(102, "명령어 요구 항목이 부적절합니다.");

    private int errorCode;
    private String message;

    ErrorMessage(int errorCode, String message) {
        //
        this.errorCode = errorCode;
        this.message = message;
    }
}
