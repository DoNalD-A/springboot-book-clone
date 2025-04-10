package song.springbootdeveloper.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import song.springbootdeveloper.domain.Article;
import song.springbootdeveloper.dto.AddArticleRequest;
import song.springbootdeveloper.dto.UpdateArticleRequest;
import song.springbootdeveloper.repository.BlogRepository;

import java.util.List;

@RequiredArgsConstructor //final, @NotNull이 붙은 필드를 포함하는 생성자 즉 초기화가 필요한 필드만 포함 + 불변 객체 설계에 사용
@Service
public class BlogServiceTest {

    private final BlogRepository blogRepository;

    //글 추가 메서드
    public Article save(AddArticleRequest request) {
        return blogRepository.save(request.toEntity());
        /* return ~~~와 아래 코드는 완전히 같다
        Article tmpArticle = request.toEntity();
        return blogRepository.save(tmpArticle);
        */
    }

    //모든 글 확인 메서드
    public List<Article> findAll(){
        return blogRepository.findAll();
    }

    //1개 글 확인 메서드
    public Article findById(long id) {
        return blogRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found: " + id));
    }

    //1개 글 삭제 메서드
    public void delete(long id) {
        blogRepository.deleteById(id);
    }

    //글 수정 메서드
    @Transactional
    public Article update(long id, UpdateArticleRequest request) {
        Article article = blogRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found: " + id));

        article.update(request.getTitle(), request.getContent());
        return article;
    }

}
