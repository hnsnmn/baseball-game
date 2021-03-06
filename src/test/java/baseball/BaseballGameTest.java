package baseball;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.fail;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created with IntelliJ IDEA.
 * User: hongseongmin
 * Date: 2014. 1. 15.
 * Time: 오후 11:02
 * To change this template use File | Settings | File Templates.
 */
public class BaseballGameTest {

	private Game game;

	@Before
	public void setUp() throws Exception {
		game = new Game();
	}

	@Test
	public void givenInvalideGuessNumber_throwIllegalArgEx() {
		// 값이 비 정상적인 테스트 케이스
		assertIllegalArgExThrown(null);
		assertIllegalArgExThrown("12");

		assertIllegalArgExThrown("12a");
		assertIllegalArgExThrown("a45");

		assertIllegalArgExThrown("113");
		assertIllegalArgExThrown("011");
		assertIllegalArgExThrown("141");
	}

	@Test
	public void givenExactMatchingGuessNum_returnSolvedResult() {
		generateGameNumber("123");
		assertSolvedGuessResult("123");

		generateGameNumber("456");
		assertSolvedGuessResult("456");

		assertNonSolvedResult("789", false, 0, 0);
	}

	private void assertSolvedGuessResult(String guessNum) {
		assertNonSolvedResult(guessNum, true, 3, 0);
	}

	private void generateGameNumber(final String gameNumber) {
		game.setGameNumberGenerator(new GameNumberGenerator() {
			@Override
			public String generate() {
				return gameNumber;
			}
		});
		game.generateNumber();
	}

	private void assertGuessResult(String guessNum, boolean solved, int stirke, int balls) {
		GuessResult guessResult = game.guess(guessNum);
		assertThat(guessResult.isSolved(), is(solved));
		assertThat(guessResult.getStrike(), is(stirke));
		assertThat(guessResult.getBalls(), is(balls));
	}


	private void assertIllegalArgExThrown(String guessNum) {
		try {
			game.guess(guessNum);
			fail();
		} catch (IllegalArgumentException e) {
		}
	}

	@Test
	public void givenSomeMatchingGuessNm_returnNonSolvedResult() {
		generateGameNumber("123");
		// strikes
		assertNonSolvedResult("724", false, 1, 0);
		assertNonSolvedResult("523", false, 2, 0);
		assertNonSolvedResult("129", false, 2, 0);
		assertNonSolvedResult("093", false, 1, 0);

		// ball
		assertNonSolvedResult("517", false, 0, 1);
		assertNonSolvedResult("297", false, 0, 1);
		assertNonSolvedResult("539", false, 0, 1);

		// 2ball and 3ball
		assertNonSolvedResult("531", false, 0, 2);
		assertNonSolvedResult("231", false, 0, 3);

		// strike and ball
		assertNonSolvedResult("132", false, 1, 2);
		assertNonSolvedResult("134", false, 1, 1);
		assertNonSolvedResult("321", false, 1, 2);

	}

	private void assertNonSolvedResult(String guessNum, boolean solved, int stirke, int balls) {
		assertGuessResult(guessNum, solved, stirke, balls);
	}

}
