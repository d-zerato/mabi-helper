package discord.bot.mabiHelper.flow.simpleCommand.store.repository;

import discord.bot.mabiHelper.spec.simpleCommand.CommandType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SimpleCommandRepository extends JpaRepository<SimpleCommandJpo, String> {
    //
    SimpleCommandJpo findByKeyword(String keyword);
    List<SimpleCommandJpo> findAllByKeywordInOrderByKeywordDesc(List<String> keyword);
    List<SimpleCommandJpo> findAllByCommandTypeOrderByUpdatedAtDesc(CommandType commandType);
}
