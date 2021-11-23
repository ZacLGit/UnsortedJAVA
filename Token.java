
public class Token {

	public enum Type { OPERATOR, OPERAND, PAREN };
	public Type type;
	
	private String operator;
	private float operand;

	private int precedence;
	
	public Token(float op) {
		this.operand = op;
		this.type = Type.OPERAND;
	}
	
	public Token(int op){
		this.operand = (float)op;
		this.type = Type.OPERAND;
	}
	
	public Token(String op) {
		this.operator = op;
		
		switch(op){
			case "-":  case "+": precedence = 0; break;
		
			case "*": case "/": precedence = 1; break;
			
			case "^": precedence = 2; break;
			
			case "(": case ")": precedence = 3; break;
		}
		if(precedence == 3){
			this.type = Type.PAREN;
		}else{
			this.type = Type.OPERATOR;
		}
	}
	
	public Token(Token other) {
		this.operand = other.operand;
		this.operator = other.operator;
		this.precedence = other.precedence;
	}
	
	public String getOperator() {
		return this.operator;
	}
	public float getOperand() {
		return this.operand;
	}
	public int getPrecedence() {
		return this.precedence;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null || obj.getClass() != this.getClass()){
			return false;
		}
		
		Token test = (Token)obj;
		if(this.type == test.type && this.operand == test.getOperand() 
				&& this.operator == test.getOperator() && this.precedence == test.getPrecedence()){
			
			return true;
		}
		
		return false;
	}
	
	@Override
	public int hashCode() {
		return (null == this.type ? 0 : this.type.hashCode());
	}
	
	public String toString() {
		String str = "";
		if(this.type == Type.OPERAND){
			str += Float.toString(this.operand);
		}
		if(this.type == Type.OPERATOR){
			str += this.operator;
		}
		return str;
	}
}
