import java.io.IOException;
import java.io.PrintWriter;

// PROGRAMMER: COREY TAYLOR
public class DynamicQueue<E> {

	// INSTANCE VARIABLES
	private SinglyLinkedList<E> queue;

	// CONSTRUCTORS
	public DynamicQueue() {
		queue = new SinglyLinkedList<E>();
	}

	public DynamicQueue(E[] array) {
		queue = new SinglyLinkedList<E>();
		for (int index = 0; index < array.length; index++) {
			queue.addLast(array[index]);
		}
	}

	// METHODS
	public void offer(E element) {
		queue.addLast(element);
	}

	public E poll() throws IOException {
		return queue.removeFirst();
	}

	public E peek() {
		return queue.getFirst();
	}

	public int getSize() {
		return queue.getSize();
	}

	public void saveToFile(String filename) throws IOException {
		PrintWriter outputFile = new PrintWriter(filename);
		int size = getSize();
		for (int index = 0; index < size; index++) {
			outputFile.println(queue.removeFirst());
		}
		outputFile.close();
	}
}
