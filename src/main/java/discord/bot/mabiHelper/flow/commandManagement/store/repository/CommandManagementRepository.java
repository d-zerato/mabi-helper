package discord.bot.mabiHelper.flow.commandManagement.store.repository;

import discord.bot.mabiHelper.spec.commandManagement.CommandType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommandManagementRepository extends JpaRepository<CommandKeywordInfoJpo, String> {
    //
    CommandKeywordInfoJpo findByKeyword(String keyword);

    List<CommandKeywordInfoJpo> findAllByKeywordInOrderByKeywordDesc(List<String> keyword);

    List<CommandKeywordInfoJpo> findAllByCommandTypeOrderByUpdatedAtDesc(CommandType commandType);
}
