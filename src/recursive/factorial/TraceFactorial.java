package recursive.factorial;

public class TraceFactorial {
	private static String indent = "";
	
	public static int runFactorial(int number) {
		int returnValue;
		System.out.println(indent + "���丮�� �޼ҵ� ���� >>>>>>>> " + number);
		indent = indent + "  ";
		if (number == 0) {
			returnValue = 1;
		} else {
			returnValue = (number * runFactorial(number - 1));
		}
		System.out.println(indent + "��ȯ ��: " + returnValue);
		indent = indent.substring(2);
		return returnValue;
	}
}
