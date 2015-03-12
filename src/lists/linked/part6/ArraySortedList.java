package lists.linked.part6;

import lists.ListInterface;
import lists.linked.part5.ArrayUnsortedList;

public class ArraySortedList<T> extends ArrayUnsortedList<T> implements ListInterface<T> {
	public ArraySortedList() {
		super();
	}

	public ArraySortedList(int originalCapacity) {
		super(originalCapacity);
	}

	/**
	 * 선행 조건: 요소를 비교한다.
	 * 
	 * 요소를 추가한다.
	 * 
	 * @param element
	 * 
	 * list의 요소를 비교하기 위해 list element type의 변수를 선언한다. 현재 사용 중인 list를
	 * 가져와 초기화하는 변수를 만들고 초기화한다. 비교조건에서 통과된 element의 수를 셀 수있는 변수
	 * location을 선언하고 초기화 한다. list의 요소의 수가 지정한 용량의 수와 같은 경우 enLarge()
	 * 메소드를 호출한다. while을 location 수가 numberOfElements 의 수와 다를 때까지
	 * loop문을 돌린다. list의 처음 요소 부터 compareTo 메소드로 추가하는 element요소와
	 * 대소비교를 시작한다. 비교할 요소가 비교 대상 보다 작은 경우 location 수를 증가한다. 아닐 경우 루프
	 * 문을 탈출한다. for문에 요소개수로 초기화 하고 location이 index보다 클때까지 index를
	 * 감소하면서 list[index] = list[index-1] 로 초기화 한다. list[location] =
	 * element 로 초기화 한다. numberOfElement + 1 추가된 리스트의 결과를 현재 list 객체로
	 * 초기화 한다.
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void add(T element) {
		T[] listElement;
		T[] originalListElement = getList();
		int location = 0;

		if (getNumberOfElements() == getList().length) {
			enLarge();
		}

		while (location < getNumberOfElements()) {
			listElement = (T[]) getList()[location];
			if (((Comparable<T>) listElement[location]).compareTo(element) < 0) {
				location++;
			} else {
				break;
			}
		}

		for (int index = getNumberOfElements(); index > location; index--) {
			originalListElement[index] = getList()[index - 1];
		}

		setNumberOfElements(getNumberOfElements() + 1);
		setList(originalListElement);
	}

	/**
	 * e.equals(element)의 결과에 의해 요소를 삭제한다.
	 * 
	 * @param element
	 * 
	 *            요소의 삭제가 성공하면 true, false는 element가 list에 없다는 결과이다.
	 * @return true, false
	 * 
	 * 
	 */
	@Override
	public boolean remove(T element) {
		T[] sourceList = getList();
		find(element);
		if (isFound()) {
			for (int i = getLocation(); i <= getNumberOfElements() - 2; i++)
				sourceList[i] = getList()[i + 1];
			sourceList[getNumberOfElements() - 1] = null;
			setNumberOfElements(getNumberOfElements() - 1);
			setList(sourceList);
		}
		return isFound();
	}

}
