package usantatecla.characteristics.readable.simple.conditionalLogic.v1;

import java.util.Iterator;

public class Dictionary {

	public void add(Pair pair) {
		
	}

	public Iterator<Pair> iterator() {
		return null;
	}

}

class Pair {
	
	private String key;
	
	private Object value;
	
	public Pair(String key, Object value) {
		this.key = key;
		this.value = value;
	}
	
	public String getKey() {
		return key;
	}
	
	public Object getValue() {
		return value;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pair other = (Pair) obj;
		if (key == null) {
			if (other.key != null)
				return false;
		} else if (!key.equals(other.key))
			return false;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}
}
