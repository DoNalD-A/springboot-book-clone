package song.springbootdeveloper.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import song.springbootdeveloper.domain.Article;
import song.springbootdeveloper.dto.AddArticleRequest;
import song.springbootdeveloper.dto.ArticleResponse;
import song.springbootdeveloper.dto.UpdateArticleRequest;
import song.springbootdeveloper.service.BlogService;

import java.util.List;

@RequiredArgsConstructor
@RestController // @Controller + @ResponseBody = @RestController
public class BlogApiController {

    private final BlogService blogService;

    //게시글 생성 API
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

    //게시글 전체 조회 API
    @GetMapping("/api/articles")
    public ResponseEntity<List<ArticleResponse>> findAllArticles() {
        List<ArticleResponse> articles = blogService.findAll()
                .stream()
                .map(ArticleResponse::new)
                .toList();

        return ResponseEntity.ok()
                .body(articles);
    }

    //게시글 1개 조회 API
    @GetMapping("/api/articles/{id}")
    public ResponseEntity<ArticleResponse> findArticle(@PathVariable long id) {
        Article article = blogService.findById(id);

        return ResponseEntity.ok()
                .body(new ArticleResponse(article));
    }

    //게시글 삭제 API
    @DeleteMapping("/api/articles/{id}")
    public ResponseEntity<Void> deleteArticle(@PathVariable long id) {
        blogService.delete(id);

        return ResponseEntity.ok()
                .build();
    }

    //게시슬 수정 API
    @PutMapping("/api/articles/{id}")
    public ResponseEntity<Article> updateArticle(@PathVariable long id, @RequestBody UpdateArticleRequest request) {
        Article updatedArticle = blogService.update(id, request);

        return ResponseEntity.ok()
                .body(updatedArticle);
    }
}





















