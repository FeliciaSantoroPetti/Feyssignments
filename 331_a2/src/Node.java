/**
 * Inner node class representing the type of element that will be stored in a
 * Binary Heap.
 * 
 * @author 	Mathieu St-Louis
 *
 */
public class Node {
	
	private int weight;
	private String value;
	
	/**
	 * Two parameter constructor.
	 * 
	 * @param weight
	 * @param value
	 */
	public Node(int weight, String value) {
		this.weight = weight;
		this.value = value;
	}
	
	public int getWeight() {
		return this.weight;
	}
	
	public String getValue() {
		return this.value;	
	}

}