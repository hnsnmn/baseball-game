package baseball;

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
	@Test
	public void givenNullGuessNumber_throwIllegalArgEx() {
		Game game = new Game();
		try {
			game.guess(null);
			fail();
		} catch (IllegalArgumentException e) {
		}
	}

	@Test
	public void givenInvalidLengthOfGuessNumber_throwIllegalArgEx() {
		Game game = new Game();
		try {
			game.guess("12");
			fail();
		} catch (IllegalArgumentException e) {
		}
	}


	private class Game {
		public void guess(String guessNum) {
			if (guessNum == null) throw new IllegalArgumentException();
		}
	}
}
