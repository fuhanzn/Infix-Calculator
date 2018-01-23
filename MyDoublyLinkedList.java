/* NAME: Ziyu Song
 * NET ID: zsong10
 * ASSIGNMENT: Project #2
 * LAB SESSION: TR 615-730pm
 * Collaborator: Sifan Ye (sye8), Qiuyue Sun (qsun15)
 * COURSE: CSC 172
 * TA: Nathaniel Potrepka
 */

public class MyDoublyLinkedList<AnyType> implements DoublyLinkedList<AnyType> {
	
	protected MyDoubleNode<AnyType> head = new MyDoubleNode<AnyType>(null);
	protected MyDoubleNode<AnyType> tail = new MyDoubleNode<AnyType>(null);
	
	// constructor
	public MyDoublyLinkedList() {
		head.next = tail;
		tail.prev = head;
	}

	public static void main(String[] args) {
		MyDoublyLinkedList<String> list = new MyDoublyLinkedList<String>();
		
		// isEmpty()
		System.out.println("Check if the list is empty: " + list.isEmpty());
		System.out.println("-------------------------");
		
		// insert() and printList()
		System.out.println("Insert elements: ");
		list.insert("CSC");
		list.insert("172");
		list.printList();
		System.out.println("-------------------------");
		
		// delete(), insert() and printList()
		System.out.println("Delete element 'CSC' and insert element 'LAB'");
		list.delete("CSC");
		list.insert("LAB");
		list.printList();
		System.out.println("Check if the list is empty: " + list.isEmpty());
		System.out.println("-------------------------");
		
		// printListRev()
		System.out.println("Reverse the order of the list");
		list.printListRev();
		System.out.println("-------------------------");
		
		// contains()
		System.out.println("Check if the list contains 'LAB': " + list.contains("LAB"));
		System.out.println("-------------------------");
		
		// lookup()
		System.out.println("Look up '172'; return null otherwise");
		System.out.println(list.lookup("172"));
	}
	
	// Runtime: constant
	// append
	public void insert(AnyType x) {
		MyDoubleNode<AnyType> newnode = new MyDoubleNode<AnyType>(x);
		if (this.isEmpty()) {
			newnode.data = x;
			newnode.prev = head;
			newnode.next = tail;
			head.next = newnode;
			tail.prev = newnode;
		} else {
			newnode.prev = tail.prev;
			newnode.next = tail;
			tail.prev.next = newnode;
			tail.prev = newnode;
		}
	}
	
	// Runtime: constant
	public void delete(AnyType x) {
		if (!isEmpty()) {
			head.next.next.prev = head;
			head.next = head.next.next;
		}
	}
	
	// Runtime: O(n)
	public boolean contains(AnyType x) {
		if (this.isEmpty()) {
			return false;
		} else {
			MyDoubleNode<AnyType> node = head.next;
			while (node.data != null) {
				if (node.data.equals(x)) {
					return true;
				}
				node = node.next;
			}
			return false;
		}
	}
	
	// Runtime: O(n)
	public AnyType lookup(AnyType x) {
		MyDoubleNode<AnyType> node = head.next;
		while (node != null) {
			if (node.data.equals(x)) {
				return x;
			}
			node = node.next;
		}
		return null;
	}
	
	public boolean isEmpty() {
		return head.next == tail;
	}
	
	// Runtime: O(n)
	public void printList() {
		MyDoubleNode<AnyType> node = head.next;
		while (node.data != null) {
			System.out.println((node.data).toString());
			node = node.next;
		}
	}
	
	// Runtime: O(n)
	public void printListRev() {
		MyDoubleNode<AnyType> node = tail.prev;
		while (node.data != null) {
			System.out.println((node.data).toString());
			node = node.prev;
		}
	}

}
