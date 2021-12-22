package usantatecla.blackBox.equivalenceClasses.ratings;

public abstract class ExamBuilder {

	protected String name;
	
	protected RateBuilder rateBuilder;
	
	protected ExamBuilder(){
		this.name = "examen";
		rateBuilder = new RateBuilder();
	}
	
	public ExamBuilder name(String name){
		this.name = name;
		return this;
	}
	
	public ExamBuilder value(double value){
		rateBuilder.value(value);
		return this;
	}
	
	public ExamBuilder minimum(double minimum){
		rateBuilder.minimum(minimum);
		return this;
	}
	
	public ExamBuilder percent(double percent){
		rateBuilder.percent(percent);
		return this;
	}
	
	protected abstract Exam build();
}
