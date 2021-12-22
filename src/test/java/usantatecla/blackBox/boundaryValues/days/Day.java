package usantatecla.blackBox.boundaryValues.days;

public enum Day {
	 MONDAY,
	 TUESDAY, 
	 WEDNESDAY,
	 THURSDAY,
	 FRIDAY,
	 SATURDAY,
	 SUNDAY;
	 
	 public static Day next(Day day){
		 assert day != null;
		 return Day.values()[(day.ordinal()+1)%Day.values().length]; 
	 }
}
