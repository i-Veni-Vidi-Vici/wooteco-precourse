package pairmatching.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CrewTest {
    Crew crew;

    @BeforeEach
    void beforeEach() {
        crew = new Crew();
    }

    @DisplayName("페어 매칭")
    @Test
    void match() {
        assertThat(crew.match("백엔드, 레벨1, 자동차경주")).isNotEqualTo(Arrays.asList("백호", "태웅", "치수", "태섭",
                "대만", "준호", "대협", "덕규", "태산", "경태", "수겸", "현준",
                "준섭", "한나", "소연", "호열", "대남", "용팔", "구식", "달재"));
    }

    @DisplayName("페어 매칭 정보 확인")
    @Test
    void checkMatching() {
        assertThat(crew.checkMatching("백엔드, 레벨1, 자동차경주")).isFalse();

        crew.match("백엔드, 레벨1, 자동차경주");
        assertThat(crew.checkMatching("백엔드, 레벨1, 자동차경주")).isTrue();
    }

    @DisplayName("페어 매칭 조회")
    @Test
    void search() {
        List<String> pairCrew = crew.match("백엔드, 레벨1, 자동차경주");

        assertThat(crew.search("백엔드, 레벨1, 자동차경주")).isEqualTo(pairCrew);
    }

    @DisplayName("초기화")
    @Test
    void initialize() {
        crew.match("백엔드, 레벨1, 자동차경주");
        crew.initialize();
        assertThat(crew.checkMatching("백엔드, 레벨1, 자동차경주")).isFalse();
    }
}
