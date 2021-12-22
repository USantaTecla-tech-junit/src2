package usantatecla.qualifications.v2.builders;

import usantatecla.qualifications.v2.Exam;
import usantatecla.qualifications.v2.SingleExam;

public class SingleExamBuilder extends ExamBuilder {
	
	public SingleExamBuilder(){
		super();
	}

	public SingleExamBuilder value(double value){
		rateBuilder.value(value);
		return this;
	}	
	
	public SingleExam build() {
		return new SingleExam(this.name, this.rateBuilder.build());
	}

	public static Exam createExamWithPercent(double percent){
		return new SingleExamBuilder().percent(percent).build();
	}
	
}
