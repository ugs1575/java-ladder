package step2;

import org.junit.jupiter.api.Test;
import step2.model.*;

import java.util.HashMap;
import java.util.List;

import static org.assertj.core.api.Assertions.*;


public class LadderTest {
    @Test
    public void 사다리생성_높이_빈값_null() {
        assertThatThrownBy(() -> new Ladder(null, 5, new RandomLadderStrategy()))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> new Ladder("", 5, new RandomLadderStrategy()))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 사다리생성_높이_0() {
        assertThatThrownBy(() -> new Ladder("0", 5, new RandomLadderStrategy()))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 사다리_크기_체크() {
        //given
        Ladder ladder = new Ladder("5", 4, new RandomLadderStrategy());

        //when
        List<List<Boolean>> result = ladder.getLadder();

        //then
        assertThat(result.size()).isEqualTo(5);
        for (int i = 0; i < 5; i++) {
            assertThat(result.get(i).size()).isEqualTo(4);
        }
    }

    @Test
    public void 게임_결과() {
        //given
        HashMap<String, String> expectResult = new HashMap<>();
        expectResult.put("user1", "5000");
        expectResult.put("user2", "꽝");
        expectResult.put("user3", "2000");
        expectResult.put("user4", "꽝");

        Users users = new Users("user1, user2, user3, user4");
        Results results = new Results("꽝, 5000, 꽝, 2000", 4);
        Ladder ladder = new Ladder("5", 4, () -> true);

        //when
        HashMap<String, String> gameResult = ladder.getGameResult(users, results);

        //then
        gameResult.forEach((key, value) -> {
            assertThat(expectResult.get(key)).isEqualTo(value);
        });
    }

}
