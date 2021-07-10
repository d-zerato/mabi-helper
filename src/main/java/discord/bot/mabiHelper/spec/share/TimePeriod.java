package discord.bot.mabiHelper.spec.share;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.Calendar;

public class TimePeriod implements JsonSerializable {
    private static String DEFAULT_TIME_FORMAT = "HH:mm:ss";
    private String zoneId;
    private Long startTime;
    private Long endTime;

    public TimePeriod() {
        this.zoneId = ZoneId.systemDefault().getId();
        this.startTime = System.currentTimeMillis();
        this.endTime = null;
    }

    public TimePeriod(long startTime, long endTime) {
        this.zoneId = ZoneId.systemDefault().getId();
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public TimePeriod(ZonedDateTime startTime, ZonedDateTime endTime) {
        this.zoneId = startTime.getZone().getId();
        this.startTime = startTime.toInstant().toEpochMilli();
        this.endTime = endTime.toInstant().toEpochMilli();
    }

    public TimePeriod(LocalDateTime startTime, LocalDateTime endTime) {
        this.zoneId = ZoneId.systemDefault().getId();
        this.startTime = startTime.atZone(ZoneId.of(this.zoneId)).toInstant().toEpochMilli();
        this.endTime = endTime.atZone(ZoneId.of(this.zoneId)).toInstant().toEpochMilli();
    }

    public TimePeriod(long startTime) {
        this(startTime, 0L);
    }

    public String toString() {
        return this.toJson();
    }

    public String toSimpleString() {
        return String.format("StartTime[%s], EndTime[%s]", this.getStartTimeString(), this.getEndTimeString());
    }

    public static TimePeriod fromJson(String json) {
        return (TimePeriod)JsonUtil.fromJson(json, TimePeriod.class);
    }

    public static TimePeriod sample() {
        return new TimePeriod(LocalDateTime.now().toEpochSecond(ZoneOffset.UTC), LocalDateTime.now().plusDays(10L).toEpochSecond(ZoneOffset.UTC));
    }

    public LocalDateTime getStartLocalDateTime() {
        return Instant.ofEpochMilli(this.startTime).atZone(ZoneId.systemDefault()).toLocalDateTime();
    }

    public ZonedDateTime getStartZonedDateTime() {
        return Instant.ofEpochMilli(this.startTime).atZone(ZoneId.systemDefault());
    }

    public LocalDateTime getEndLocalDateTime() {
        return Instant.ofEpochMilli(this.endTime).atZone(ZoneId.systemDefault()).toLocalDateTime();
    }

    public ZonedDateTime getEndZonedDateTime() {
        return Instant.ofEpochMilli(this.endTime).atZone(ZoneId.systemDefault());
    }

    public String getStartTimeString() {
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(this.startTime);
        return (new SimpleDateFormat(DEFAULT_TIME_FORMAT)).format(cal.getTime());
    }

    public String getEndTimeString() {
        if (this.endTime != null && this.endTime != 0L) {
            Calendar cal = Calendar.getInstance();
            cal.setTimeInMillis(this.startTime);
            return (new SimpleDateFormat(DEFAULT_TIME_FORMAT)).format(cal.getTime());
        } else {
            return "00:00:00";
        }
    }

    public static void main(String[] args) {
        System.out.println(sample());
        System.out.println(sample().toSimpleString());
    }

    public String getZoneId() {
        return this.zoneId;
    }

    public Long getStartTime() {
        return this.startTime;
    }

    public Long getEndTime() {
        return this.endTime;
    }

    public void setZoneId(String zoneId) {
        this.zoneId = zoneId;
    }

    public void setStartTime(Long startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(Long endTime) {
        this.endTime = endTime;
    }

    public TimePeriod(String zoneId, Long startTime, Long endTime) {
        this.zoneId = zoneId;
        this.startTime = startTime;
        this.endTime = endTime;
    }
}