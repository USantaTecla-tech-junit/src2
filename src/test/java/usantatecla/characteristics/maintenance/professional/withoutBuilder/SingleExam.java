package usantatecla.characteristics.maintenance.professional.withoutBuilder;

public class SingleExam extends Exam {

	public SingleExam(String name, Rate rate){
		super(name, rate);
	}
	
	public SingleExam(String name){
		this(name, new Rate());
	}

	@Override
	public boolean isQualifiable() {
		return rate.isQualifiable();
	}
	
}
