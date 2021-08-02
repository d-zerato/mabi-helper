package discord.bot.mabiHelper.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ParsingMessageException extends RuntimeException {
    //
    private final int ERROR_CODE;

    public ParsingMessageException(String message, int error_code) {
        //
        super(message);
        this.ERROR_CODE = error_code;
    }

    public ParsingMessageException(ErrorMessage errorMessage) {
        //
        this(errorMessage.getMessage(), errorMessage.getErrorCode());
    }
}
