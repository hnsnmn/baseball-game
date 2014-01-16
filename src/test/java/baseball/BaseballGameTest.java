package baseball;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.fail;

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
	public void givenNullGuessNumber_throwIllegalArgEx() {
		try {
			game.guess(null);
			fail();
		} catch (IllegalArgumentException e) {
		}
	}

	@Test
	public void givenInvalidLengthOfGuessNumber_throwIllegalArgEx() {
		try {
			game = new Game();
			game.guess("12");
			fail();
		} catch (IllegalArgumentException e) {
		}
	}


	private class Game {
		public void guess(String guessNum) {
			if (guessNum == null) throw new IllegalArgumentException();
			if (guessNum.length() != 3) throw new IllegalArgumentException();
		}
	}
}
