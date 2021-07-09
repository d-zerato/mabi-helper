package discord.bot.mabihelper.spec.share;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;

import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
public class DomainEntityJpo implements Serializable {
    //
    @Id
    private String id;
    @Version
    private long version;
    private long createdAt;
    private long updatedAt;
    private boolean deleted;
    private long deletedAt;

    public DomainEntityJpo() {
        //
        this.id = UUID.randomUUID().toString();
        this.version = 0;
        this.createdAt = System.currentTimeMillis();
        this.updatedAt = System.currentTimeMillis();
        this.deleted = false;
        this.deletedAt = 0;
    }
}
