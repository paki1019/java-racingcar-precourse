package racingcar.model;

import java.util.Objects;

import camp.nextstep.edu.missionutils.Randoms;

public class Progress {
	private static final int RANDOM_RANGE_START = 0;
	private static final int RANDOM_RANGE_END = 9;
	private static final int FORWARD_CONDITION = 4;
	private static final int FORWARD_PROGRESS = 1;

	private final int progress;

	public Progress(int progress) {
		validate(progress);
		this.progress = progress;
	}

	public static Progress from(int progress) {
		return new Progress(progress);
	}

	private void validate(int progress) {
		if (progress < 0) {
			throw new IllegalArgumentException();
		}
	}

	public int getProgress() {
		return progress;
	}

	public Progress tryForward() {
		int random = Randoms.pickNumberInRange(RANDOM_RANGE_START, RANDOM_RANGE_END);
		if (random >= FORWARD_CONDITION) {
			return new Progress(this.progress + FORWARD_PROGRESS);
		}
		return this;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Progress progress1 = (Progress)o;
		return getProgress() == progress1.getProgress();
	}

	@Override
	public int hashCode() {
		return Objects.hash(getProgress());
	}
}
