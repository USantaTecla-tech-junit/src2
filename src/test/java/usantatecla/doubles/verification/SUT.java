package usantatecla.doubles.verification;

public class SUT {
  
  private DOC doc;
  private int attribute;

  public SUT(DOC doc){
    this.doc = doc;
    this.attribute = 0;
  }

  public void voidMethod(){
    System.out.println("voidMethod of SUT");
    this.attribute++;
    this.doc.voidMethod();
  }

  public void voidMethodWithParemeters(int parameter, Other other){
    System.out.println("voidMethodWithParemeters of SUT");
    this.attribute++;
    this.doc.voidMethodWithParemeters(parameter, other);
  }

  public void voidMethodWithExcpetion() throws Exception {
    System.out.println("voidMethodWithExcpetion of SUT");
    this.attribute++;
    this.doc.voidMethodWithExcpetion();
  }

  public int returnMethod() {
    System.out.println("returnMethod of SUT");
    return this.attribute + this.doc.returnMethod();
  }

  public int returnMethodWithParemeters(int parameter){
    System.out.println("returnMethodWithParemeters of SUT");
    return parameter + this.attribute + this.doc.returnMethodWithParemeters(parameter);
  }

  public int returnMethodWithExcpetion() throws Exception {
    System.out.println("returnMethodWithExcpetion of SUT");
    return + this.attribute + this.doc.returnMethodWithExcpetion();
  }

  public void slowMethod(){
    this.doc.slowMethod();
  }

}
