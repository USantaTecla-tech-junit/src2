package usantatecla.characteristics.readable.cohesive.strangeTest;

public abstract class Exam {
	
	protected String name;
	
	protected Rate rate;
	
	protected Exam(String name, Rate rate){
		assert name != null;
		assert !name.equals("");
		assert rate != null;
		this.name = name;
		this.rate = rate;
	}
	
	public String getName() {
		return name;
	}

	public double getMinimum() {
		return rate.getMinimum();
	}
	
	public double getPercent() {
		return rate.getPercent();
	}
	
	public double getValue() {
		return rate.getValue();
	}
	
	public abstract boolean isQualifiable();
	
	public double getResult() {
		assert this.isQualifiable();
		return rate.getResult();
	}
}
