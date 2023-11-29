package onboarding;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SocialNetworkingServiceTest {

    @DisplayName("친구 추천")
    @Test
    void recommend() {
        SocialNetworkingService sns = new SocialNetworkingService();

        assertThat(sns.recommend("mrko", List.of(
                List.of("donut", "andole"),
                List.of("donut", "jun"),
                List.of("donut", "mrko"),
                List.of("shakevan", "andole"),
                List.of("shakevan", "jun"),
                List.of("shakevan", "mrko")
        ), List.of("bedi", "bedi", "donut", "bedi", "shakevan"))).isEqualTo(List.of("andole", "jun", "bedi"));
    }
}
