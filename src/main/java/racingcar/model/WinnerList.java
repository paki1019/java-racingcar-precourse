package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class WinnerList {
	private final List<CarName> carNameList = new ArrayList<>();

	private WinnerList(Round round) {
		Progress maxProgress = round.getMaxProgress();
		round.getCarNameProgress().forEach(
			(carName, progress) -> addWinnerCarName(maxProgress, carName, progress));
	}

	public static WinnerList from(Round round) {
		return new WinnerList(round);
	}

	private void addWinnerCarName(Progress maxProgress, CarName carName, Progress progress) {
		if (progress.equals(maxProgress)) {
			carNameList.add(carName);
		}
	}

	public String getConcatNames() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(carNameList.get(0).getValue());
		for (int i = 1; i < carNameList.size(); i++) {
			stringBuilder.append(String.format(",%s", carNameList.get(i).getValue()));
		}
		return stringBuilder.toString();
	}
}
