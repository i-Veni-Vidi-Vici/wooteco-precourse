package pairmatching.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CrewTest {

    @DisplayName("페어 매칭")
    @Test
    void match(){
        Crew crew = new Crew();

        assertThat(crew.match()).isEqualTo();
    }
}
