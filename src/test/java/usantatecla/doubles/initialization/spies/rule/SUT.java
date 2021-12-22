package usantatecla.doubles.initialization.spies.rule;

public class SUT {

  private DOC doc;

  public SUT(DOC doc) {
    this.doc = doc;
  }

  public int exerciseSUT(boolean value) {
    System.out.println("exerciseSUT");
    return this.doc.exerciseDOC(value);
  }

}
