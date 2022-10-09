package racingcar.model;

import java.util.Collections;
import java.util.List;

public class FinalWinner {
	private final List<CarName> finalWinnerList;

	private FinalWinner(List<CarName> finalWinnerList) {
		this.finalWinnerList = Collections.unmodifiableList(finalWinnerList);
	}

	public static FinalWinner from(List<CarName> finalWinnerList) {
		return new FinalWinner(finalWinnerList);
	}

	public String getResultMessage() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(finalWinnerList.get(0).getValue());
		for (int i = 1; i< finalWinnerList.size(); i++) {
			stringBuilder.append(finalWinnerList.get(i).getValue());
		}
		return stringBuilder.toString();
	}
}
