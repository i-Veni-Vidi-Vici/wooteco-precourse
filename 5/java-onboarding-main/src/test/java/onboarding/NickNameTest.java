package onboarding;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class NickNameTest {

    @DisplayName("닉네임 중 같은 글자가 연속으로 포함되면, 이메일 반환")
    @Test
    void checkDuplication() {
        NickName nickName = new NickName();

        assertThat(nickName.checkDuplication(List.of(
                List.of("jm@email.com", "제이엠"),
                List.of("jason@email.com", "제이슨"),
                List.of("woniee@email.com", "워니"),
                List.of("mj@email.com", "엠제이"),
                List.of("nowm@email.com", "이제엠")
        ))).isEqualTo(List.of("jason@email.com", "jm@email.com", "mj@email.com"));
    }
}
