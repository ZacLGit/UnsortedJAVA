import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author simont
 *
 */
public class ListTest extends DSUnitTesting {

    @Test
    public void testList_CopyConstructor() {
		
		/* The copy constructor implementation requires a deep copy. 
		 * That is, after copying the object changes to the original should not impact the copied object.
		 */
		DSLinkedList s = new DSLinkedList();
		s.add(new Token(0));
		s.add(new Token(1));
		
		DSLinkedList other = new DSLinkedList(s);
		
		assertEquals("Copy constructor should create a List of equal size to the copied List", other.size(), 2);
		for ( int i = 0 ; i < 2 ; ++i ) {
			assertEquals("Copy constructor did not copy the List correctly", other.remove(i), new Token(i));
		}

		
		s.add(new Token(2));
		assertEquals("Changes to original list should not impact the second list", other.size(), 0);
		
    }
    @Test
    public void testList_Node() {
    	DSLinkedList l = new DSLinkedList(new Node(null, null, new Token(3)));
    	
    	assertEquals("Constructor that accepts a Node should set the given Node to the head of the list", l.size(), 1);
    	
    }

    @Test
    public void testRemoveIntBeginning() {
    	fail("Not yet implemented");
    }
    @Test
    public void testRemoveIntEnd() {
    	fail("Not yet implemented");
    }

	@Test
	public void testAddIntToken() {
		List list = new DSLinkedList();
		
		list.add(new Token(1));
		list.add(0, new Token(0));
		
		assertEquals("List.add(int, Token) should insert the specified token at the specified index.", list.get(0), new Token(0));
		
		
		
		list.add(2, new Token(2));
		assertEquals("List.add(int, Token) should insert the specified token at the specified index.", list.get(2), new Token(2));
		
		list.add(2, new Token(3));
		assertEquals("List.add(int, Token) should insert the specified token at the specified index.", list.get(2), new Token(3));
		
		assertEquals(list.size(), 4);
	}

	/**
	 *  method for {@link List#contains(java.lang.Object)}.
	 */
	@Test
	public void testContains() {

		List list = new DSLinkedList();
		for ( int i = 0 ; i < 3 ; ++i ) 
			list.add(new Token(i));
	
		for ( int i = 0 ; i < 3 ; ++i ) 
			assertTrue("List.contains(Token) should return true when the token is in the list.", list.contains(new Token(i)));

		
		list = new DSLinkedList();
		list.add(new Token(0));
		list.add(new Token(1));
		list.add(new Token(2));
		
		assertFalse("List.contains() should return false when the token is not in the list", list.contains(new Token(4)));
		assertFalse("List.contains() should return false when the token is not in the list", list.contains(new Token(-1)));
	}

	/**
	 *  method for {@link List#get(int)}.
	 */
	@Test
	public void testGet() {
		
		List list = new DSLinkedList();
		list.add(new Token(0)); 
		list.add(new Token(1));
		list.add(new Token(2));
		
		assertEquals("List.get() isn't returning the correct item.", list.get(0), new Token(0));
		assertEquals("List.get() isn't returning the correct item.", list.get(2), new Token(2));
		assertEquals("List.get() isn't returning the correct item.", list.get(1), new Token(1));
	}
	
	
	@Test
	public void testIndexOf() {
		List list = new DSLinkedList();
		
		list.add(new Token(0));
		list.add(new Token(1));
		
		assertEquals("List.indexOf() should return the correct index", list.indexOf(new Token(1)), 1);
	}

	@Test
	public void testRemoveInt() {
		List list = new DSLinkedList();
		
		list.add(new Token(0));
		list.add(new Token(1));
		list.add(new Token(2));
		list.add(new Token(3));
		
		assertEquals("List.add() should add tokens to the list. (List: [" + list.toString() + "])", list.size(), 4);

		assertEquals("List.get() should return the token at the specified index. (List: [" + list.toString() + "])", 
				list.get(1), new Token(1));
		list.remove(1);
		assertEquals("List.remove(int) should decrement the size by one. (List: [" + list.toString() + "])", list.size(), 3);
		
		assertEquals("List.get() should return the token at the specified index. (List: [" + list.toString() + "])", 
				list.get(1), new Token(2));
		
	}
	
	/**
	 *  method for {@link List#remove(java.lang.Object)}.
	 */
	@Test
	public void testRemoveToken_Beginning() {
		
		List list = new DSLinkedList();
		list.add(new Token(0));
		list.add(new Token(1));
		list.add(new Token(2));
		
		assertTrue("List.remove() should return true when removing an existing object", list.remove(new Token(0)));
		assertEquals("List.size() should decrement after a remove().", list.size(), 2);
		assertTrue("List.remove() should remove the given object", list.toString().equals("1.0 2.0"));
	}

	/**
	 *  method for {@link List#remove(java.lang.Object)}.
	 */
	@Test
	public void testRemoveToken_End() {
		
		List list = new DSLinkedList();
		list.add(new Token(0));
		list.add(new Token(1));
		list.add(new Token(2));
		
		assertTrue("List.remove() should return true when removing an existing object", list.remove(new Token(2)));
		assertEquals("List.size() should decrement after a remove().", list.size(), 2);
		assertTrue("List.remove() should remove the given object", list.toString().equals("0.0 1.0"));
	}
	
	/**
	 *  method for {@link List#remove(java.lang.Object)}.
	 */
	@Test
	public void testRemoveToken_Middle() {
		
		List list = new DSLinkedList();
		list.add(new Token(0));
		list.add(new Token(1));
		list.add(new Token(2));
		
		assertTrue("List.remove() should return true when removing an existing object", list.remove(new Token(1)));
		assertEquals("List.size() should decrement after a remove().", list.size(), 2);
		assertTrue("List.remove() should remove the given object", list.toString().equals("0.0 2.0"));
	}

	@Test
	public void testRemoveToken_Single() {
		
		List list = new DSLinkedList();
		list.add(new Token(0));
		list.add(new Token(1));
		list.add(new Token(2));
		list.add(new Token(1));
		
		assertTrue("List.remove(Token) should remove the first instance of the specified token.", list.remove(new Token(1)));
		assertTrue("List.remove(Token) should only remove one instance of the specified token!", list.toString().equals("0.0 2.0 1.0"));
	}
	
	/* This is the collections interface, tested seperately.
	@Test
	public void testSize() {
		List list = new DSLinkedList();
		assertEquals("List.size() should return 0 for new, empty list", list.size(), 0);
		
		list.add(new Token(0));
		list.add(new Token(1));
		list.add(new Token(2));
		assertEquals("List.size() should return 3 when 3 items are contained in the list", list.size(), 3);
	
		list.remove(1);
		assertEquals("List.size() should return 2 when an item is removed from a list with 3 elements", list.size(), 2);
	} 

	@Test
	public void testToString() {
		List list = new DSLinkedList();
		list.add(new Token(0.0f));
		list.add(new Token(1.0f));
		list.add(new Token(2.0f));
		
		assertEquals("List.tostring() fails: expected [0.0 1.0 2.0], got: " + list.toString(), 
				list.toString(), "0.0 1.0 2.0");
	}
	


	*/
}
