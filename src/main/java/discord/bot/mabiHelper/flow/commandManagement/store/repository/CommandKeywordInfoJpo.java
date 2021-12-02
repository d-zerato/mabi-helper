package discord.bot.mabiHelper.flow.commandManagement.store.repository;

import discord.bot.mabiHelper.spec.commandManagement.CommandKeyword;
import discord.bot.mabiHelper.spec.commandManagement.CommandType;
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
@Table(name = "COMMAND_KEYWORD")
public class CommandKeywordInfoJpo extends DomainEntityJpo {
    //
    @Enumerated(EnumType.STRING)
    @Column(unique = false, nullable = false, columnDefinition = "varchar(50) comment '명령어 유형'")
    private CommandType commandType;

    @Column(unique = true, nullable = false, columnDefinition = "varchar(50) comment '검색 문자'")
    private String keyword;

    public CommandKeywordInfoJpo(CommandKeyword commandKeyword) {
        //
        super(commandKeyword);
        BeanUtils.copyProperties(commandKeyword, this);
    }

    public CommandKeyword toDomain() {
        //
        CommandKeyword commandKeyword = new CommandKeyword();

        BeanUtils.copyProperties(this, commandKeyword);

        return commandKeyword;
    }
}
