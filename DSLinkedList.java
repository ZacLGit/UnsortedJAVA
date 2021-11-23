import java.io.IOException;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;

public class DSLinkedList implements List {
	
	public Node head;

	public DSLinkedList() {
		
	}
	
	public DSLinkedList(Node head_) {
		this.head = head_;
	}
	
	public DSLinkedList(DSLinkedList other){ // Copy constructor. 
		
	}

	public Token remove(int index) {
		return null;
	}
	
	public int indexOf(Token obj) {
		return 0;
	}

	public Token get(int index) {
		int i = 0;
		return null;
	}

	public boolean isEmpty() {
		return false;
	}

	public int size() {
		return 0;	
	}
	
	@Override
	public String toString() {
		return null;
	}

	public boolean add(Token obj) {
		return false;
	}

	public boolean add(int index, Token obj) {
		
		return true;
	}

	public boolean contains(Token obj) {
		return false;
	}

	public boolean remove(Token obj) {
		return false;
	}
	
	@Override
	public int hashCode() {
		return 0;
	}

	@Override
	public boolean equals(Object other) {
		return false;
	}	
}
