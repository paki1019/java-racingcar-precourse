package racingcar.model;

public class GameResult {
	private final RoundResult roundResult;
	private final FinalWinnerResult finalWinnerResult;

	private GameResult(RoundResult roundResult, FinalWinnerResult finalWinnerResult) {
		this.roundResult = roundResult;
		this.finalWinnerResult = finalWinnerResult;
	}

	public static GameResult generate(RoundResult roundResult, FinalWinnerResult finalWinnerResult) {
		return new GameResult(roundResult, finalWinnerResult);
	}

	public FinalWinnerResult getFinalWinnerResult() {
		return finalWinnerResult;
	}

	public RoundResult getRoundResult() {
		return roundResult;
	}
}
