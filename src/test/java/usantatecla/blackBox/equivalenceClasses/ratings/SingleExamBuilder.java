package usantatecla.blackBox.equivalenceClasses.ratings;

public class SingleExamBuilder extends ExamBuilder {

	public SingleExamBuilder() {
		super();
	}
	
	public SingleExam build() {
		return new SingleExam(name, rateBuilder.build());
	}
}
