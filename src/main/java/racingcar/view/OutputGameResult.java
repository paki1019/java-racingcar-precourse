package racingcar.view;

import java.util.List;

import racingcar.model.GameResult;
import racingcar.model.RoundResult;

public class OutputGameResult {
	public void print(GameResult gameResult) {
		System.out.print("\n");
		System.out.println("실행 결과");
		printRoundsResultList(gameResult);
		printFinalWinnerResult(gameResult);
	}

	private void printRoundsResultList(GameResult gameResult) {
		List<RoundResult> roundResultList = gameResult.getRoundResultList();
		for (RoundResult roundResult : roundResultList) {
			printRoundsResult(roundResult);
		}
	}

	private void printRoundsResult(RoundResult roundResult) {
		roundResult.getMap()
			.forEach((carName, progress) ->
				System.out.printf("%s : %s%n", carName.getValue(), progress.getProgressBar()));
		System.out.print("\n");
	}

	private void printFinalWinnerResult(GameResult gameResult) {
		System.out.println("최종 우승자 : " + gameResult.finalWinnerResult());
	}
}
