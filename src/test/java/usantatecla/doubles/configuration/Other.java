package usantatecla.doubles.configuration;

public class Other {

  protected int attribute;

  public Other(int parameter){
    this.attribute = parameter;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + attribute;
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Other other = (Other) obj;
    if (attribute != other.attribute)
      return false;
    return true;
  }
  
}
