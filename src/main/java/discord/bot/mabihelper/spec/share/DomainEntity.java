package discord.bot.mabihelper.spec.share;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
public class DomainEntity {
    //
    private String id;
    private long version;
    private long createdAt;
    private long updatedAt;
    private boolean deleted;
    private long deletedAt;

    public DomainEntity() {
        //
        this.id = UUID.randomUUID().toString();
        this.version = 0;
        this.createdAt = System.currentTimeMillis();
        this.updatedAt = System.currentTimeMillis();
        this.deleted = false;
        this.deletedAt = 0;
    }

    public void delete() {
        //
        this.deleted = true;
        this.deletedAt = System.currentTimeMillis();
    }
}
