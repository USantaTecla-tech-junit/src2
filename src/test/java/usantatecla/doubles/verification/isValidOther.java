package usantatecla.doubles.verification;

import org.mockito.ArgumentMatcher;

class isValidOther implements ArgumentMatcher<Other> {
  public boolean matches(Other other) {
      return 0 <= other.attribute && other.attribute <= 2;
  }
  public String toString() {
      return "[isValidOther]";
  }
  
}
