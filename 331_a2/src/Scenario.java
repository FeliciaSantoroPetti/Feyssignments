import java.util.Random;

/**
 * Test class which implements the Priority Queue Data Type with bound capacity.
 * This class is also developed with contractual specifications written in adbc.
 * 
 * @author 	Mathieu St-Louis		5994551	
 * 			Felicia Santoro-Petti	6619657
 */
public class Scenario {

	private PriorityQueue pq;
	
	/**
	 * Default constructor initializing an instance of the PriorityQueue.
	 */
	public Scenario() {
		pq = new PriorityQueue(3); 
	}
	
	/**
	 * Initializes and populates a PriorityQueue.
	 */
	public void setupHeap() {
		pq = new PriorityQueue(10); 

		//Add 30 new random elements.
		Random l_rand = new Random();

		for(int i = 0; i < 10; ++i) {
			pq.insert(l_rand.nextInt(100),"a");
		}
	}
	
	/**
	 * Creates the scenario when removing an element from an empty queue.
	 */
	public void testUnderflow() {
		setupHeap();

		//remove all elements of pq
		while(!pq.isEmpty()) {
			pq.remove();
		}

		//no elements remaining, "remove" precondition is breached
		pq.remove();
	}

	/**
	 * Successfully implements the priority queue using all
	 * associated methods.
	 */
	public void testSuccessful() {
		setupHeap();

		while(!pq.isEmpty()) {
			pq.remove();
		}

		for(int i = 0; i < 10; ++i) {
			pq.insert(i, "a");
		}

		System.out.println(pq.getMax().getWeight());
	}

	public static void main(String[] args) {
		Scenario sc = new Scenario();

		sc.testSuccessful();
		
		// Adding negative key to the queue, throwing PreconditionException 
		// in the PriorityQueue.insert().
		// Contract:	key >= 0
		// Where:		public void PriorityQueue.insert(int, java.lang.String)
		// Blame:		Scenario.main
		
		//PriorityQueue pq = new PriorityQueue(3); 
		//pq.insert(-1,"a");
		
		// Adding a null element to the queue, causing a PreconditionException
		// in PriorityQueue.insert().
		// Contract: 	element != null
		// Where:		public void PriorityQueue.insert(int, java.lang.String)
		// Blame:		Scenario.main
		
		//PriorityQueue pq = new PriorityQueue(3); 
		//pq.insert(1, null);

		// Causing an underflow in the Priority Queue, throwing PreconditionException
		// in PriorityQueue remove.
		// Contract:	$this.isEmpty() == false
		// Where:		public Node PriorityQueue.remove()
		// Blame:		Scenario.testUnderflow
		
		//sc.testUnderflow();
		
		// Getting max of an empty PriorityQueue, throwing Precondition
		// broken in PriorityQueue.getMax();
		// Contract:	$this.isEmpty() == false
		// Where:		public Node PriorityQueue.getMax()
		// Blame:		Scenario.main
		
		//PriorityQueue pq = new PriorityQueue(3); 
		//pq.getMax();
		
		// Causing an overflow in the Priority Queue, throwing PreconditionException
		// in PriorityQueue.insert().
		// Contract:	$this.heap.getSize()+1 <= $this.capacity
		// Where:		public void PriorityQueue.insert(int, java.lang.String)
		// Blame:		Scenario.main
		
		//PriorityQueue pq = new PriorityQueue(3); 
		//pq.insert(1, "learning");
		//pq.insert(3, "is");
		//pq.insert(2, "really");
		//pq.insert(5, "fun");
		
		// Creating a PriorityQueue with capacity less than 3, causing a PreconditionExcpetion
		// in PriorirtyQueue constructor.
		// Contract:	capacity >= 3
		// Where:		public PriorityQueue(int)
		// Blame:		Scenario.main
		
		//PriorityQueue pq = new PriorityQueue(2); 
	}

}
