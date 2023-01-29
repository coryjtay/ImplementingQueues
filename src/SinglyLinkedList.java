import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.NoSuchElementException;

// PROGRAMMER: COREY TAYLOR
public class SinglyLinkedList<E> {

	// INSTANCE VARIABLES
	private int size;
	private SinglyLinkedListNode<E> head = null;
	private SinglyLinkedListNode<E> tail = null;

	// CONSTRUCTOR
	public SinglyLinkedList() {
		size = 0;
	}

	// INSTANCE METHODS
	public void addFirst(E element) {
		SinglyLinkedListNode<E> newNode = new SinglyLinkedListNode<E>(element, head);
		head = newNode;
		size++;
		if (tail == null) {
			tail = newNode;
		}
	}

	public void addLast(E element) {
		SinglyLinkedListNode<E> newNode = new SinglyLinkedListNode<E>(element, null);
		if (tail == null) {
			head = newNode;
		} else {
			tail.setNextNode(newNode);
		}
		tail = newNode;
		size++;
	}

	public E removeFirst() throws IOException {
		if (size == 0) {
			throw new NoSuchElementException("Cannot remove first element from an empty list");
		} else {
			E firstElement = head.getElement();
			if (size == 1) {
				head = null;
				tail = null;
			} else {
				head = head.getNextNode();
			}
			size--;
			return (firstElement);
		}
	}

	public E removeLast() throws IOException {
		if (size == 0) {
			throw new NoSuchElementException("Cannot remove last element from an empty list");
		} else if (size == 1) {
			return (removeFirst());
		} else {
			SinglyLinkedListNode<E> currentNode = head;
			E lastElement = tail.getElement();
			for (int index = 0; index < (size - 2); index++) {
				currentNode = currentNode.getNextNode();
			}
			currentNode.setNextNode(null);
			tail = currentNode;
			size--;
			return (lastElement);
		}
	}

	public E getFirst() {
		if (head.getElement() == null) {
			throw new NoSuchElementException("Cannot get first element from an empty list");
		} else {
			return head.getElement();
		}
	}

	public E getLast() {
		if (tail.getElement() == null) {
			throw new NoSuchElementException("Cannot get last element from an empty list");
		} else {
			return tail.getElement();
		}
	}

	public int getSize() {
		return size;
	}

	public int occurences(E element) {
		int count = 0;
		SinglyLinkedListNode<E> currentNode = head;
		while (currentNode != null) {
			if (element == currentNode.getElement()) {
				count++;
			}
			currentNode = currentNode.getNextNode();
		}
		return count;
	}

	@SuppressWarnings("resource")
	public void saveToFile(String filename) throws FileNotFoundException {
		PrintWriter outputFile = new PrintWriter(filename);
		if (head.getElement() == null) {
			throw new NoSuchElementException("Cannot create file with empty list");
		}
		outputFile.println(head.getElement());
		SinglyLinkedListNode<E> currentNode = head;
		for (int index = 0; index < size - 1; index++) {
			currentNode = currentNode.getNextNode();
			outputFile.println(currentNode.getElement());
		}
		outputFile.close();
	}
}
