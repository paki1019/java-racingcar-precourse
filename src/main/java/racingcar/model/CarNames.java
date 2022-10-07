package racingcar.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CarNames {
	private static final String COMMA = ",";
	private static final String EMPTY = "";

	private final List<CarName> carNames;

	private CarNames(String input) {
		String trimmedInput = input.trim();
		validate(trimmedInput);
		List<CarName> carNameList = convertCarNameList(trimmedInput);
		this.carNames = Collections.unmodifiableList(carNameList);
	}

	public static CarNames generate(String input) {
		return new CarNames(input);
	}

	private List<CarName> convertCarNameList(String trimmedInput) {
		List<CarName> list = new ArrayList<>();
		for (String carName : trimmedInput.split(COMMA)) {
			list.add(CarName.generate(carName));
		}
		return list;
	}

	private void validate(String trimmedInput) {
		if (trimmedInput.isEmpty()) {
			throw new IllegalArgumentException("경주할 자동차 이름을 입력해 주세요.");
		}
		if (trimmedInput.replace(COMMA, EMPTY).isEmpty()) {
			throw new IllegalArgumentException("경주할 자동차 이름을 입력해 주세요.");
		}
	}

	public List<CarName> getCarNames() {
		return carNames;
	}
}
