package discord.bot.mabiHelper.spec.master.talent;

import lombok.Getter;

@Getter
public enum TalentType {
    //
    WARRIOR("warrior", "전사"),
    LANCER("lancer", "랜서"),
    ARCHER("archer", "궁수"),
    WIZARD("wizard", "마법사"),
    BATTLE_ALCHEMIST("battleAlchemist", "전투 연금술사"),
    FIGHTER("fighter", "격투가"),
    PUPPETEER("puppeteer", "인형사"),
    SHOOTER("shooter", "슈터"),
    NINJA("ninja", "닌자"),
    CHAIN_SLASHER("chainSlasher", "체인 슬래셔"),

    BARD("bard", "음유시인"),
    TRANSMUTATION_ALCHEMIST("transmutationAlchemist","연성 연금술사"),
    PRIEST("priest", "사제"),
    MAGI_GRAPHER("magiGrapher", "마기 그래퍼"),
    PET_HANDLER("petHandler", "펫 핸들러"),
    CHEMIST("chemist", "약사"),
    TAILOR("tailor", "재단사"),
    ADVENTURER("adventurer", "모험가"),
    MERCHANT("merchant", "상인"),
    COOK("cook", "요리사"),
    BLACKSMITH("blacksmith", "대장장이"),
    CARPENTER("carpenter", "목수");

    private String talentType;
    private String talentName;

    TalentType(String talentType, String talentName) {
        //
        this.talentType = talentType;
        this.talentName = talentName;
    }
}
