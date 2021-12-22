package usantatecla.blackBox.equivalenceClasses.ratings;

public class RateBuilder {

	private double value;
	
	private double minimum;
	
	private double percent;
	
	public RateBuilder(){
		value = 0.0;
		minimum = 0.0;
		percent = 1.0;
	}
	
	public RateBuilder value(double value){
		this.value = value;
		return this;
	}
	
	public RateBuilder minimum(double minimum){
		this.minimum = minimum;
		return this;
	}
	
	public RateBuilder percent(double percent){
		this.percent = percent;
		return this;
	}
	
	public Rate build(){
		Rate rate = new Rate(minimum, percent);
		rate.setValue(value);
		return rate;
	}
}
