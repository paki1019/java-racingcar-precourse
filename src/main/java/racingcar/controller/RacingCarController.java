package racingcar.controller;

import racingcar.model.InputCarNames;
import racingcar.view.RacingCarView;

public class RacingCarController {
	private final RacingCarView racingCarView;

	public RacingCarController(RacingCarView racingCarView) {
		this.racingCarView = racingCarView;
	}

	public void run() {
		InputCarNames inputCarNames = racingCarView.inputCarNames();
	}
}
