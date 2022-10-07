package racingcar.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class InputCarNames {
	private final List<CarName> carNames;

	private InputCarNames(String input) {
		String trimmedInput = input.trim();
		validate(trimmedInput);
		List<CarName> carNameList = convertCarNameList(trimmedInput);
		this.carNames = Collections.unmodifiableList(carNameList);
	}

	public static InputCarNames generate(String input) {
		return new InputCarNames(input);
	}

	private List<CarName> convertCarNameList(String trimmedInput) {
		List<CarName> list = new ArrayList<>();
		for (String carName : trimmedInput.split(",")) {
			list.add(CarName.generate(carName));
		}
		return list;
	}

	private void validate(String input) {
		if (input.isEmpty()) {
			throw new IllegalArgumentException("자동차 이름 미입력");
		}
	}

	public List<CarName> getCarNames() {
		return carNames;
	}
}
