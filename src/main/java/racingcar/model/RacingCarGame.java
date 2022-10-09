package racingcar.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RacingCarGame {
	private static final int ZERO = 0;
	private final CarNames carNames;
	private final RoundCount roundCount;

	private final Map<CarName, Progress> currentGameScore = new HashMap<>();

	public RacingCarGame(CarNames carNames, RoundCount roundCount) {
		this.carNames = carNames;
		this.roundCount = roundCount;
	}

	public GameResult play() {
		List<RoundResult> roundResultList = new ArrayList<>();
		for (int i = 0; i < roundCount.getValue(); i++) {
			roundResultList.add(playRound());
		}
		FinalWinnerResult finalWinnerResult = new FinalWinnerResult();
		return GameResult.generate(roundResultList, finalWinnerResult);
	}

	private RoundResult playRound() {
		carNames.getCarNames().forEach(carName -> {
			Progress nowProgress = currentGameScore.getOrDefault(carName, Progress.from(ZERO));
			currentGameScore.put(carName, nowProgress.tryForward());
		});
		return RoundResult.from(new HashMap<>(currentGameScore));
	}
}
