package racingcar.controller;

import racingcar.model.CarNames;
import racingcar.model.GameResult;
import racingcar.model.RacingCarGame;
import racingcar.model.RoundCount;
import racingcar.view.InputCarNames;
import racingcar.view.InputRoundCount;
import racingcar.view.OutputGameResult;

public class RacingCarController {

	public void run() {
		CarNames carNames = new InputCarNames().read();
		RoundCount roundCount = new InputRoundCount().read();
		RacingCarGame racingCarGame = new RacingCarGame(carNames, roundCount);
		GameResult gameResult = racingCarGame.play();
		OutputGameResult outputGameResult = new OutputGameResult();
		outputGameResult.print(gameResult);
	}
}
