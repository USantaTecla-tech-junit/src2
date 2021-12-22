package usantatecla.qualifications.v3.builders;

import usantatecla.qualifications.v3.Exam;
import usantatecla.qualifications.v3.SingleExam;

class SingleExamBuilder extends ExamBuilder {

	SingleExamBuilder() {
		super();
	}

	SingleExamBuilder value(double value) {
		rateBuilder.value(value);
		return this;
	}

	public SingleExam build() {
		return new SingleExam(this.name, this.rateBuilder.build());
	}

	static Exam createExamWithPercent(double percent) {
		return new SingleExamBuilder().percent(percent).build();
	}

}
