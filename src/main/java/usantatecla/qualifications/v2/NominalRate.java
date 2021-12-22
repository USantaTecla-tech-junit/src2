package usantatecla.qualifications.v2;

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

	protected double getMinimum(){
		return this.minimum;
	}
	
	public static NominalRate getNominalRate(double value){
		assert Rate.VALUE_INTERVAL.includes(value);

		for(NominalRate nominalRate: NominalRate.values()){
			if (nominalRate.minimum <= value){
				return nominalRate;
			}
		}
		return null;
	}

}
