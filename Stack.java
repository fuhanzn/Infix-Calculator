/* NAME: Ziyu Song
 * NET ID: zsong10
 * ASSIGNMENT: Project #2
 * LAB SESSION: TR 615-730pm
 * Collaborator: Sifan Ye (sye8), Qiuyue Sun (qsun15)
 * COURSE: CSC 172
 * TA: Nathaniel Potrepka
 */

// generic stack interface
public interface Stack<AnyType> {
	
	public boolean isEmpty();
	public void push(AnyType x);
	public AnyType pop();
	public AnyType peek();

}
