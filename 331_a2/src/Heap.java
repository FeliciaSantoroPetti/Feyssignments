import java.util.ArrayList;

/**
 * Binary Heap class.
 * 
 * @author 	Mathieu St-Louis
 * 			Felicia Santoro-Petti
 *
 */
public class Heap {
	
	
	private ArrayList<Node> nodeDA;
	
	/**
	 * Default binary heap constructor which initializes a dynamic Node array.
	 */
	public Heap() {
		this.nodeDA = new ArrayList<Node>();
	}
	
	/**
	 * Prints the contents currently stored in the heap.
	 */
	public void printHeapContent() {
		for(int i = 0; i < nodeDA.size(); ++i) {
			System.out.println("Index:" + i + "\t\tWeight:" + nodeDA.get(i).getWeight() + "\t\tValue:" + nodeDA.get(i).getValue());
		}
		
	}
	
	/**
	 * Determines if the heap already contains the key-element pair.
	 * 
	 * @param 	key		Priority of the element.
	 * @param 	element	Value associated with the given priority.
	 * @return	True if the heap contains the pair, else false.
	 */
	public boolean contains(int key, String element){
		for(int i = 0; i < nodeDA.size(); ++i) {
			if(nodeDA.get(i).getWeight() == key && nodeDA.get(i).getValue().equals(element))
				return true;
		}
		return false;
	}
	
	/**
	 * Adds the key-value pair to the heap.
	 * 
	 * @param 	weight	The priority of the element.
	 * @param 	value	Value associated with the given priority.
	 */
	public void addElement(int weight, String value) {
		nodeDA.add(new Node(weight,value));
		upwardValidity(nodeDA.size() - 1);
	}
	
	/**
	 * Returns the size of the heap.
	 * 
	 * @return	Size of the heap.
	 */
	public int getSize() {
		return nodeDA.size();
	}
	
	/**
	 * Returns the element with the highest priority.
	 * 
	 * @return	The Node with the highest priority if available, else null.
	 */
	public Node getMaxNode() {
		if(nodeDA.size() > 0)
			return nodeDA.get(0);
		else
			return null;
	}
	
	/**
	 * Removes the Node with the highest priority from the
	 * heap.
	 * 
	 * @return	The Node with the highest priority if available, else null.
	 */
	public Node removeMaxNode() {
		if(nodeDA.size() > 0) {
			Node l_ReturnNode = nodeDA.get(0);
			//Store the last element into the first element,
			Node l_temp = nodeDA.get(nodeDA.size() - 1);
			nodeDA.set(0 , l_temp);
			
			// remove last element
			nodeDA.remove(nodeDA.size() -1);
			
			downwardValidity(0);
			return l_ReturnNode;
		}
		return null;
	}
	
	/**
	 * Determines the child to the left of the parent node.
	 * 
	 * @param	parentIndex	Parent node index.
	 * @return	The child node to the left if available, else false.
	 */
	private Node getLeftChildNode(int parentIndex) {
		int leftChildIndex = (parentIndex + 1) * 2;
		if(nodeDA.size() >= leftChildIndex) {
			return nodeDA.get(leftChildIndex - 1);
		}
		else
			return null;
	}
	
	/**
	 * Determines the child to the right of the parent node.
	 * 
	 * @param	parentIndex	Parent node index.
	 * @return	The child node to the right if available, else null.
	 */
	private Node getRightChildNode(int parentIndex) {
		int rightChildIndex = (parentIndex + 1) * 2 + 1;
		if(nodeDA.size() >= rightChildIndex) {
			return nodeDA.get(rightChildIndex - 1);
		}
		else
			return null;
	} 
	
	/**
	 * Determines the new root of the heap once an element has been removed.
	 * 
	 * @param parentIndex
	 */
	private void downwardValidity(int parentIndex) {
		if(nodeDA.size() > parentIndex) {
			int leftChildIndex = (parentIndex + 1) * 2 - 1;
			int rightChildIndex = (parentIndex + 1) * 2 ;
			
			if(isValidIndex(parentIndex)) {
				Node currentNode = nodeDA.get(parentIndex);
				Node leftChildNode = getLeftChildNode(leftChildIndex);
				Node rightChildNode = getRightChildNode(rightChildIndex);
				
				//No Child Exists
				if(leftChildNode == null)
					return;
				//only left child exists
				if(rightChildNode == null)
					{
					if(currentNode.getWeight() < leftChildNode.getWeight()) {
					swapNode(parentIndex, leftChildIndex);
					return;
					}
					else return;
				}
				
				//left child is biggest
				if(leftChildNode.getWeight() > rightChildNode.getWeight()) {
					if(currentNode.getWeight() < leftChildNode.getWeight()) {
						swapNode(parentIndex, leftChildIndex);
						downwardValidity(leftChildIndex);
					}
				}
				//right child is biggest
				else {
					if(currentNode.getWeight() < rightChildNode.getWeight()) {
						swapNode(parentIndex, rightChildIndex);
						downwardValidity(rightChildIndex);
					}
				}
				
			}
		}
	}
	
	/**
	 * Determines the new root of the heap once an element has been added to the heap.
	 * 
	 * @param childIndex
	 */
	private void upwardValidity(int childIndex) {
		if(childIndex == 0)
			return;
		if(isValidIndex(childIndex)) {
			int parentIndex = (childIndex + 1)/2 - 1;
			
			//compare child and parent
			Node currentNode =	nodeDA.get(childIndex);
			Node parentNode =	nodeDA.get(parentIndex);
			
			if(parentNode.getWeight() < currentNode.getWeight()) {
				swapNode(childIndex,parentIndex);
				upwardValidity(parentIndex);
			}
		
		}
	}
	
	/**
	 * Determines if the given index is valid.
	 * 
	 * @param 	index	Index to verify if valid.
	 * @return	True if valid, else false.
	 */
	private boolean isValidIndex(int index) {
		return nodeDA.size() > index; 
	}
	
	/**
	 * Swaps the two node indexes.
	 * 
	 * @param nodeIndex1
	 * @param nodeIndex2
	 */
	private void swapNode(int nodeIndex1, int nodeIndex2) {
		if(nodeIndex1 < nodeDA.size() && nodeIndex2 < nodeDA.size()) {
			Node temp = nodeDA.get(nodeIndex1);
			nodeDA.set(nodeIndex1, nodeDA.get(nodeIndex2));
			nodeDA.set(nodeIndex2, temp);
		}
	}
	
	/**
	 * Clears the heap.
	 */
	public void ResetHeap() {
		this.nodeDA.clear();
	}
}
