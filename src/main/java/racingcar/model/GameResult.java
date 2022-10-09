package racingcar.model;

public class GameResult {
	private final RoundResult roundResult;
	private final WinnerList winnerList;

	private GameResult(RoundResult roundResult, WinnerList winnerList) {
		this.roundResult = roundResult;
		this.winnerList = winnerList;
	}

	public static GameResult generate(RoundResult roundResult, WinnerList winnerList) {
		return new GameResult(roundResult, winnerList);
	}

	public String getFinalWinnerResult() {
		return winnerList.getResultMessage();
	}

	public RoundResult getRoundResult() {
		return roundResult;
	}
}
