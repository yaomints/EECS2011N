
import java.util.Stack;


/**
 * Yu Zhong Yao
 * 215472616
 * Assignment 2
 * @author yao21 *
 * @param <E>
 * 
 * Augmentend Stack that is able to return the minimum value, push, pop, check if empty, and return top
 * in O(1)
 */

public class AugmentedStack<E  extends Comparable<E> > {
	
	
	
	
	/**Nested
	 * Node class which fields are minimum element determined by comparable,
	 * element, and pointer to the Node under
	 * @author yao21
	 *
	 * @param <E>
	 */
		public class Node<E  extends Comparable<E>> {
			private E min;
			private E element;
			private Node<E> under;
		
			/**
			 * 
			 * @param e element inputted
			 * @param n previous top of stack Node
			 */
			public Node(E e, Node<E> n){
				this.element = e;
				this.under = n;
				if(isEmpty()) {
				this.min = e;
				}
				else {
					if(e.compareTo(this.getUnder().min) < 0) {
						this.min = e;
					}
					else {
						this.min = this.getUnder().min;
					}
				}
			}
			/**
			 * 
			 * @return element
			 */
			public E getElement() {
				return this.element;
			}
			
			/**
			 * 
			 * @return reference to Node that is below this Node
			 */
			public Node<E> getUnder(){
				return this.under;
			}
		
		}
		
		/******
		 * End of nested class Node
		 */
		
		
		
		
		
		
		
		
		
		
		private Node<E> top = null;
		private int size;
		
		
		public AugmentedStack() {
			
		}
		
		/**
		 * 
		 * @param e element to be placed in node
		 */
		public void push(E e) {
			Node<E> old = top;
			top = new Node<>(e, old);
			size++;
		}
		
		/**
		 * 
		 * @return top stack Node's element or null if empty
		 */
		public E pop() {
			if(isEmpty()) {
				return null;
			}
			else {
				Node<E> temp = this.top;
				this.top = this.top.getUnder();
				size--;
				return  (E) temp.getElement();
				
			}
		}
		
		/**
		 * 
		 * @return true if empty
		 */
		public boolean isEmpty() {
			if(size == 0) {
				return true;
			}
			return false;
		}
		
		/**
		 * 
		 * @return top Node on stack's element
		 */
		public E top() {
			if(isEmpty()) {
				return null;
			}
			else {
			return this.top.getElement();
			}
		}
		
		/**
		 * 
		 * @return minimum element
		 */
		public E getMin() {
			if(isEmpty()) {
				return null;
			}
			return this.top.min;
		}
		
		
		
		
		
		
		public static void main(String[] args) {
			AugmentedStack<Integer> as = new AugmentedStack<Integer>();
			Integer a = 0;
			int d = -1;
			int c = 2;
			int b = 5;
			
			as.push(a);
			as.push(b);
			as.push(c);
			as.push(d);
			System.out.println(as.isEmpty());
			System.out.println(as.size);
			System.out.println(as.top());
			as.pop();
			System.out.println(as.top());
			System.out.println(as.getMin());
			as.pop();
			as.pop();
			as.pop();
			as.pop();
			System.out.println(as.getMin());
			System.out.println(as.top());
			System.out.println(as.size);
			System.out.println(as.isEmpty());
			as.push(b);
			as.push(c);
			as.push(d);
			as.pop();
			System.out.println(as.getMin());
			System.out.println(as.top());
			System.out.println(as.size);
			System.out.println(as.isEmpty());
			
			
			AugmentedStack<String> q = new AugmentedStack<String>();
			String w = "Hello";
			String e = "Hello";
			String r = "";
			String t = "yerrrrrrrr";
			q.push(w);
			q.push(e);
			q.push(r);
			q.push(t);
			System.out.println(q.getMin());
			System.out.println(q.top());
			System.out.println(q.size);
			System.out.println(q.isEmpty());
			
			
			AugmentedStack<Character> p = new AugmentedStack<Character>();
			char z = 'a';
			char y = 'b';
			char x = 'c';
			char m = '0';
			p.push(z);
			p.push(m);
			p.push(y);
			p.push(x);
			System.out.println(p.getMin());
			System.out.println(p.top());
			System.out.println(p.size);
			System.out.println(p.isEmpty());
			p.pop();
			System.out.println(p.top());
		}
		

	
}
