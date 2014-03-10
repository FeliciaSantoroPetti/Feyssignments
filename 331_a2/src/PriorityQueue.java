import be.ac.ua.ansymo.adbc.annotations.ensures;
import be.ac.ua.ansymo.adbc.annotations.invariant;
import be.ac.ua.ansymo.adbc.annotations.requires;

@invariant ({
	"$this.heap.getSize() >= 0"
})
// missing the case to guarantee that the least element is at the root.

public class PriorityQueue {

	private Heap heap;

	/**
	 * Default constructor which instantiates a binary heap object.
	 */
	@requires ({"true"})
	@ensures ({
		"$this.heap != null"
	})
	public PriorityQueue() {
		heap = new Heap();
	}

	/**
	 * Retrieves the size of the priority queue.
	 * 
	 * @return	size	The size of the priority queue.
	 */
	@requires ({ "true" })
	@ensures ({ "$size >= 0" })
	public int size() {
		int size = heap.getSize();
		return size;
	}

	/**
	 * Determines if the priority queue is empty.
	 * 
	 * @return	True if size is 0, else false.
	 */
	@requires ({"#this.heap.getSize >= 0"})
	@ensures ({"true"})
	public boolean isEmpty() {
		return heap.getSize() == 0;
	}

	/**
	 * Inserts a new element into the priority queue.
	 * 
	 * @param	key		The priority of the element to be added to the priority queue.
	 * @param 	element	The String object to be added to the priority queue.
	 */
	@requires ({ "key != null",
				"element != null"
	})
	@ensures ({ "$this.heap.contains(key, element)",
			"$this.heap.getSize() == $old($this.heap.getSize()) + 1"
	})
	public void insert(int key, String element) {
		heap.addElement(key, element);
	}

	/**
	 * Retrieves the element in the queue with the highest priority.
	 *
	 * @return	result	The element with the highest priority in the queue.
	 */
	@requires ({ "$this.isEmpty() == false" })
	@ensures ({
		"$result != null",
		"$this.size() == $old($this.size())"
	})
	public Node getMax() {
		Node result = heap.getMaxNode();
		return result;
	}

	/**
	 * Removes the element in the queue with the highest priority.
	 * 
	 * @return	result	The element with the highest priority in the queue.
	 */
	@requires ({ "$this.isEmpty() == false" })
	@ensures ({
		"$result != null",
		"$result == $old($this.getMax())",
		"$this.size() == $old($this.size()) - 1"
	})
	public Node remove() {
		Node result = heap.getMaxNode(); 
		heap.removeMaxNode();
		return result; 
	}
} 