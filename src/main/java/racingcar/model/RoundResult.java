package racingcar.model;

import java.util.Map;

public class RoundResult {
	private final Map<CarName, Progress> map;

	private RoundResult(Map<CarName, Progress> map) {
		this.map = map;
	}

	public static RoundResult from(Map<CarName, Progress> currentGameScore) {
		return new RoundResult(currentGameScore);
	}

	public Map<CarName, Progress> getMap() {
		return map;
	}
}
