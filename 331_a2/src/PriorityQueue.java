public class PriorityQueue {
  
  /*
    Math -> size, isempty, insert
    Fey -> getMax, remove
  */
  
  private Heap m_Heap;
  
  public PriorityQueue()
  {
    m_Heap = new Heap();
  }
  
  public int size()
  {
    return m_Heap.GetSize();
  }
  
  public boolean isEmpty()
  {
    return m_Heap.GetSize() < 1;
    
  }
  
  public void insert(int Key, String Element)
  {
    m_Heap.AddElement(Key,Element);
  }
  
  public Node getMax()
  {
    
  }
  
  public Node remove()
  {
    
  }
  
  
  }
