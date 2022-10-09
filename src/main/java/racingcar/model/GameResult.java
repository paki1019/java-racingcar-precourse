package racingcar.model;

public class GameResult {
	private final RoundResult roundResult;
	private final FinalWinner finalWinner;

	private GameResult(RoundResult roundResult, FinalWinner finalWinner) {
		this.roundResult = roundResult;
		this.finalWinner = finalWinner;
	}

	public static GameResult generate(RoundResult roundResult, FinalWinner finalWinner) {
		return new GameResult(roundResult, finalWinner);
	}

	public String getFinalWinnerResult() {
		return finalWinner.getResultMessage();
	}

	public RoundResult getRoundResult() {
		return roundResult;
	}
}
