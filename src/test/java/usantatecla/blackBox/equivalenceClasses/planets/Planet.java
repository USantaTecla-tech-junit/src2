package usantatecla.blackBox.equivalenceClasses.planets;

public enum Planet {
	MERCURY, 
	VENUS, 
	EARTH, 
	MARS, 
	JUPITER, 
	SATURN, 
	URANUS, 
	NEPTUNE;
	
	public static Planet next(Planet planet){
		assert planet != null;
		assert planet.ordinal() < Planet.values().length-1;
		return Planet.values()[planet.ordinal()+1];
	}
	
}
