package discord.bot.mabiHelper.flow.master.talent.store;

import discord.bot.mabiHelper.flow.master.talent.store.repository.TalentKeywordJpo;
import discord.bot.mabiHelper.flow.master.talent.store.repository.TalentKeywordRepository;
import discord.bot.mabiHelper.spec.master.talent.TalentKeyword;
import discord.bot.mabiHelper.spec.master.talent.TalentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class TalentKeywordStoreLogic implements TalentKeywordStore {
    //
    @Autowired
    private TalentKeywordRepository talentKeywordRepository;

    @Override
    public void create(TalentKeyword talentKeyword) {
        //
        talentKeywordRepository.save((new TalentKeywordJpo((talentKeyword))));
    }

    @Override
    public void update(TalentKeyword talentKeyword) {
        //
        talentKeywordRepository.save((new TalentKeywordJpo((talentKeyword))));
    }

    @Override
    public void delete(TalentKeyword talentKeyword) {
        //
        talentKeywordRepository.delete(new TalentKeywordJpo(talentKeyword));
    }

    @Override
    public TalentKeyword retrieveById(String id) {
        //
        return talentKeywordRepository
                .findById(id)
                .map(TalentKeywordJpo::toDomain)
                .orElse(null);
    }

    @Override
    public TalentKeyword retrieveByKeyword(String keyword) {
        //
       return Optional
               .ofNullable(talentKeywordRepository
                       .findByKeyword(keyword))
               .map(TalentKeywordJpo::toDomain)
               .orElse(null);
    }

    @Override
    public List<TalentKeyword> retrieveAllByType(TalentType talentType) {
        //
        return talentKeywordRepository
                .findAllByTypeOrderByCreatedAtDesc(talentType)
                .stream()
                .map(TalentKeywordJpo::toDomain)
                .collect(Collectors.toList());
    }
}
