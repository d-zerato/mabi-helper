package discord.bot.mabiHelper.spec.share;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class LogHeader {
    //
    private static long generatedAt = 0;

    private String logId;
    private String className;
    private String message;

    private boolean errorCheck;
    private String errorCode;
    private String errorMessage;

    public LogHeader() {
        //
        this.logId = LogHeader.generateLogId();
        this.className = null;
        this.message = "";

        this.errorCheck = false;
        this.errorMessage = null;
    }

    public void setMessage(String className, String message) {
        //
        this.className = className;
        this.message = message;
    }

    public void setMessage(String message) {
        //
        this.className = null;
        this.message = message;
    }

    public void setError(String errorCode, String errorMessage) {
        //
        this.errorCheck = true;
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public void setError(String errorMessage) {
        //
        this.errorCheck = true;
        this.errorMessage = errorMessage;
    }

    public void removeError() {
        //
        this.errorCheck = false;
        this.errorMessage = null;
    }

    public String getMessageLog() {
        //
        StringBuilder resultMessage = new StringBuilder();

        resultMessage.append("[").append(this.logId).append("]");
        if (StringUtil.isNotEmpty(this.className)) {
            resultMessage.append(":");
            resultMessage.append("[").append(this.className).append("]");
        }
        resultMessage.append(" : ");

        resultMessage.append(" ").append(this.message);

        return resultMessage.toString();
    }

    public String getErrorLog() {
        //
        if (!this.errorCheck) {
            //
            return this.getMessageLog();
        }

        StringBuilder resultMessage = new StringBuilder();

        resultMessage.append("[").append(this.logId).append("]");

        if (StringUtil.isNotEmpty(this.className)) {
            resultMessage.append(":");
            resultMessage.append("[").append(this.className).append("]");
        }

        if (StringUtil.isNotEmpty(this.errorCode)) {
            resultMessage.append(":");
            resultMessage.append("[").append(this.errorCode).append("]");
        }

        resultMessage.append(" : ");

        resultMessage.append(" ").append(this.errorMessage);

        return resultMessage.toString();

    }

    public static String generateLogId() {
        //
        long currentAt = System.currentTimeMillis() * 1000;

        if (generatedAt != currentAt) {
            generatedAt = currentAt;
            return "L"+currentAt;
        } else {
            currentAt += 1;
            generatedAt = currentAt;
            return "L"+currentAt;
        }
    }
}
