package usantatecla.blackBox.equivalenceClasses.ratings;

import java.util.ArrayList;
import java.util.List;

public class CompositeExamBuilder extends ExamBuilder {

	private List<Exam> exams;

	public CompositeExamBuilder() {
		exams = new ArrayList<Exam>();
	}

	public CompositeExamBuilder exam(Exam exam) {
		exams.add(exam);
		return this;
	}

	public CompositeExamBuilder withoutExams() {
		exams = null;
		return this;
	}

	@Override
	public Exam build() {
		return new CompositeExam(name, rateBuilder.build(), exams);
	}

}
