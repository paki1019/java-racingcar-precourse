package racingcar.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class RacingCarGame {
	private final CarNameList carNameList;
	private final RoundCount roundCount;

	private Round currentRound;

	public RacingCarGame(CarNameList carNameList, RoundCount roundCount) {
		this.carNameList = carNameList;
		this.roundCount = roundCount;
	}

	public GameResult play() {
		List<Round> roundList = new ArrayList<>();
		for (int i = 0; i < roundCount.getValue(); i++) {
			playRound();
			roundList.add(this.currentRound);
		}
		RoundResult roundResult = RoundResult.from(roundList);
		WinnerList winnerList = WinnerList.from(currentRound);
		return GameResult.generate(roundResult, winnerList);
	}

	private void playRound() {
		if (Objects.isNull(currentRound)) {
			this.currentRound = Round.start(carNameList);
		}
		this.currentRound = this.currentRound.next(carNameList);
	}
}
