import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * @author simont
 *
 */
public class QueueTest extends DSUnitTesting {

	Queue myQueue;
	
	@Before
	public void setup() {
		myQueue = new DSQueue();
	}
	
	@Test
	public void testQueue() {
		/* We can't really test the initalization of the internal storage of Queue, (because it's protected). 
		 * So we'll check that the queue behaves properly when it's newly created: size is 0, says it's empty, etc. 
		 */
		Queue s = new DSQueue();
		assertTrue("Newly created Queue should be empty", s.isEmpty() );
		assertEquals("Newly created Queue should have size of 0", s.size(), 0);
	}

	
	
	@Test
	public void testQueue_CopyConstructor() {
		
		/* The copy constructor implementation requires a deep copy. 
		 * That is, after copying the object changes to the original should not impact the copied object.
		 */
		Queue s = new DSQueue();
		s.add(new Token(0));
		s.add(new Token(1));
		
		Queue other = new DSQueue(s);
		
		assertEquals("Copy constructor should create a Queue of equal size to the copied Queue", other.size(), 2);
		for ( int i = 0 ; i < 2 ; ++i ) {
			assertEquals("Copy constructor did not copy the Queue correctly", other.poll(), new Token(i));
		}

		s.add(new Token(2));
		assertEquals("Changes to original queue should not impact the second queue", other.size(), 0);

	}
	/**
	 * Test method for {@link Queue#offer(java.lang.Object)}.
	 */
	@Test
	public void testOffer() {
		assertEquals("Fresh queue shouldn't contain objects", myQueue.size(), 0);
		
		assertTrue("Queue.offer() should return true if insertion succeeded", myQueue.offer(new Token(0)));
		assertEquals("Successful queue insertion should result in larger sized queue", myQueue.size(), 1);
		
		myQueue.offer(new Token(1));
		assertFalse("Queue.offer() should insert at the end of the queue!", myQueue.peek().equals(new Token(1)));
	}

	/**
	 * Test method for {@link Queue#poll()}.
	 */
	@Test
	public void testPoll() {
		myQueue.offer(new Token(0));
		myQueue.offer(new Token(1));
		
		assertEquals("Queue.poll() should return the first object in queue", myQueue.poll(), new Token(0));
		assertEquals("Queue.poll() should have decremented the queue size", myQueue.size(), 1);
		assertEquals("Queue.poll() should return the first object in queue", myQueue.poll(), new Token(1));
		assertEquals("Queue.poll() should have decremented the queue size", myQueue.size(), 0);
		
	}

	/**
	 * Test method for {@link Queue#peek()}.
	 */
	@Test
	public void testPeek() {
		
		myQueue.offer(new Token(0));
		myQueue.offer(new Token(1));
		
		assertEquals("Queue.peek() should return the first object in queue", myQueue.peek(), new Token(0));
		assertEquals("Queue.poll() should not have decremented the queue size", myQueue.size(), 2);
		assertEquals("Queue.peek() should return the same object in subsequent attempts without removal", 
				myQueue.peek(), new Token(0));
	}

}
