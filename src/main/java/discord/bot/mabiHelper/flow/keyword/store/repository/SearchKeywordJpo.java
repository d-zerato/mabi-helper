package discord.bot.mabiHelper.flow.keyword.store.repository;

import discord.bot.mabiHelper.spec.keyword.SearchCategory;
import discord.bot.mabiHelper.spec.keyword.SearchKeyword;
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
@Table(name = "SEARCH_KEYWORD")
public class SearchKeywordJpo extends DomainEntityJpo {
    //
    @Enumerated(EnumType.STRING)
    @Column(unique = false, nullable = false, columnDefinition = "varchar(50) comment '컨텐츠 유형'")
    private SearchCategory category;

    @Column(unique = true, nullable = false, columnDefinition = "varchar(50) comment '검색문자열'")
    private String keyword;

    public SearchKeywordJpo(SearchKeyword searchKeyword) {
        //
        super(searchKeyword);
        BeanUtils.copyProperties(searchKeyword, this);
    }

    public SearchKeyword toDomain() {
        //
        SearchKeyword searchKeyword = new SearchKeyword();

        BeanUtils.copyProperties(this, searchKeyword);

        return searchKeyword;
    }
}
