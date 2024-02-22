import java.util.ArrayList;

public class ArrayListStack implements Stack {
	private ArrayList<Integer> a;

	// implement a default constructor and all methods from interface Stack.
	// Additional methods maybe required in order to run tests.
	public ArrayListStack() {
		a = new ArrayList<Integer>();
	}

	public ArrayList<Integer> getA() {
		return a;
	}

	@Override
	public boolean isEmpty() {
		if (a.size() == 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean isFull() {
		if (a.size() >= 100000) {
			return true;
		}
		return false;
	}

	@Override
	public void makeEmpty() {
		a = new ArrayList<Integer>();
	}

	@Override
	public int top() throws Exception {
		if (isEmpty()) {
			throw new Exception();
		}
		return a.get(a.size() - 1);
	}

	@Override
	public void pop() throws Exception {
		if (isEmpty()) {
			throw new Exception();
		}
		a.remove(a.size() - 1);
	}

	@Override
	public void push(int data) throws Exception {
		a.add(data);
	}
	

}
