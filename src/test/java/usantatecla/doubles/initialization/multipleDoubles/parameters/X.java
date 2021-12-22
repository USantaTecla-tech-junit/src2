package usantatecla.doubles.initialization.multipleDoubles.parameters;

public class X {

	private int result;

	public X() {
		this.result = 0;
	}
	
	public void m(Y y1, Y y2, Z z1, Z z2) {
		this.result = y1.m() + y2.m() + z1.m() + z2.m();
		System.out.println("m de X con " + this.result);
	}

}
