package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.model.InputCarNames;

public class RacingCarView {

	public InputCarNames InputCarNames() {
		System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분");
		String input = Console.readLine();
		return InputCarNames.generate(input);
	}
}
