package usantatecla.qualifications.v2.builders;

import usantatecla.qualifications.v2.Rate;

public class RateBuilder {
	private double value;
	private double minimum;
	private double percent;
	
	public RateBuilder(){
		value = 0.0;
		minimum = 0.0;
		percent = Rate.MAXIMUM_PERCENT;;
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
		Rate rate = new Rate(this.percent, this.minimum);
		rate.setValue(this.value);
		return rate;
	}

}
