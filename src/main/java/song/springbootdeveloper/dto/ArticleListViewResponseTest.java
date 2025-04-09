package song.springbootdeveloper.dto;

import lombok.Getter;
import song.springbootdeveloper.domain.Article;

@Getter
public class ArticleListViewResponseTest {

    private final Long id;
    private final String title;
    private final String content;

    public ArticleListViewResponseTest(Article article) {
        this.id = article.getId();
        this.title = article.getTitle();
        this.content = article.getContent();
    }
}
