// PROGRAMMER: COREY TAYLOR
public class SinglyLinkedListNode<E> {

	// INSTANCE VARIABLES
	private E element;
	private SinglyLinkedListNode<E> nextNode;

	// CONSTRUCTOR
	public SinglyLinkedListNode(E element, SinglyLinkedListNode<E> nextNode) {
		this.element = element;
		this.nextNode = nextNode;
	}

	// GETTERS & SETTERS
	public E getElement() {
		return element;
	}

	public void setNextNode(SinglyLinkedListNode<E> nextNode) {
		this.nextNode = nextNode;
	}

	public SinglyLinkedListNode<E> getNextNode() {
		return nextNode;
	}
}
