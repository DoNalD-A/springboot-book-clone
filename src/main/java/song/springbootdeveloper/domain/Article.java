package song.springbootdeveloper.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter //lombok이 제공하는 메서드 -> 필드값을 get하는 메서드를 추가해준다
@NoArgsConstructor(access = AccessLevel.PROTECTED) //기본 생성자(접근 제어자: protected)
public class Article {
    @Id //기본키를 지정
    @GeneratedValue(strategy = GenerationType.IDENTITY) // MySQL의 AUTO_INCREMENT와 같은 기능
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "content", nullable = false)
    private String content;

    @Builder //빌더 패턴 -> 어떤 필드에 값을 할당하는지 확인하기 좋음 (가독성 up)
    public Article(String title, String content) {
        this.title = title;
        this.content = content;
    }

}