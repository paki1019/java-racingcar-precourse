package racingcar.model;

public class CarName {
	private static final int CAR_NAME_MAX_LENGTH = 5;
	private final String carName;

	private CarName(String carName) {
		validate(carName);
		this.carName = carName;
	}

	public static CarName generate(String carName) {
		return new CarName(carName);
	}

	private void validate(String carName) {
		if (carName.length() > CAR_NAME_MAX_LENGTH) {
			throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
		}

		if (carName.trim().isEmpty()) {
			throw new IllegalArgumentException("자동차 이름이 공백일 수는 없습니다.");
		}
	}
}
