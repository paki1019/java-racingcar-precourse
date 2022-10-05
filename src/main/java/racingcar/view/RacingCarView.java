package racingcar.view;

import java.util.Arrays;

import camp.nextstep.edu.missionutils.Console;
import racingcar.model.CarNames;

public class RacingCarView {

	public CarNames InputCarNames() {
		System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분");
		String str = Console.readLine();
		return CarNames.generate(Arrays.asList(str.split(",")));
	}
}
