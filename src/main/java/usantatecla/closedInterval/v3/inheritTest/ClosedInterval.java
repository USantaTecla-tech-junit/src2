package usantatecla.closedInterval.v3.inheritTest;

public class ClosedInterval {
	private double min;
	private double max;

	public ClosedInterval(double min, double max) {
		this.min = min;
		this.max = max;
	}

	public double getLength() {
		return this.max - this.min;
	}

	public double getMiddlePoint() {
		return this.min + this.getLength() / 2;
	}

	public ClosedInterval shifted(double value) {
		return new ClosedInterval(this.min + value, this.max + value);
	}

	public boolean includes(double value) {
		return this.min <= value && value <= this.max;
	}

	public boolean includes(ClosedInterval closedInterval) {
		assert closedInterval != null;

		return this.includes(closedInterval.min) 
			&& this.includes(closedInterval.max);
	}

	public boolean intersected(ClosedInterval closedInterval) {
		assert closedInterval != null;

		return this.includes(closedInterval.min) 
			|| this.includes(closedInterval.max) 
			|| closedInterval.includes(this);
	}

	public ClosedInterval intersection(ClosedInterval closedInterval) {
		assert closedInterval != null;
		assert this.intersected(closedInterval);

		return new ClosedInterval(Math.max(min, closedInterval.min), Math.min(max, closedInterval.max));
	}

	public ClosedInterval union(ClosedInterval closedInterval) {
		assert closedInterval != null;
		assert this.intersected(closedInterval);

		return new ClosedInterval(Math.min(min, closedInterval.min), Math.max(max, closedInterval.max));
	}

}
