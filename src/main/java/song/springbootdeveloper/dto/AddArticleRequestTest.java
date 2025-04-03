package song.springbootdeveloper.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import song.springbootdeveloper.domain.Article;

@NoArgsConstructor //기본 생성자
@AllArgsConstructor //모든 필드 값을 파라미터로 받는 생성자(접근 제어자 무관하게 모두 포함)(static 포함 X)
@Getter //@RequestBody가 JSON데이터 -> AddArticleRequest객체로 매핑할 때 필드에 접근하기 위해 필요
public class AddArticleRequestTest {
    private String title;
    private String content;

    public Article toEntity(){
        return Article.builder() //빌더 패턴 구현 코드
                .title(title)
                .content(content)
                .build();
    }
}
