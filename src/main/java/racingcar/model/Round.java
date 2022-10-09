package racingcar.model;

import java.util.HashMap;
import java.util.Map;

public class Round {
	private final Map<CarName, Progress> carNameProgress;

	private Round(Map<CarName, Progress> carNameProgress) {
		this.carNameProgress = carNameProgress;
	}

	public static Round start(CarNameList carNameList) {
		Map<CarName, Progress> map = new HashMap<>();
		carNameList.getList().forEach(carName -> map.put(carName, Progress.from(0)));
		return new Round(map);
	}

	public Round next() {
		Map<CarName, Progress> map = new HashMap<>();
		map.forEach((carName, progress) -> map.put(carName, progress.tryForward()));
		return new Round(map);
	}

	public Map<CarName, Progress> getCarNameProgress() {
		return carNameProgress;
	}
}
