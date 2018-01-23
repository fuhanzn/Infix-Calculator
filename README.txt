/* NAME: Ziyu Song
 * NET ID: zsong10
 * ASSIGNMENT: Project #2
 * LAB SESSION: TR 615-730pm
 * Collaborator: Sifan Ye (sye8), Qiuyue Sun (qsun15)
 * COURSE: CSC 172
 * TA: Nathaniel Potrepka
 */
CONTENTS OF THE FOLDER:
InfixCalculator.java
	methods and main method of the calculator
DNE.java
	exception

MyStack.java
Stack.java
MyNode.java
SimpleLinkedList.java
MyLinkedList.java
(Lab 6)

MyQueue.java
Queue.java
MyDoubleNode.java
DoublyLinkedList.java
MyDoublyLinkedList.java
(Lab 7)

infix_expr_short.txt
	sample mathematical expressions
infix_test.txt
	extra credit mathematical expressions
my_eval.txt
	results
postfix_eval_short.txt
	correct results for “infix_expr_short.txt”

README.txt
	README file of this project
OUTPUT.txt
	OUTPUT file of this project
DESCRIPTION OF THE PROJECT:
This project is an infix calculator. This Java program will read an input file consisting of several lines of mathematical expressions in infix notation, convert them to postfix notation using the shunting-yard algorithm, and then evaluate the postfix expression. The results will be saved to an output file (“my_eval.txt”).

In this project, I also used the stack and queue implementations in Lab 6 and Lab 7.

All methods in the program are tested.

Extra Credits:
In this project, I finished all the extra credit parts. In postfix evaluation part, aka calculate method, I concluded not just the basic operators, but also exponentiation, modulo, sine, cosine, and tangent operators. Also, I used exceptions and displayed messages when there are invalid expressions and expressions that cannot be evaluated. 

I created a new file named “infix_test.txt” which concluded all these mathematical expressions. The results will be saved to an output file “my_eval.txt”.

Reference:
Shunting-yard algorithm, wikipedia, https://en.wikipedia.org/wiki/Shunting-yard_algorithm
