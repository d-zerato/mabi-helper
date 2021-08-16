package discord.bot.mabiHelper.flow.botCommand.store.repository;

import discord.bot.mabiHelper.spec.botCommand.BotCommand;
import discord.bot.mabiHelper.spec.botCommand.CommandCategory;
import discord.bot.mabiHelper.spec.botCommand.CommandType;
import discord.bot.mabiHelper.spec.keyword.SearchKeyword;
import discord.bot.mabiHelper.spec.share.DomainEntityJpo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;
import org.springframework.data.annotation.Version;

import javax.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "BOT_COMMAND")
public class BotCommandJpo extends DomainEntityJpo {
    //
    @Column(unique = true, nullable = false, columnDefinition = "varchar(100) comment '명령어'")
    private String commandWord;

    @Enumerated(EnumType.STRING)
    @Column(unique = false, nullable = false, columnDefinition = "varchar(50) comment '명령어 종류'")
    private CommandCategory commandCategory;

    @Enumerated(EnumType.STRING)
    @Column(unique = false, nullable = false, columnDefinition = "varchar(50) comment '명령어 분류'")
    private CommandType commandType;

    public BotCommandJpo(BotCommand botCommand) {
        //
        super(botCommand);
        BeanUtils.copyProperties(botCommand, this);
    }

    public BotCommand toDomain() {
        //
        BotCommand botCommand = new BotCommand();

        BeanUtils.copyProperties(this, botCommand);

        return botCommand;
    }
}
