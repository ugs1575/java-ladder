package laddergame.domain;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class LadderTest {

	@Test
	public void 사다리_문자열_생성() {
		Player player1 = new Player("pobi");
		Player player2 = new Player("honux");
		Player player3 = new Player("crong");
		Player player4 = new Player("jk");
		Line line1 = new Line(asList(Boolean.FALSE, Boolean.TRUE, Boolean.FALSE, Boolean.TRUE));
		Line line2 = new Line(asList(Boolean.FALSE, Boolean.FALSE, Boolean.TRUE, Boolean.FALSE));
		Line line3 = new Line(asList(Boolean.FALSE, Boolean.TRUE, Boolean.FALSE, Boolean.FALSE));
		Line line4 = new Line(asList(Boolean.FALSE, Boolean.FALSE, Boolean.TRUE, Boolean.FALSE));
		Line line5 = new Line(asList(Boolean.FALSE, Boolean.TRUE, Boolean.FALSE, Boolean.TRUE));

		Ladder ladder = new Ladder(
				asList(player1, player2, player3, player4),
				asList(line1, line2, line3, line4, line5)
		);

		assertThat(ladder.draw())
				.isEqualTo(" pobi honux crong    jk\n"
						 + "     |-----|     |-----|\n"
						 + "     |     |-----|     |\n"
				         + "     |-----|     |     |\n"
				         + "     |     |-----|     |\n"
				         + "     |-----|     |-----|");
	}
}
