package onboarding;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class BankTest {

    @DisplayName("출금")
    @ParameterizedTest
    @CsvSource(value = {"50237-1,0,0,0,0,2,0,3,7"},delimiter = '-')
    void withdraw(Integer money, List<Integer> count) {
        Bank bank = new Bank();
        assertThat(bank.withdraw(money)).isEqualTo(count);
    }

}
