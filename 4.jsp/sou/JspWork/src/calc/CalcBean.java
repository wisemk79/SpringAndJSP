package calc;
//자바빈즈->웹상에 값을 입력,출력하거나, 메서드를 호출할때 필요로하는 클래스(DTO)
//public class로 줘야 외부에서 접근이 가능->그 클래스의 객체를 생성->메서드호출, 멤버변수에 값저장

public class CalcBean {

	private int num1,num2;//"5","3"->5,3 <%=num1+num3%>
	private String operator="";//연산자를 저장할 변수
	//추가
	private int result;//연산값을 저장할 변수
	
	//+,-,*,/->계산(calculate)->매개변수 O ,반환값 X
	
	public int getNum1() {
		return num1;
	}

	public void setNum1(int num1) { //액션태그를 사용->웹상에서 많은 데이터를 입력
		this.num1 = num1;
		System.out.println("setNum1()호출됨!");
	}


	public int getNum2() {
		return num2;
	}


	public void setNum2(int num2) {
		this.num2 = num2;
		System.out.println("setNum2()호출됨!");
	}


	public String getOperator() {
		return operator;
	}


	public void setOperator(String operator) {
		this.operator = operator;
		System.out.println("setOperator()호출됨!");
	}


	public int getResult() {
		return result;
	}


	public void calculate() { //멤버변수에 저장된 값을 그대로 불러다 사용이 가능->매개변수X
		//+
		if (operator.contentEquals("+")) {
			result=num1+num2;
		}
		//-
		if (operator.contentEquals("-")) {
			result=num1-num2;
		}
		
		//*
		if (operator.contentEquals("*")) {
			result=num1*num2;
		}
		// /
		if (operator.contentEquals("/")) {
			result=num1/num2;
		}
	}
}
