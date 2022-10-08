package racingcar.controller;

import racingcar.model.CarNames;
import racingcar.model.GameResult;
import racingcar.model.RacingCarGame;
import racingcar.model.Rounds;
import racingcar.view.InputCarNames;
import racingcar.view.InputRounds;
import racingcar.view.OutputGameResult;

public class RacingCarController {

	public void run() {
		CarNames carNames = new InputCarNames().read();
		Rounds rounds = new InputRounds().read();
		RacingCarGame racingCarGame = new RacingCarGame(carNames, rounds);
		GameResult gameResult = racingCarGame.play();
		OutputGameResult outputGameResult = new OutputGameResult();
		outputGameResult.print(gameResult);
	}
}
