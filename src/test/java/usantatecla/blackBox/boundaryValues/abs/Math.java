package usantatecla.blackBox.boundaryValues.abs;

public class Math {

	public static double abs(double value){
//		if (value<0){
//			return -value;
//		} else {
//			return value;
//		}
//		
//		return value<0 ? -value : value;
//		
//		if (value<0){
//			value *= -1;
//		}
//		return value;
		
		return java.lang.Math.sqrt(value*value);
	}
}
