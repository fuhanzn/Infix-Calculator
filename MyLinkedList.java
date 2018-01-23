/* NAME: Ziyu Song
 * NET ID: zsong10
 * ASSIGNMENT: Project #2
 * LAB SESSION: TR 615-730pm
 * Collaborator: Sifan Ye (sye8), Qiuyue Sun (qsun15)
 * COURSE: CSC 172
 * TA: Nathaniel Potrepka
 */

public class MyLinkedList<AnyType> implements SimpleLinkedList<AnyType> {
	
	protected MyNode<AnyType> first = null;
	
	public static void main(String[] args) {
		MyLinkedList<String> list = new MyLinkedList<String>();
		
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
		System.out.println("Delete element '172' and insert element 'LAB'");
		list.delete("CSC");
		list.insert("LAB");
		list.printList();
		System.out.println("Check if the list is empty: " + list.isEmpty());
		System.out.println("-------------------------");
		
		// contains()
		System.out.println("Check if the list contains 'LAB': " + list.contains("LAB"));
		System.out.println("-------------------------");
		
		// lookup()
		System.out.println("Look up '172'; return null otherwise");
		System.out.println(list.lookup("172"));
	}
	
	// Runtime: constant
	// prepend
	public void insert(AnyType x) {
		MyNode<AnyType> newnode = new MyNode<AnyType>(x);
		newnode.data = x;
		newnode.next = first;
		first = newnode;
	}
	
	// Runtime: constant
	public void delete(AnyType x) {
		first = first.next;
	}
	
	// Runtime: O(n)
	public boolean contains(AnyType x) {
		MyNode<AnyType> node = first;
		while (node != null) {
			if (node.data.equals(x)) {
				return true;
			}
			node = node.next;
		}
		return false;
	}
	
	// Runtime: O(n)
	public AnyType lookup(AnyType x) {
		MyNode<AnyType> node = first;
		while (node != null) {
			if (node.data.equals(x)) {
				return x;
			}
			node = node.next;
		}
		return null;
	}
	
	// Runtime: constant
	public boolean isEmpty() {
		if (first != null) {
			return false;
		}
		return true;
	}
	
	// Runtime: O(n)
	public void printList() {
		MyNode<AnyType> node = first;
		while (node != null) {
			System.out.println((node.data).toString());
			node = node.next;
		}
	}

}
