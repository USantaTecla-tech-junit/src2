package usantatecla.doubles.verification;

public class DOC {

  private int attribute;

  public DOC(){
    this.attribute = 0;
  }

  public void voidMethod() {
    System.out.println("voidMethod of DOC");
    this.attribute++;
  }

  public void voidMethodWithParemeters(int parameter, Other reDoc) {
    System.out.println("voidMethodWithParemeters of DOC");
    this.attribute++;
    this.attribute += parameter;
  }

  public void voidMethodWithExcpetion() throws Exception {
    System.out.println("voidMethodWithExcpetion of DOC");
    this.attribute++;
    throw new Exception("message");
  }

  public int returnMethod() {
    System.out.println("returnMethod of DOC");
    return this.attribute;
  }

  public int returnMethodWithParemeters(int parameter) {
    System.out.println("returnMethodWithParemeters of DOC");
    return parameter + this.attribute;
  }

  public int returnMethodWithExcpetion() throws Exception {
    System.out.println("returnMethodWithExcpetion of DOC");
    throw new Exception("message");
    //    return this.attribute;
  }

  public void slowMethod(){
    for(int i=Integer.MIN_VALUE; i < Integer.MAX_VALUE; i++){
    }
  }

}
