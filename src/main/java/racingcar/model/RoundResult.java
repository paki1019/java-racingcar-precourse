package racingcar.model;

import java.util.HashMap;
import java.util.Map;

public class RoundResult {
	private final Map<CarName, ProgressBar> roundResult = new HashMap<>();

	public Map<CarName, ProgressBar> getRoundResult() {
		return roundResult;
	}
}
