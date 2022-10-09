package racingcar.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Round {
	private final Map<CarName, Progress> carNameProgress;

	private Round(Map<CarName, Progress> carNameProgress) {
		this.carNameProgress = Collections.unmodifiableMap(carNameProgress);
	}

	public static Round start(CarNameList carNameList) {
		Map<CarName, Progress> map = new HashMap<>();
		carNameList.getList().forEach(carName -> map.put(carName, Progress.begin()));
		return new Round(map);
	}

	public Round next(CarNameList carNameList) {
		Map<CarName, Progress> map = new HashMap<>();
		carNameList.getList()
			.forEach(carName ->
				map.put(carName, carNameProgress.get(carName).tryForward()));
		return new Round(map);
	}

	public Map<CarName, Progress> getCarNameProgress() {
		return carNameProgress;
	}

	public FinalWinner getFinalWinner() {
		Progress maxProgress = getMaxProgress();
		List<CarName> carNameList = new ArrayList<>();
		carNameProgress.forEach((carName, progress) -> {
			if (progress == maxProgress) {
				carNameList.add(carName);
			}
		});
		return FinalWinner.from(carNameList);
	}

	private Progress getMaxProgress() {
		return Collections.max(carNameProgress.values());
	}
}
