package discord.bot.mabiHelper.flow.master;

import discord.bot.mabiHelper.flow.master.talent.service.TalentKeywordService;
import discord.bot.mabiHelper.spec.master.facade.TalentFacade;
import discord.bot.mabiHelper.spec.master.sdo.TalentKeywordCdo;
import discord.bot.mabiHelper.spec.master.sdo.TalentKeywordUdo;
import discord.bot.mabiHelper.spec.master.talent.TalentKeyword;
import discord.bot.mabiHelper.spec.master.talent.TalentType;
import discord.bot.mabiHelper.spec.share.StringUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@Transactional
public class TalentFlowService implements TalentFacade {
    //
    @Autowired
    private TalentKeywordService talentKeywordService;

    @Override
    public String registerTalentKeyword(TalentKeywordCdo talentKeywordCdo) {
        //
        boolean emptyCheck = Optional
                .ofNullable(talentKeywordCdo)
                .map(talentKeyword -> (StringUtil.isEmpty(talentKeyword.getKeyword()) || talentKeyword.getType() == null))
                .orElse(false);

        if (emptyCheck) {
            return null;
        }

        TalentKeyword talentKeyword = new TalentKeyword(talentKeywordCdo.getKeyword(), talentKeywordCdo.getType());

        return talentKeywordService.register(talentKeyword);
    }

    @Override
    public void modifyTalentKeyword(String id, TalentKeywordUdo talentKeywordUdo) {
        //
        if (StringUtil.isEmpty(id) || this.isUdoEmpty(talentKeywordUdo)) {
            return;
        }

        TalentKeyword talentKeyword = talentKeywordService.findById(id);

        if (talentKeyword == null) {
            return;
        }

        talentKeyword.setKeyword(talentKeywordUdo.getKeyword());
        talentKeyword.setType(talentKeywordUdo.getType());

        talentKeywordService.modify(talentKeyword);
    }

    @Override
    public void modifyTypeOfTalentKeyword(TalentKeywordUdo talentKeywordUdo) {
        //

        if (this.isUdoEmpty(talentKeywordUdo)) {
            return;
        }

        TalentKeyword talentKeyword = talentKeywordService.findByKeyword(talentKeywordUdo.getKeyword());

        if (talentKeyword == null) {
            return;
        } else {
            talentKeyword.setType(talentKeywordUdo.getType());
        }

        talentKeywordService.modify(talentKeyword);
    }

    private boolean isUdoEmpty(TalentKeywordUdo talentKeywordUdo) {
        //
        return Optional
                .ofNullable(talentKeywordUdo)
                .map(talentKeyword -> (StringUtil.isEmpty(talentKeyword.getKeyword()) || talentKeyword.getType() == null))
                .orElse(false);
    }

    @Override
    public void removeTalentKeyword(String id) {
        //
        if (StringUtil.isEmpty(id)) {
            return;
        }

        TalentKeyword talentKeyword = talentKeywordService.findById(id);

        talentKeywordService.remove(talentKeyword);
    }

    @Override
    public TalentKeyword findById(String id) {
        //
        if (StringUtil.isEmpty(id)) {
            return null;
        }

        return talentKeywordService.findById(id);
    }

    @Override
    public TalentKeyword findByKeyword(String keyword) {
        //
        if (StringUtil.isEmpty(keyword)) {
            return null;
        }

        return talentKeywordService.findByKeyword(keyword);
    }

    @Override
    public List<TalentKeyword> findByType(TalentType type) {
        //
        if (type == null) {
            return new ArrayList<>();
        }

        return talentKeywordService.findAllByType(type);
    }
}
