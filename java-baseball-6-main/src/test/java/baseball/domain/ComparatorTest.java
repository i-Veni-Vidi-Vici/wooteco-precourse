package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class ComparatorTest {

    @DisplayName("스트라이크 수 계산-> 3개")
    @Test
    void calculateStrikeByThreeMatch(){
        Comparator comparator = new Comparator();

        assertThat(comparator.calculateStrike(List.of(1,2,3), List.of(1,2,3))).isEqualTo(3);
    }

    @DisplayName("스트라이크 수 계산-> 2개")
    @Test
    void calculateStrikeByTwoMatch(){
        Comparator comparator = new Comparator();

        assertThat(comparator.calculateStrike(List.of(1,2,3), List.of(1,2,4))).isEqualTo(2);
    }

    @DisplayName("스트라이크 수 계산-> 1개")
    @Test
    void calculateStrikeByOneMatch(){
        Comparator comparator = new Comparator();

        assertThat(comparator.calculateStrike(List.of(1,2,3), List.of(1,4,5))).isEqualTo(1);
        assertThat(comparator.calculateStrike(List.of(1,2,3), List.of(1,3,2))).isEqualTo(1);
    }

    @DisplayName("스트라이크 수 계산-> 0개")
    @Test
    void calculateStrikeByZeroMatch(){
        Comparator comparator = new Comparator();

        assertThat(comparator.calculateStrike(List.of(1,2,3), List.of(4,5,6))).isEqualTo(0);
        assertThat(comparator.calculateStrike(List.of(1,2,3), List.of(3,1,2))).isEqualTo(0);
        assertThat(comparator.calculateStrike(List.of(1,2,3), List.of(2,3,1))).isEqualTo(0);
    }

    @DisplayName("볼 수 계산-> 3개")
    @Test
    void calculateBallByThreeMatch(){
        Comparator comparator = new Comparator();

        assertThat(comparator.calculateBall(List.of(1,2,3), List.of(3,1,2))).isEqualTo(3);
        assertThat(comparator.calculateBall(List.of(1,2,3), List.of(2,3,1))).isEqualTo(3);
    }

    @DisplayName("볼 수 계산-> 2개")
    @Test
    void calculateBallByTwoMatch(){
        Comparator comparator = new Comparator();

        assertThat(comparator.calculateBall(List.of(1,2,3), List.of(3,1,4))).isEqualTo(2);
        assertThat(comparator.calculateBall(List.of(1,2,3), List.of(3,2,1))).isEqualTo(2);
    }

    @DisplayName("볼 수 계산-> 1개")
    @Test
    void calculateBallByOneMatch(){
        Comparator comparator = new Comparator();

        assertThat(comparator.calculateBall(List.of(1,2,3), List.of(4,5,1))).isEqualTo(1);
        assertThat(comparator.calculateBall(List.of(1,2,3), List.of(2,4,3))).isEqualTo(1);
    }

    @DisplayName("볼 수 계산-> 0개")
    @Test
    void calculateBallByZeroMatch(){
        Comparator comparator = new Comparator();

        assertThat(comparator.calculateBall(List.of(1,2,3), List.of(4,5,6))).isEqualTo(0);
        assertThat(comparator.calculateBall(List.of(1,2,3), List.of(1,2,3))).isEqualTo(0);
    }



}
