package racingcar.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CarNames {
	private final List<CarName> carNames;

	private CarNames(List<String> carNames) {
		List<CarName> list = new ArrayList<>();
		for (String carName : carNames) {
			list.add(CarName.generate(carName));
		}
		this.carNames = Collections.unmodifiableList(list);
	}

	public static CarNames generate(List<String> carNames) {
		return new CarNames(carNames);
	}
}
