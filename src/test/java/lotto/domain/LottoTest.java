package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoTest {

    private Lotto lotto;

    @BeforeEach
    void init() {
        List<Integer> numbers = List.of(1,2,3,4,5,6);
        lotto = new Lotto(numbers);
    }

    @DisplayName("로또 번호와 당첨 번호가 3개가 같을 경우, 기댓값 3이 일치해야 한다.")
    @Test
    void compare_number() {
        List<Integer> winningNumbers = List.of(4,5,6,7,8,9);
        int count = lotto.countWinningNumber(winningNumbers);
        assertThat(count).isEqualTo(3);
    }

    @DisplayName("로또 번호가 당첨 번호의 보너스 번호를 가지고 있을 경우, true를 반환한다")
    @Test
    void has_bonus_number() {
        int bonusNumber = 6;
        boolean status = lotto.hasBonusNumber(bonusNumber);
        assertThat(status).isTrue();
    }

    @DisplayName("로또 번호가 당첨 번호의 보너스 번호를 가지고 있지 않을경우, false를 반환한다")
    @Test
    void has_not_bonus_number() {
        int bonusNumber = 7;
        boolean status = lotto.hasBonusNumber(bonusNumber);
        assertThat(status).isFalse();
    }

}
