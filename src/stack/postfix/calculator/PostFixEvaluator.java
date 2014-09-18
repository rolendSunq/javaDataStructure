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
				// �ǿ����� ó��
				value = tokenizer.nextInt();
				if (stack.isFull()) {
					throw new PostFixException("�����ڰ� �����ϴ�. - stack overflow");
				}
				stack.push(value);
			} else {
				// ������ ó��
				operator = tokenizer.next();
				
				// �������� ���� �ι�° �ǿ����ڸ� ����
				if (stack.isEmpty()) {
					throw new PostFixException("�����ڰ� �����մϴ�. - stack underflow");
				}
				
				operand2 = stack.top();
				stack.pop();
				
				// �������� ���� ù��° �ǿ����ڸ� ����
				if (stack.isEmpty()) {
					throw new PostFixException("�����ڰ� �����մϴ�. - stack underflow");
				}
				
				operand1 = stack.top();
				stack.pop();
				
				// ���� ����
				if (operator.equals("/")) {
					result = operand1 / operand2;
				} else if (operator.equals("*")){
					result = operand1 * operand2;
				} else if (operator.equals("+")) {
					result = operand1 + operand2;
				} else if (operator.equals("-")) {
					result = operand1 - operand2;
				} else {
					throw new PostFixException("������� �ʴ� ������ ���! " + operator);
				}
				
				// ���ÿ� ������ ����� ����
				stack.push(result);
			}
		}
		
		// �������κ��� ���� ����� ����
		if (stack.isEmpty()) {
			throw new PostFixException("�����ڰ� ������� ����! - stack underflow");
		}
		
		result = stack.top();
		stack.pop();
		
		// ������ �������� �Ǿ�� ��.
		if (!stack.isEmpty()) {
			throw new PostFixException("�����ڰ� �����ϴ�! - �����ڰ� ��������!");
		}
		
		return result;
	}
}
