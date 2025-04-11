package song.springbootdeveloper.dto;

import lombok.Getter;
import song.springbootdeveloper.domain.Article;

@Getter
public class ArticleResponseTest {

    private final String title;
    private final String content;

    public ArticleResponse(Article article) {
        this.title = article.getTitle();
        this.content = article.getContent();
    }
}
