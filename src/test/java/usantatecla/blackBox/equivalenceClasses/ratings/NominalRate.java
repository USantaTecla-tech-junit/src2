package usantatecla.blackBox.equivalenceClasses.ratings;

public enum NominalRate {
	A(9),
	B(7),
	C(5),
	D(3),
	E(0);
	
	private double minimum;
	
	private NominalRate(double minimum){
		this.minimum = minimum;
	}
	
	public static NominalRate getNominalRate(double rate){
		assert new ClosedInterval(0,10).includes(rate);
		for(NominalRate nominalRate: NominalRate.values()){
			if (rate>=nominalRate.minimum){
				return nominalRate;
			}
		}
		return null;
	}
}
