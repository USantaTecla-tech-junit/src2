package usantatecla.characteristics.readable.cohesive.strangeTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CompositeExam extends Exam {

	private Map<String, Exam> exams;
	
	public CompositeExam(String name, Rate rate, List<Exam> exams){
		super(name, rate);
		assert exams != null;
		assert exams.size() > 1;
		assert totalPercent(exams) == 1.0;
		assert differentNames(exams);
		this.exams = new HashMap<String, Exam>();
		for(Exam exam : exams){
			this.exams.put(exam.getName(), exam);
		}
	}
	
	private boolean differentNames(List<Exam> exams){
		List<String> examNames = new ArrayList<String>();
		for(Exam exam : exams){
			examNames.add(exam.getName());
		}
		Collections.sort(examNames);
		for(int i=0; i<examNames.size()-1; i++){
			if (examNames.get(i).equals(examNames.get(i+1))){
				return false;
			}
		}
		return true;
	}
	
	private double totalPercent(List<Exam> exams){
		double percent = 0.0;
		for(Exam exam : exams){
			percent += exam.getPercent();
		}
		return percent;
	}

	@Override
	public boolean isQualifiable() {
		for(Exam exam : exams.values()){
			if (!exam.isQualifiable()){
				return false;
			}
		}
		double value = 0.0;
		for(Exam exam : exams.values()){
			value += exam.getResult();
		}
		rate.setValue(value);
		return rate.isQualifiable();
	}
}