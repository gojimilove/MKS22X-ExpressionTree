public class ExpressionTree{
  private char op;
  private double value;
  private ExpressionTree left,right;

  /*TreeNodes are immutable, so no issues with linking them across multiple
  *  expressions. The can be constructed with a value, or operator and 2
  * sub-ExpressionTrees*/
  public ExpressionTree(double value){
    this.value = value;
    op = '~';
  }

  public ExpressionTree(char op,ExpressionTree l, ExpressionTree r){
    this.op = op;
    left = l;
    right = r;
  }

  public char getOp(){
    return op;
  }

  /* accessor method for Value, precondition is that isValue() is true.*/
  private double getValue(){
    return value;
  }

  /* accessor method for left, precondition is that isOp() is true.*/
  private ExpressionTree getLeft(){
    return left;
  }

  /* accessor method for right, precondition is that isOp() is true.*/
  private ExpressionTree getRight(){
    return right;
  }

  private boolean isOp(){
    return hasChildren();
  }

  private boolean isValue(){
    return !hasChildren();
  }

  private boolean hasChildren(){
    return left != null && right != null;
  }

  /*return the expression as an infix notation string with parenthesis*/
  /* The sample tree would be: "(3 + (2 * 10))"     */
  public String toString(){
    String s = "";
    if (isValue()) s += getValue();
    else {
      s += getLeft().toString();
      s += getOp();
      s += getRight().toString();
    }
    return s;
  }

  /*return the expression as a postfix notation string without parenthesis*/
  /* The sample tree would be: "3 2 10 * +"     */
  public String toStringPostfix(){
    String s = "";
    if (isValue()) s += getValue();
    else {
      s += getLeft().toString();
      s += getRight().toString();
      s += getOp();
    }
    return s;
  }

  /*return the expression as a prefix notation string without parenthesis*/
  /* The sample tree would be: "+ 3 * 2 10"     */

  public String toStringPrefix(){
    String s = "";
    if (isValue()) s += getValue();
    else {
      s += getOp();
      s += getLeft().toString();
      s += getRight().toString();
    }
    return s;
  }

  /*return the value of the specified expression tree*/
  public double evaluate(){
    if (isValue()) return getValue();
    else return apply(getOp(), getLeft().evaluate(), getRight.evaluate());
  }

  /*use the correct operator on both a and b, and return that value*/
  private double apply(char op, double a, double b){
    if (op == '+') return a + b;
    else if (op == '-') return a - b;
    else if (op == '*') return a * b;
    else if (op == '/') return a / b;
    else if (op == '%') return a % b;
  }

}
