package discord.bot.mabiHelper.spec.share;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
public abstract class DomainEntity {
    //
    private String id;
    private long entityVersion;
    private long createdAt;
    private long updatedAt;
    private boolean deleted;
    private long deletedAt;

    public DomainEntity() {
        //
        this.id = UUID.randomUUID().toString();
        this.entityVersion = 0L;
        this.createdAt = System.currentTimeMillis();
        this.updatedAt = System.currentTimeMillis();
        this.deleted = false;
        this.deletedAt = 0L;
    }

    public DomainEntity(String id) {
        //
        this();
        this.id = id;
    }

    public DomainEntity(DomainEntity domainEntity) {
        //
        BeanUtils.copyProperties(domainEntity, this);
    }

    public void delete() {
        //
        this.deleted = true;
        this.deletedAt = System.currentTimeMillis();
    }

    public void update() {
        //
        this.updatedAt = System.currentTimeMillis();
    }
}
