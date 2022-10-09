package racingcar.model;

import java.util.List;

public class RoundResult {
	private final List<Round> RoundList;

	private RoundResult(List<Round> RoundList) {
		this.RoundList = RoundList;
	}

	public static RoundResult from(List<Round> roundList) {
		return new RoundResult(roundList);
	}

	public List<Round> getRoundList() {
		return RoundList;
	}
}
