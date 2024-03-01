import java.util.ArrayList;
import java.util.Arrays;

public class PriorityQueue {
	MyQueue q;

	public PriorityQueue(MyQueue q) {
		super();
		this.q = q;
	}

	// implement this.
	public void push(int x) throws Exception {
		if (q.isEmpty()) {
			q.insertLast(x);
		} else {
			boolean hasInserted = false;
//			ArrayList<Integer> temp = new ArrayList<Integer>();
//			while (!q.isEmpty()) {
//				if (x < q.front() && !hasInserted) {
//					temp.add(x);
//					hasInserted = true;
//				}
//				temp.add(q.removeFirst());
//			}
//			if (!hasInserted) {
//				temp.add(x);
//			}
//			for (int i = 0;i < temp.size();i++ ) {
//				q.insertLast(temp.get(i));

//			}

			// Be careful size might not be constant in every loop
			int size = q.size();

			for (int i = 0; i < size; i++) {
				int thisQ = q.removeFirst();
				if (x < thisQ && !hasInserted) {

					// This could be done because the queue is sorted before
					q.insertLast(x);
					hasInserted = true;
				}
				q.insertLast(thisQ);
			}
			if (!hasInserted) {
				q.insertLast(x);
			}
		}

	}

	// implement this.
	public void pop() throws Exception {
		q.removeFirst();
	}

	// implement this
	public int top() throws Exception {
		return q.front();

	}

}
