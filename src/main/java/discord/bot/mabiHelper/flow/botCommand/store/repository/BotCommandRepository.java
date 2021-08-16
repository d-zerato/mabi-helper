package discord.bot.mabiHelper.flow.botCommand.store.repository;

import discord.bot.mabiHelper.spec.botCommand.CommandCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BotCommandRepository extends JpaRepository<BotCommandJpo, String> {
    //
    BotCommandJpo findByCommandWord(String commandWord);
    List<BotCommandJpo> findAllByCommandWordInOrderByCreatedAtDesc(List<String> commandWordList);
    List<BotCommandJpo> findAllByCommandCategoryOrderByCreatedAtDesc(CommandCategory commandCategory);
}
