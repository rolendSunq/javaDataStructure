package lists;                                                                                                                                                                                  
                                                                                                                                                                                                
public interface ListInterface<T> {                                                                                                                                                             
	public int size();					// ����Ʈ�� ����� ���� ��ȯ                                                                                                                                       
	public boolean contains(T element);	// �� ����� ã���� �ϴ� ���(element)�� �ִ� ��쿡 true�� �����ݴϴ�                                                                                                         
										// e.equals(element) �׷��� ���� ���� false�� �����ݴϴ�.                                                                                                           
	public T get(T element);			// �� ��Ͽ��� ���(element)�� ��ȯ�ǵ��� e.equals(element)                                                                                                          
										// �̷��� ��Ұ� �������� �ʴ� ����, null�� �����ݴϴ�. 
	public boolean remove (T element);
	public String toString();                                                                                                                                                                   
	public void reset();				// list�� list�� �ִ� ù ��° ��ҷ� �ʱ�ȭ�մϴ�.                                                                                                     
	                                                                                                                                                                                            
	/*                                                                                                                                                                                          
	 * ���� ���� : list�� ��� ���� �ʾƾ� �մϴ�.                                                                                                                                                             
	 *                                                                                                                                                                                          
	 * list�� �缳���˴ϴ�.                                                                                                                                                                            
	 * list�� ���� �ֱ� ���� ���Ŀ� �������� �ʾƾ� �մϴ�.                                                                                                                                                         
	 * ���� ���� ��ġ�� ������ ���(element)�� �ִٸ�  ���� ��ġ�� ù ��° ���(element)�� ���� ��ȯ�ϸ�                                                                                                                         
	 * �׷��� ������ ���� ��ġ���� �����Ͽ� ���� ���(element)�� ���� ��ȯ�մϴ�.                                                                                                                                           
	 */                                                                                                                                                                                         
	public T getNext();					                                                                                                                                                        
} 




















