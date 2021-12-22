package usantatecla.doubles.initialization.multipleDoubles.locals;

public class X {

	private int result;

	public X() {
		this.result = 0;
	}

	public void m() {
		this.result = this.createY().m() + new Y().m() + this.createZ().m() + new Z().m();
		System.out.println("m de X con " + this.result);
	}

	Y createY() {
		return new Y();
	}

	Z createZ() {
		return new Z();
	}

}
