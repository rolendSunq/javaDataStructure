package lists;                                                                                                                                                                                  
                                                                                                                                                                                                
public interface ListInterface<T> {                                                                                                                                                             
	public int size();					// 리스트의 목록의 수를 반환                                                                                                                                       
	public boolean contains(T element);	// 이 목록은 찾고자 하는 요소(element)가 있는 경우에 true를 돌려줍니다                                                                                                         
										// e.equals(element) 그렇지 않은 경우는 false를 돌려줍니다.                                                                                                           
	public T get(T element);			// 이 목록에서 요소(element)를 반환되도록 e.equals(element)                                                                                                          
										// 이러한 요소가 존재하지 않는 경우는, null를 돌려줍니다. 
	public boolean remove (T element);
	public String toString();                                                                                                                                                                   
	public void reset();				// list를 list에 있는 첫 번째 요소로 초기화합니다.                                                                                                     
	                                                                                                                                                                                            
	/*                                                                                                                                                                                          
	 * 전제 조건 : list는 비어 있지 않아야 합니다.                                                                                                                                                             
	 *                                                                                                                                                                                          
	 * list는 재설정됩니다.                                                                                                                                                                            
	 * list는 가장 최근 리셋 이후에 수정되지 않아야 합니다.                                                                                                                                                         
	 * 만약 현재 위치가 마지막 요소(element)에 있다면  현재 위치의 첫 번째 요소(element)의 값을 반환하며                                                                                                                         
	 * 그렇지 않으면 현재 위치에서 진행하여 다음 요소(element)의 값을 반환합니다.                                                                                                                                           
	 */                                                                                                                                                                                         
	public T getNext();					                                                                                                                                                        
} 




















