package racingcar.model;

import java.util.HashMap;
import java.util.Map;

public class RoundResult {
	private final Map<CarName, ProgressBar> map;

	private RoundResult(Map<CarName, ProgressBar> map) {
		this.map = map;
	}

	public static RoundResult from(Map<CarName, Progress> currentGameScore) {
		Map<CarName, ProgressBar> result = new HashMap<>();
		currentGameScore.forEach((carName, progress) ->
			result.put(carName, ProgressBar.from(progress)));
		return new RoundResult(result);
	}

	public Map<CarName, ProgressBar> getMap() {
		return map;
	}
}
