package usantatecla.qualifications.v3.builders;

import usantatecla.qualifications.v3.Exam;

public class ExamFactory {

  public static Exam createSingleExam() {
    return new SingleExamBuilder().build();
  }

  public static Exam createSingleExam_Name(String name) {
    return new SingleExamBuilder().name(name).build();
  }

  public static Exam createSingleExam_Percent(double percent) {
    return new SingleExamBuilder().percent(percent).build();
  }

  public static Exam createSingleExam_Percent_Name(double percent, String name) {
    return new SingleExamBuilder().name(name).percent(percent).build();
  }

  public static Exam createSingleExam_Percent_Value(double percent, double value) {
    return new SingleExamBuilder().value(value).percent(percent).build();
  }

  public static Exam createSingleExam_Minimum(double minimum) {
    return new SingleExamBuilder().minimum(minimum).build();
  }

  public static Exam createSingleExam_Minimum_Value(double minimum, double value) {
    return new SingleExamBuilder().value(value).minimum(minimum).build();
  }

  public static Exam createSingleExam_Value(double value) {
    return new SingleExamBuilder().value(value).build();
  }

  public static Exam createSingleExam_Value_Percent(double value, double percent) {
    return new SingleExamBuilder().value(value).percent(percent).build();
  }

  public static Exam createCompositeExam_Empty() {
    return new CompositeExamBuilder().build();
  }

  public static Exam createCompositeExam_SingleExam() {
    return new CompositeExamBuilder().exam(new SingleExamBuilder().build()).build();
  }

  public static Exam createCompositeExam_Minimum(double minimum) {
    return new CompositeExamBuilder().minimum(minimum).build();
  }

  public static Exam createCompositeExam_Exams(Exam... exams) {
    return addExams(new CompositeExamBuilder(), exams).build();
  }

  private static CompositeExamBuilder addExams(CompositeExamBuilder compositeExamBuilder, Exam... exams) {
    for (Exam exam : exams) {
      compositeExamBuilder.exam(exam);
    }
    return compositeExamBuilder;
  }

  public static Exam createCompositeExam_Percent(double percent, Exam... exams) {
    return addExams(new CompositeExamBuilder(), exams).percent(percent).build();
  }

  public static Exam createCompositeExam_Name(String name, Exam... exams) {
    return addExams(new CompositeExamBuilder(), exams).name(name).build();
  }

  public static Exam createCompositeExam_Percent_Name(double percent, String name, Exam... exams) {
    return addExams(new CompositeExamBuilder(), exams).name(name).percent(percent).build();
  }

}
