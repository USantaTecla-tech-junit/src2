package usantatecla.qualifications.v3;

public class Rate {
	private double value;
	private double minimum;
	static final double MAXIMUM_VALUE = 10;
	static final ClosedInterval VALUE_INTERVAL 
		= new ClosedInterval(0, Rate.MAXIMUM_VALUE);
		private double percent;
  public static final double MAXIMUM_PERCENT = 1;
	static final ClosedInterval PERCENT_INTERVAL 
		= new ClosedInterval(0, Rate.MAXIMUM_PERCENT);

	public Rate(double percent, double minimum) {
		assert VALUE_INTERVAL.includes(minimum);
		assert PERCENT_INTERVAL.includes(percent);

		this.percent = percent;
		this.minimum = minimum;
	}

	public Rate(double percent) {
		this(percent, 0.0);
	}

	public Rate() {
		this(Rate.MAXIMUM_PERCENT);
	}

	public boolean isQualifiable() {
		return value >= minimum;
	}

	public double getResult() {
		assert this.isQualifiable();

		return value * percent;
	}

	public void setValue(double value) {
		assert VALUE_INTERVAL.includes(value);

		this.value = value;
	}

	public double getValue() {
		return value;
	}

	public double getPercent() {
		return percent;
	}

	public double getMinimum() {
		return minimum;
	}

	@Override
	public String toString() {
		return "Rate [minimum=" + minimum + ", percent=" + percent + ", value=" + value + "]";
	}

}
