package song.springbootdeveloper.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import song.springbootdeveloper.domain.Article;
import song.springbootdeveloper.dto.AddArticleRequest;
import song.springbootdeveloper.repository.BlogRepository;

@RequiredArgsConstructor //final, @NotNull이 붙은 필드를 포함하는 생성자 즉 초기화가 필요한 필드만 포함 + 불변 객체 설계에 사용
@Service
public class BlogService {

    private final BlogRepository blogRepository;

    //블로그 글 추가 메서드
    public Article save(AddArticleRequest request) {
        return blogRepository.save(request.toEntity());
        /* return ~~~와 아래 코드는 완전히 같다
        Article tmpArticle = request.toEntity();
        return blogRepository.save(tmpArticle);
        */
    }
}
