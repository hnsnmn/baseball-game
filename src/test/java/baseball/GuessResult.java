package baseball;

/**
 * Created with IntelliJ IDEA.
 * User: hongseongmin
 * Date: 2014. 1. 16.
 * Time: 오후 10:28
 * To change this template use File | Settings | File Templates.
 */
public class GuessResult {
	private boolean solved;
	private int strike;
	private int balls;

	public GuessResult(boolean solved, int strike, int balls) {
		this.solved = solved;
		this.strike = strike;
		this.balls = balls;
	}

	public boolean isSolved() {
		return solved;
	}

	public Integer getStrike() {
		return strike;
	}

	public int getBalls() {
		return balls;
	}
}
