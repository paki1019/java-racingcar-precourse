package racingcar.controller;

import racingcar.model.CarNames;
import racingcar.view.RacingCarView;

public class RacingCarController {
	private final RacingCarView racingCarView;

	public RacingCarController(RacingCarView racingCarView) {
		this.racingCarView = racingCarView;
	}

	public void run() {
		CarNames carNames = racingCarView.InputCarNames();
	}
}
