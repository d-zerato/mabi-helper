package discord.bot.mabiHelper.flow.simpleCommand.store.repository;

import discord.bot.mabiHelper.spec.simpleCommand.CommandType;
import discord.bot.mabiHelper.spec.simpleCommand.SimpleCommand;;
import discord.bot.mabiHelper.spec.share.DomainEntityJpo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import javax.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "SIMPLE_COMMAND")
public class SimpleCommandJpo extends DomainEntityJpo {
    //
    @Enumerated(EnumType.STRING)
    @Column(unique = false, nullable = false, columnDefinition = "varchar(50) comment '명령어 유형'")
    private CommandType commandType;

    @Column(unique = true, nullable = false, columnDefinition = "varchar(50) comment '검색 문자'")
    private String keyword;

    public SimpleCommandJpo(SimpleCommand simpleCommand) {
        //
        super(simpleCommand);
        BeanUtils.copyProperties(simpleCommand, this);
    }

    public SimpleCommand toDomain() {
        //
        SimpleCommand simpleCommand = new SimpleCommand();

        BeanUtils.copyProperties(this, simpleCommand);

        return simpleCommand;
    }
}
