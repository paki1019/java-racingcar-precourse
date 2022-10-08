package racingcar.model;

import java.util.List;

public class GameResult {
	private final List<RoundResult> roundResultList;
	private final FinalWinnerResult finalWinnerResult;

	private GameResult(List<RoundResult> roundResultList, FinalWinnerResult finalWinnerResult) {
		this.roundResultList = roundResultList;
		this.finalWinnerResult = finalWinnerResult;
	}

	public static GameResult generate(List<RoundResult> roundResultList, FinalWinnerResult finalWinnerResult) {
		return new GameResult(roundResultList, finalWinnerResult);
	}

	public String finalWinnerResult() {
		return null;
	}

	public List<RoundResult> getRoundResultList() {
		return roundResultList;
	}
}
