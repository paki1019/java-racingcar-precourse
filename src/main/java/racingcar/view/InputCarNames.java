package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputCarNames {
	private racingcar.model.InputCarNames inputCarNames;
	private boolean retry;

	public racingcar.model.InputCarNames readCarNames() {
		do {
			tryReadCarNames();
		} while (retry);
		return this.inputCarNames;
	}

	private void tryReadCarNames() {
		try {
			System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
			String input = Console.readLine();
			this.inputCarNames = racingcar.model.InputCarNames.generate(input);
			this.retry = false;
		} catch (IllegalArgumentException e) {
			System.out.println("[ERROR] " + e.getMessage());
			this.retry = true;
		}
	}
}
