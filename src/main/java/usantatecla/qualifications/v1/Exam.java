package usantatecla.qualifications.v1;

public abstract class Exam {
	protected String name;
	protected Rate rate;

	protected Exam(String name, Rate rate) {
		assert name != null && !name.equals("");
		assert rate != null;

		this.name = name;
		this.rate = rate;
	}
	
	public double getResult() {
		assert this.isQualifiable();

		return rate.getResult();
	}

	public boolean isQualifiable(){
		return rate.isQualifiable();
	}

	public String getName() {
		return name;
	}

	public double getPercent() {
		return rate.getPercent();
	}

	public double getValue() {
		return rate.getValue();
	}

	public abstract void setValue(double value, String... pathName);

	@Override
	public String toString() {
		return "name=" + name + ", rate=" + rate + "";
	}

}
