package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.model.CarNames;

public class InputCarNames {
	private CarNames carNames;
	private boolean retry;

	public CarNames readCarNames() {
		do {
			tryReadCarNames();
		} while (retry);
		return this.carNames;
	}

	private void tryReadCarNames() {
		try {
			System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
			String input = Console.readLine();
			this.carNames = CarNames.generate(input);
			this.retry = false;
		} catch (IllegalArgumentException e) {
			System.out.println("[ERROR] " + e.getMessage());
			this.retry = true;
		}
	}
}
