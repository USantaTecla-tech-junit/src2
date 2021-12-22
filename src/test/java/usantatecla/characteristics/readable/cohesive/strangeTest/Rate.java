package usantatecla.characteristics.readable.cohesive.strangeTest;

public class Rate {

	private static final ClosedInterval RATE_INTERVAL = new ClosedInterval(0,10);
	
	private double value;
	
	private double minimum;
	
	private static final ClosedInterval PERCENT_INTERVAL = new ClosedInterval(0,1);
	
	private double percent;
	
	public Rate(double minimum, double percent){
		assert RATE_INTERVAL.includes(minimum);
		assert PERCENT_INTERVAL.includes(percent);
		this.minimum = minimum;
		this.percent = percent;
	}
	
	public Rate(double percent){
		this(0,percent);
	}
	
	public Rate(){
		this(0,1);
	}
	
	public double getMinimum() {
		return minimum;
	}

	public double getPercent() {
		return percent;
	}

	public void setValue(double value){
		assert RATE_INTERVAL.includes(value);
		this.value = value;
	}
	
	public double getValue() {
		return value;
	}
	
	public boolean isQualifiable() {
		return value >= minimum;
	}	
	
	public double getResult() {
		assert this.isQualifiable();
		return value * percent;
	}
}
