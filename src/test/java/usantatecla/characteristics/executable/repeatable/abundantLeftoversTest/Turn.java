package usantatecla.characteristics.executable.repeatable.abundantLeftoversTest;

class Turn {

	private int value;

	public Turn() {
		value = 0;
	}

	public Color take() {
		return Color.values()[value];
	}

	public void change() {
		value = (value + 1) % (Color.values().length - 1);
	}

	public String aString() {
		return "Turn [value=" + value + "]";
	}

	@Override
	public String toString() {
		return "Turn [value=" + value + "]";
	}
	
}
