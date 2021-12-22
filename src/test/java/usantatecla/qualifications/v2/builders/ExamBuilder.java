package usantatecla.qualifications.v2.builders;

import usantatecla.qualifications.v2.Exam;

public abstract class ExamBuilder {
	private static int NAME_INDEX = 0;
	protected String name;
	protected RateBuilder rateBuilder;

	protected ExamBuilder(){
		ExamBuilder.NAME_INDEX++;
		this.name = "name_" + ExamBuilder.NAME_INDEX;
		rateBuilder = new RateBuilder();
	}

	public ExamBuilder name(String name){
		this.name = name;
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
	
	public abstract Exam build();

}
