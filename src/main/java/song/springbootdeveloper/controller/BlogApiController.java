package song.springbootdeveloper.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import song.springbootdeveloper.domain.Article;
import song.springbootdeveloper.dto.AddArticleRequest;
import song.springbootdeveloper.dto.ArticleResponse;
import song.springbootdeveloper.service.BlogService;

import java.util.List;

@RequiredArgsConstructor
@RestController // @Controller + @ResponseBody = @RestController
public class BlogApiController {

    private final BlogService blogService;

    @PostMapping("/api/articles")
    public ResponseEntity<Article> addArticle(@RequestBody AddArticleRequest request) {
        Article savedArticle = blogService.save(request);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(savedArticle);
        //반환 타입: ResponseEntity<Article>
        //ResponseEntity -> HTTP 응답 상태 코드, 헤더, 바디(응답 데이터)를 포함한 HTTP 응답을 표현하는 클래스이다
        //<Article> -> 응답 바디에 담길 데이터 타입이 Article객체이다

        //@RequestBody -> 클라이언트가 입력한 값(JSON형태)를 객체와 매핑하는 메서드

        /*
         * @RequestBody -> 클라이언트가 서버에게 '요청' (HTTP메서드 + 데이터)를 Java 객체로 변환
         * @ResponseBody -> 서버가 클라이언트에게 '응답' (Java -> JSON 데이터로 변환)
         * @RestController를 사용하면 모든 메서드에 '@ResponseBody'가 자동으로 적용된다.
         */
    }

    @GetMapping("/api/articles")
    public ResponseEntity<List<ArticleResponse>> findAllArticles(){
        List<ArticleResponse> articles = blogService.findAll()
                .stream()
                .map(ArticleResponse::new)
                .toList();

        return ResponseEntity.ok()
                .body(articles);
    }


}
