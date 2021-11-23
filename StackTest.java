import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * @author simont
 *
 */
public class StackTest extends DSUnitTesting {

	Stack myStack;
	
	@Before
	public void setup() {
		myStack = new DSStack();
	}

	@Test
	public void testStack() {
		/* We can't really test the initalization of the internal storage of Stack, (because it's protected). 
		 * So we'll check that the stack behaves properly when it's newly created: size is 0, says it's empty, etc. 
		 */
		Stack s = new DSStack();
		assertTrue("Newly created Stack should be empty", s.isEmpty() );
		assertEquals("Newly created Stack should have size of 0", s.size(), 0);

	}

	@Test
	public void testStack_CopyConstructor() {
		
		/* The copy constructor implementation requires a deep copy. 
		 * That is, after copying the object changes to the original should not impact the copied object.
		 */
		Stack s = new DSStack();
		s.add(new Token(0));
		s.add(new Token(1));
		
		Stack other = new DSStack(s);
		
		assertEquals("Copy constructor should create a Stack of equal size to the copied Stack", other.size(), 2);
		for ( int i = 0 ; i < 2 ; ++i ) {
			assertEquals("Copy constructor did not copy the Stack correctly", other.pop(), new Token(i));
		}

		
		s.push(new Token(2));
		assertEquals("Changes to original stack should not impact the second stack", other.size(), 0);
		
	}


	/**
	 * Test method for {@link Stack#peek()}.
	 */
	@Test
	public void testPeek() {
		
		myStack.add(new Token(0));
		assertEquals("Stack.peek() should return the object at the top of the stack.", myStack.peek(), new Token(0));
		assertFalse("Stack.peek() should not remove the object from the stack.", myStack.isEmpty());
	}

	/**
	 * Test method for {@link Stack#pop()}.
	 */
	@Test
	public void testPop() {
		myStack.add(new Token(0));
		assertEquals("Stack.pop() should return the object at the top of the stack.", myStack.pop(), new Token(0));
		assertTrue("Stack.pop() should remove the object from the stack.", myStack.isEmpty());
	}

	/**
	 * Test method for {@link Stack#push(java.lang.Object)}.
	 */
	@Test
	public void testPush() {
		myStack.push(new Token(0));
		myStack.push(new Token(1));
		assertEquals("Stack.push() should add to the top of the stack", myStack.peek(), new Token(1));
		assertEquals("Stack.push() didn't result in the correct size stack", myStack.size(), 2);
	}

}
