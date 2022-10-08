package racingcar.view;

import racingcar.model.CarNames;

public class InputCarNames extends Input<CarNames> {
	@Override
	String message() {
		return "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
	}

	@Override
	CarNames generate(String input) {
		return CarNames.generate(input);
	}
}
