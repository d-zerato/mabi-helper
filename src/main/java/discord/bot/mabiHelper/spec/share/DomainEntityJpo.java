package discord.bot.mabiHelper.spec.share;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;
import org.springframework.data.annotation.Version;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public abstract class DomainEntityJpo implements JsonSerializable {
    //
    @Id
    @Column(unique = true, nullable = false, columnDefinition = "varchar(50) comment 'UUID'")
    private String id;

    @Version
    @Column(unique = false, nullable = false, columnDefinition = "bigint(20) default 0 comment '버전 관리'")
    private long entityVersion;

    @Column(unique = false, nullable = false, columnDefinition = "bigint(20) default 0 comment '생성 시간'")
    private long createdAt;

    @Column(unique = false, nullable = false, columnDefinition = "bigint(20) default 0 comment '변경 시간'")
    private long updatedAt;

    @Column(unique = false, nullable = false, columnDefinition = "bit(1) default 0 comment '삭제 여부'")
    private boolean deleted;

    @Column(unique = false, nullable = false, columnDefinition = "bigint(20) default 0 comment '삭제 시간'")
    private long deletedAt;

    protected DomainEntityJpo(String id) {
        //
        this.id = id;
        this.entityVersion = 0L;
    }

    protected DomainEntityJpo(DomainEntity domainEntity) {
        //
        BeanUtils.copyProperties(domainEntity, this);
    }
}
