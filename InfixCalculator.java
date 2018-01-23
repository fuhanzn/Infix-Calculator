/* NAME: Ziyu Song
 * NET ID: zsong10
 * ASSIGNMENT: Project #2
 * LAB SESSION: TR 615-730pm
 * Collaborator: Sifan Ye (sye8), Qiuyue Sun (qsun15)
 * COURSE: CSC 172
 * TA: Nathaniel Potrepka
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Shunting-Yard Algorithm
 * Postfix Evaluation
 * Extra Credit
 */
public class InfixCalculator {
	
	public static HashMap<String, Integer> precedence = new HashMap<String, Integer>();
	
    // operation precedence map
	public static void initPrecedence(){
		precedence.put("|", 0);
		precedence.put("&", 1);
		precedence.put("!", 2);
		precedence.put("=", 3);
		precedence.put(">", 3);
		precedence.put("<", 3);
		precedence.put("-", 4);
		precedence.put("+", 4);
		precedence.put("*", 5);
		precedence.put("/", 5);
		precedence.put("%", 5);
		precedence.put("^", 6);
        precedence.put("sin", 7);
        precedence.put("cos", 7);
        precedence.put("tan", 7);
		precedence.put(")", 8);
		precedence.put("(", 8);
	}
	
	public static boolean isInteger(char c) {
		try {
			Integer.parseInt(c + "");
		} catch (NumberFormatException e) {
			return false;
		}
		return true;
	}
	
	public static boolean isDouble(String s) {
		try {
			Double.parseDouble(s);
		} catch (NumberFormatException e) {
			return false;
		}
		return true;
	}
	
	public static int operationComparison(String a, String b) {
		if (a.equals(b)) {
			return 0;
		} else {
			return (precedence.get(a).compareTo(precedence.get(b)));			
		}
	}
	
    // postfix evaluation
	public static void calculate(MyStack<String> tempStack, MyQueue<String> tempQueue) throws DNE {
		
		double a; // first operand
		double b; // second operand
		double c; // result
		String result;
		DecimalFormat df = new DecimalFormat("######0.00");
		
		while (tempQueue.peek() != null) {
			
			String temp = tempQueue.dequeue();
			switch (temp) {
			case "+":
				a = Double.parseDouble(tempStack.pop());
				b = Double.parseDouble(tempStack.pop());
				c = b + a;
				result = df.format(c);
				tempStack.push(result);
				break;   
			case "-":
				a = Double.parseDouble(tempStack.pop());
				b = Double.parseDouble(tempStack.pop());
				c = b - a;
				result = df.format(c);
				tempStack.push(result);
				break;
			case "*":
				a = Double.parseDouble(tempStack.pop());
				b = Double.parseDouble(tempStack.pop());
				c = b * a;
				result = df.format(c);
				tempStack.push(result);
				break;
			case "/":
				a = Double.parseDouble(tempStack.pop());
				b = Double.parseDouble(tempStack.pop());
				if (a == 0) {
					System.out.println("Divided by 0 DNE");
					throw new DNE();
				}
				c = b / a;
				result = df.format(c);
				tempStack.push(result);
				break;
			case "^":
				a = Double.parseDouble(tempStack.pop());
				b = Double.parseDouble(tempStack.pop());
				if (a == 0 && b == 0) {
					System.out.println("0 to the power of 0 DNE");
					throw new DNE();
				}
				c = Math.pow(b,a);
				result = df.format(c);
				tempStack.push(result);
				break;
			case "%":
				a = Double.parseDouble(tempStack.pop());
				b = Double.parseDouble(tempStack.pop());
				if (a == 0) {
					System.out.println("Divided by 0 DNE");
					throw new DNE();
				}
				c = b % a;
				result = df.format(c);
				tempStack.push(result);
				break;
			case "=":
				a = Double.parseDouble(tempStack.pop());
				b = Double.parseDouble(tempStack.pop());
				if (a == b) {
					c = 1.00;
				} else {
					c = 0.00;
				}
				result = df.format(c);
				tempStack.push(result);
				break;
			case ">":
				a = Double.parseDouble(tempStack.pop());
				b = Double.parseDouble(tempStack.pop());
				if (b > a) {
					c = 1.00;
				} else {
					c = 0.00;
				}
				result = df.format(c);
				tempStack.push(result);
				break;
			case "<":
				a = Double.parseDouble(tempStack.pop());
				b = Double.parseDouble(tempStack.pop());
				if (b < a) {
					c = 1.00;
				} else {
					c = 0.00;
				}
				result = df.format(c);
				tempStack.push(result);
				break;
			case "|":
				a = Double.parseDouble(tempStack.pop());
				b = Double.parseDouble(tempStack.pop());
				if (b == 1 || a == 1) {
					c = 1.00;
				} else {
					c = 0.00;
				}
				result = df.format(c);
				tempStack.push(result);
				break;
			case "&":
				a = Double.parseDouble(tempStack.pop());
				b = Double.parseDouble(tempStack.pop());
				if (b == 1 && a == 1) {
					c = 1.00;
				} else {
					c = 0.00;
				}
				result = df.format(c);
				tempStack.push(result);
				break;
			case "sin":
				a = Double.parseDouble(tempStack.pop());
				c = Math.sin(a);
				result = df.format(c);
				tempStack.push(result);
				break;
			case "cos":
				a = Double.parseDouble(tempStack.pop());
				c = Math.cos(a);
				result = df.format(c);
				tempStack.push(result);
				break;
			case "tan":
				a = Double.parseDouble(tempStack.pop());
				c = 0;
				if (a % Math.PI/2 == 0) {
					System.out.println("tan of multiples of pi/2 DNE");
					throw new DNE();
				} else {
					c = Math.tan(a);
				}
				result = df.format(c);
				tempStack.push(result);
				break;
			case "!":
				a = Double.parseDouble(tempStack.pop());
				if (a != 1) {
					c = 1.00;
				} else {
					c = 0.00;
				}
				result = df.format(c);
				tempStack.push(result);
				break;
			default:
				tempStack.push(temp);
				break;
			}
			
		}
		
	}
	
	public static void main(String[] args) {
		
		String temp = null;
		String subTemp = null;
		String filename;
		
		String[] tempArray;	
		
		MyStack<String> tempStack = new MyStack<String>();
		MyQueue<String> tempQueue = new MyQueue<String>();
		ArrayList<String> tempArrayList;
		
		Scanner input = new Scanner(System.in);
		
		initPrecedence(); // initialize precedence map
		
		System.out.println("Please enter your input file name: ");
		filename = input.nextLine();
		
		try {
			Scanner scan = new Scanner(new File(filename));
			PrintWriter out = new PrintWriter(new File("my_eval.txt"));
			
			while(scan.hasNextLine()){
				temp = scan.nextLine(); // load line by file
				
				tempStack = new MyStack<String>(); // reset stack
				tempQueue = new MyQueue<String>(); // reset queue (postfix)
				
				tempArray = temp.split(" "); // convert into string array
				tempArrayList = new ArrayList<String>();
				
				for (String s: tempArray) {
					
					if (s.length() == 1) {
						tempArrayList.add(s); // if length equals to 1, add to list
					} else if (isDouble(s)) {
						tempArrayList.add(s); // if it is a number, add to list
                    // trigonometry
					} else if (s.contains("sin") || s.contains("cos") || s.contains("tan")) {
                        // add trigonometry function
						if (s.length() == 3) {
							tempArrayList.add(s);
						} else {
							tempArrayList.add(s.substring(0,3)); // separate trigonometry functions, "(", ")" and numbers
							subTemp = s.substring(3);
							tempArrayList.add("(");
							
							if (subTemp.contains(")")) {
								subTemp = subTemp.substring(1,subTemp.indexOf(")")); // separate string between "(" and ")"
							} else {
								subTemp = subTemp.substring(1);
							}
							
							while (subTemp.length() > 0) {
                                // if it is not a number, it must be an operator
								if (!isInteger(subTemp.charAt(0))) {
									tempArrayList.add(subTemp.charAt(0) + "");
									subTemp = subTemp.substring(1);
								} else {
									for (int k = 0; k < subTemp.length(); k++) {
                                        // decide if it is a number (including double) or an operator
										if (!(isInteger(subTemp.charAt(k)) || subTemp.charAt(k) == '.')) {
											tempArrayList.add(subTemp.substring(0,k));
											tempArrayList.add(subTemp.charAt(k)+"");
											subTemp = subTemp.substring(k+1);
											break;
										}
									}
                                    // if it is not, add ""
									if (!subTemp.equals("")) {
										tempArrayList.add(subTemp);
									}							
									break;
								}					
							}
                            // finally, add ")"
							if (s.contains(")")) {
								tempArrayList.add(")");
							}
						}				
					} else {
						while (s.length() > 0) {
                            // if it is not a number, it must be an operator
							if (!isInteger(s.charAt(0))) {
								tempArrayList.add(s.charAt(0)+"");
								s = s.substring(1);
							} else {
                                // decide if it is a number (including double) or an operator
								for (int k = 0; k < s.length(); k++) {
									if (!(isInteger(s.charAt(k)) || s.charAt(k) == '.')) {
										tempArrayList.add(s.substring(0,k));
										tempArrayList.add(s.charAt(k)+"");
										s = s.substring(k+1);
										break;
									}
								}
                                // it it is not, add ""
								if (!s.equals("")) {
									tempArrayList.add(s);
								}							
								break;
							}
						}
					}					
				}

				// convert tempQueue to infix
				for (String s: tempArrayList) {
					// enqueue operands
					if (isDouble(s)) {
						tempQueue.enqueue(s);
						continue;
					// if token is ")"
					} else if (s.equals(")")) {
						if (!tempStack.isEmpty()) {
							while (!(tempStack.peek().equals("("))) {
								tempQueue.enqueue(tempStack.pop());
								if (tempStack.isEmpty()) {
									break;
								}
							}
							tempStack.pop();
						}
						continue;
					} else {
						// if token is an operator
						if (!tempStack.isEmpty()) {
							while (!((operationComparison(tempStack.peek(), s) <= 0) || s.equals("!"))) {
								if (tempStack.peek().equals("(")) {
									break;
								} else {
									if (!s.equals("(")) {
										tempQueue.enqueue(tempStack.pop());
									}
									break;
								}								
							}
						}
						tempStack.push(s);			
					}
				}
				// enqueue whatever is left in the stack
				while (!(tempStack.isEmpty())) {
					if (tempStack.peek().equals("(")) {
						tempStack.pop();
					} else {
						tempQueue.enqueue(tempStack.pop());
					}								
				}			
				
				// postfix evaluation
				try {
					calculate(tempStack, tempQueue);
				} catch (DNE e) {
					System.out.println("Calculation error at: " + temp); // calculation error message
					out.println("ERROR!");
					continue;
				} catch (NullPointerException e) {
					System.out.println("Invalid calculation at: " + temp); // invalid calculation error message
					out.println("ERROR!");
					continue;
				}
				out.println(tempStack.pop());
			}
			
			out.close();
			scan.close();
			System.out.println("BINGO!");
			System.out.println("You can check the results in the file 'my_eval'");
		} catch (FileNotFoundException e) {
			System.out.println("404 File Not Found");
		}
		input.close();
	}

}
