재귀 호출(recursive call)
	호출되는 메소드가 호출을 하는 메소드와 같은 메소드 호출.

기본 상태(base case): 답이 비 재귀적으로 얻어질 수 있는 상태

일반 상태(general case): 재귀 상태(recursive case)에서 해답이 자신의 작은 재귀 상태로 표현되는 경우

재귀 알고리즘: 해답 자신의 작은 재귀 상태와 기본 상태로 표현되는 해결책
	
정수 인자로 받는 재귀 알고리즘
	// 사전 조건: n은 0이 아님.
	// n!의 값을 리턴
public int factorial(n) {
	if (n == 0) {
		return 1;	// 기본 경우
	} else {
		return (n * factorial(n - 1));	// 일반 경우
	}
}

직접 재귀(direct recursion): 직접적으로 자기 자신을 호출

간접 재귀(indirect recursion): 메소드A가 메소드B를 호출하고 메소드B가 메소드A를 호출하여 최종적으로 메소드A를 호출.