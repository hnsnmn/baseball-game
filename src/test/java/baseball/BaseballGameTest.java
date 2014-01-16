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
	public void givenInvalideGuessNumber_throwIllegalArgEx() {
		assertIllegalArgExThrown(null);
		assertIllegalArgExThrown("12");
		assertIllegalArgExThrown("12a");
		assertIllegalArgExThrown("a45");
		assertIllegalArgExThrown("113");
		assertIllegalArgExThrown("011");
		assertIllegalArgExThrown("141");
	}

	private void assertIllegalArgExThrown(String guessNum) {
		try {
			game.guess(guessNum);
			fail();
		} catch (IllegalArgumentException e) {
		}
	}


}
