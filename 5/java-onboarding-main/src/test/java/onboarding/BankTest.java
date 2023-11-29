package onboarding;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BankTest {

    @DisplayName("출금")
    @Test
    void withdraw() {
        Bank bank = new Bank();
        assertThat(bank.withdraw(50237)).isEqualTo(List.of(1,0,0,0,0,2,0,3,7));
    }
}
