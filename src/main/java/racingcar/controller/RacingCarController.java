package racingcar.controller;

import racingcar.model.CarNames;
import racingcar.view.InputCarNames;

public class RacingCarController {

	public void run() {
		CarNames carNames = new InputCarNames().readCarNames();
	}
}
