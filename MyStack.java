/* NAME: Ziyu Song
 * NET ID: zsong10
 * ASSIGNMENT: Project #2
 * LAB SESSION: TR 615-730pm
 * Collaborator: Sifan Ye (sye8), Qiuyue Sun (qsun15)
 * COURSE: CSC 172
 * TA: Nathaniel Potrepka
 */

public class MyStack<AnyType> extends MyLinkedList<AnyType> implements Stack<AnyType> {
	
	public MyLinkedList<AnyType> theStack = new MyLinkedList<AnyType>();
	
	public boolean isEmpty() {
		return theStack.first == null;
	}
	
	public void push(AnyType x) {
		theStack.insert(x); // insert() method in MyLinkedList
	}
	
	public AnyType pop() {
		if (!this.isEmpty()) {
			AnyType a = theStack.first.data;
			theStack.delete(a); // delete() method in MyLinkedList
			return a;
		} else {
			return null;
		}
	}
	
	public AnyType peek() {
		return theStack.first.data;
	}
	
	public static void main(String[] args) {
		MyStack<String> stack = new MyStack<String>();
		
		// isEmpty()
		System.out.println("Check if the stack is empty: " + stack.isEmpty());
		System.out.println("-------------------------------");
		
		System.out.println("Push elements onto the Stack");
		
		// push()
		stack.push("ECO");
		stack.push("207");
		stack.push("Problem");
		stack.push("Set");
		// isEmpty()
		System.out.println("Check if the stack is empty: " + stack.isEmpty());
		
		// peek()
		System.out.println("Peek: " + stack.peek());
		
		// pop()
		System.out.println("Pop: " + stack.pop());
		System.out.println("Pop: " + stack.pop());
		System.out.println("Pop: " + stack.pop());
		System.out.println("Pop: " + stack.pop());
		System.out.println("Pop: " + stack.pop());
	}

}
