package baseball;

/**
* Created with IntelliJ IDEA.
* User: hongseongmin
* Date: 2014. 1. 16.
* Time: 오후 6:29
* To change this template use File | Settings | File Templates.
*/
class Game {
	private String number;
	private GameNumberGenerator gameNumberGenerator;

	public GuessResult guess(String guessNum) {
		assertGuessNumberValid(guessNum);
		if (solved(guessNum))
			return new GuessResult(true, 3, 0);
		else {
			int strike = 0;
			int balls = 0;
			for (int i = 0; i < number.length(); i++) {
				int idx = number.indexOf(guessNum.charAt(i));
				if (idx == i) strike++;
				else if (idx > -1) balls++;
			}
			return new GuessResult(false, strike, balls);
		}
	}

	private boolean solved(String guessNum) {
		return number.equals(guessNum);
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

	public void generateNumber() {
		this.number = gameNumberGenerator.generate();
	}

	public void setGameNumberGenerator(GameNumberGenerator gameNumberGenerator) {
		this.gameNumberGenerator = gameNumberGenerator;
	}

}
