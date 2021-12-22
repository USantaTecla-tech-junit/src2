package usantatecla.qualifications.v2;

public class SingleExam extends Exam {

	public SingleExam(String name, Rate rate) {
		super(name, rate);
	}

	public SingleExam(String name) {
		this(name, new Rate());
	}

	@Override
	public void setValue(double value, String... pathName) {
		assert pathName.length == 0;

		this.rate.setValue(value);
	}

	@Override
	public String toString() {
		return "SingleExam [" + super.toString() + "]";
	}

	
}
