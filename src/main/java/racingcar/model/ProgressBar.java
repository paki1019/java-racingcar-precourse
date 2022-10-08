package racingcar.model;

public class ProgressBar {
	private final String progressBar;

	private ProgressBar(int progress) {
		validate(progress);
		StringBuilder stringBuilder = new StringBuilder();
		for (int i = 0; i < progress; i++) {
			stringBuilder.append("-");
		}
		this.progressBar = stringBuilder.toString();
	}

	public static ProgressBar generate(int i) {
		return new ProgressBar(i);
	}

	private void validate(int progress) {
		if (progress < 0) {
			throw new IllegalArgumentException();
		}
	}

	public String getProgressBar() {
		return progressBar;
	}
}
