package stack.postfix.calculator;

import java.util.Scanner;

import javax.xml.soap.SAAJResult;

import stack.BoundedStackInterface;
import stack.arraystack.ArrayStack;

public class PostFixEvaluator {
	public static int evaluate(String expression) {
		BoundedStackInterface<Integer> stack = new ArrayStack<Integer>(50);
		int value;
		int operand1;
		int operand2;
		int result = 0;
		String operator;
		Scanner tokenizer = new Scanner(expression);
		
		while (tokenizer.hasNext()) {
			if (tokenizer.hasNextInt()) {
				// 피연산자 처리
				value = tokenizer.nextInt();
				if (stack.isFull()) {
					throw new PostFixException("연산자가 많습니다. - stack overflow");
				}
				stack.push(value);
			} else {
				// 연산자 처리
				operator = tokenizer.next();
				
				// 스택으로 부터 두번째 피연산자를 얻음
				if (stack.isEmpty()) {
					throw new PostFixException("연산자가 부족합니다. - stack underflow");
				}
				
				operand2 = stack.top();
				stack.pop();
				
				// 스택으로 부터 첫번째 피연산자를 얻음
				if (stack.isEmpty()) {
					throw new PostFixException("연산자가 부족합니다. - stack underflow");
				}
				
				operand1 = stack.top();
				stack.pop();
				
				// 연산 수행
				if (operator.equals("/")) {
					result = operand1 / operand2;
				} else if (operator.equals("*")){
					result = operand1 * operand2;
				} else if (operator.equals("+")) {
					result = operand1 + operand2;
				} else if (operator.equals("-")) {
					result = operand1 - operand2;
				} else {
					throw new PostFixException("허용하지 않는 연산자 사용! " + operator);
				}
				
				// 스택에 연산의 결과를 삽입
				stack.push(result);
			}
		}
		
		// 스택으로부터 최종 결과를 얻음
		if (stack.isEmpty()) {
			throw new PostFixException("연산자가 충분하지 않음! - stack underflow");
		}
		
		result = stack.top();
		stack.pop();
		
		// 스택은 공백으로 되어야 함.
		if (!stack.isEmpty()) {
			throw new PostFixException("연산자가 많습니다! - 연산자가 남아있음!");
		}
		
		return result;
	}
}
