package baseball;

/**
* Created with IntelliJ IDEA.
* User: hongseongmin
* Date: 2014. 1. 16.
* Time: 오후 6:29
* To change this template use File | Settings | File Templates.
*/
class Game {
	public String number;

	public GuessResult guess(String guessNum) {
		assertGuessNumberValid(guessNum);
		return new GuessResult();
	}

	private void assertGuessNumberValid(String guessNum) {
		if (guessNum == null) throw new IllegalArgumentException();
		if (guessNum.length() != 3) throw new IllegalArgumentException();
		for (char ch : guessNum.toCharArray())
			if (ch < '0' || ch > '9')
				throw new IllegalArgumentException();
		if (guessNum.charAt(0) == guessNum.charAt(1) ||
				guessNum.charAt(1) == guessNum.charAt(2) ||
				guessNum.charAt(0) == guessNum.charAt(2))
			throw new IllegalArgumentException();
	}
}
