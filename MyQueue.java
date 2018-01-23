/* NAME: Ziyu Song
 * NET ID: zsong10
 * ASSIGNMENT: Project #2
 * LAB SESSION: TR 615-730pm
 * Collaborator: Sifan Ye (sye8), Qiuyue Sun (qsun15)
 * COURSE: CSC 172
 * TA: Nathaniel Potrepka
 */

public class MyQueue<AnyType> extends MyDoublyLinkedList<AnyType> implements Queue<AnyType> {
	
	public MyDoublyLinkedList<AnyType> theQueue = new MyDoublyLinkedList<AnyType>();
	
	// check if the queue is empty
	public boolean isEmpty() {
		if (theQueue.head.next == theQueue.tail && theQueue.tail.prev == theQueue.head) {
			return true;
		} else {
			return false;
		}
	}
	
	// enqueue an new element into the queue
	@Override
	public void enqueue(AnyType x) {
		theQueue.insert(x); // insert() method in MyDoublyLinkedList
	}
	
	// dequeue an element from the queue
	@Override
	public AnyType dequeue() {
		if (!this.isEmpty()) {
			AnyType a = theQueue.head.next.data;
			theQueue.delete(a); // delete() method in MyDoublyLinkedList
			return a;
		} else {
			return null;
		}
	}
	
	@Override
	public AnyType peek() {
		return theQueue.head.next.data;
	}
	
	public void printQueue(){
        while(!theQueue.isEmpty()){
            System.out.print(this.dequeue() + ", ");
        }
        System.out.println();
    }
	
	public static void main(String[] args) {
		MyQueue<String> queue = new MyQueue<String>();
		
		// isEmpty()
		System.out.println("Check if the queue is empty: " + queue.isEmpty());
		System.out.println("-------------------------------");
		
		System.out.println("Enqueue elements into the Queue");
		
		// enqueue()
		queue.enqueue("ECO");
		queue.enqueue("207");
		queue.enqueue("problem");
		queue.enqueue("set");
		// isEmpty()
		System.out.println("Check if the queue is empty: " + queue.isEmpty());
		
		// peek()
		System.out.println("Peek: " + queue.peek());
		
		// dequeue()
		System.out.println("Dequeue: " + queue.dequeue());
		System.out.println("Dequeue: " + queue.dequeue());
		System.out.println("Dequeue: " + queue.dequeue());
		System.out.println("Dequeue: " + queue.dequeue());
		System.out.println("Dequeue: " + queue.dequeue());
	}

}
