package usantatecla.characteristics.executable.independent.hiddenDependencieTest;

public class ClosedInterval {

	private double min;

	private double max;

	public ClosedInterval(double min, double max) {
		assert min <= max;
		this.min = min;
		this.max = max;
	}

	public double getLength() {
		return max - min;
	}
	
	public double getMiddlePoint() {
		return (max + min)/2;
	}

	public void shift(double value) {
		min += value;
		max += value;
	}

	public boolean includes(double value) {
		return min <= value && value <= max;
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
		return new ClosedInterval(
				Math.max(min, closedInterval.min), 
				Math.min(max, closedInterval.max));
	}
	
	public ClosedInterval union(ClosedInterval closedInterval) {
		assert closedInterval != null;
		assert this.intersected(closedInterval);
		return new ClosedInterval(
				Math.min(min, closedInterval.min), 
				Math.max(max, closedInterval.max));
	}

}
