package usantatecla.doubles.initialization.multipleDoubles.fields;

public class X {

	private Y y1;
	private Y y2;
	private Z z1;
	private Z z2;
	private int result;
	
	public X() {
		this.y1 = new Y();
		this.y2 = new Y();
		this.z1 = new Z();
		this.z2 = new Z();
		this.result = 0;
	}
	
	public void m() {
		this.result = this.y1.m() + this.y2.m() + this.z1.m() + this.z2.m();
		System.out.println("m de X con " + this.result);
	}

}
