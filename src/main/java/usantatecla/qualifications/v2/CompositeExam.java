package usantatecla.qualifications.v2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class CompositeExam extends Exam {
	private Map<String, Exam> exams;

	public CompositeExam(String name, Rate rate, List<Exam> exams) {
		super(name, rate);
		assert exams.size() >= 1;
		assert this.totalPercent(exams) == 1.0;
		assert this.differentNames(exams);

		this.exams = new HashMap<String, Exam>();
		for (Exam exam : exams) {
			this.exams.put(exam.getName(), exam);
		}
	}

	private double totalPercent(List<Exam> exams) {
		assert exams.size() > 0;

		double percent = 0.0;
		for (Exam exam : exams) {
			percent += exam.getPercent();
		}
		return percent;
	}

	private boolean differentNames(List<Exam> exams) {
		assert exams.size() > 0;

		List<String> examNames = new ArrayList<String>();
		for (Exam exam : exams) {
			examNames.add(exam.getName());
		}
		Collections.sort(examNames);
		for (int i = 0; i < examNames.size() - 1; i++) {
			if (examNames.get(i).equals(examNames.get(i + 1))) {
				return false;
			}
		}
		return true;
	}

	@Override
	public boolean isQualifiable() {
		for (Exam exam : exams.values()) {
			if (!exam.isQualifiable()) {
				return false;
			}
		}
		double value = 0.0;
		for (Exam exam : exams.values()) {
			value += exam.getResult();
		}
		rate.setValue(value);
		return rate.isQualifiable();
	}

	@Override
	public void setValue(double value, String... pathName) {
		assert pathName.length > 0;
		assert this.isSubExam(pathName[0]);

		Iterator<Exam> iterator = this.exams.values().iterator();
		Exam exam = iterator.next();
		while (!exam.getName().equals(pathName[0])) {
			exam = iterator.next();
		}
		String[] subPathName = new String[pathName.length - 1];
		for (int i = 1; i < pathName.length; i++) {
			subPathName[i - 1] = pathName[i];
		}
		exam.setValue(value, subPathName);
	}

	public boolean isSubExam(String name) {
		assert name != null;

		for (Exam exam : this.exams.values()) {
			if (exam.getName().equals(name)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public String toString() {
		String result = "CompositeExam [" + super.toString() + ", exams=";
		for (Exam exam : this.exams.values()) {
			result += "\n" + exam.toString();
		}
		return result + "]";
	}

}
