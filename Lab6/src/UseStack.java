
public class UseStack {

	// implement this method.
	public static Stack sort(Stack s) throws Exception {
		Stack tempStack = new ArrayListStack();
		while (!s.isEmpty()) {
			int tempData = s.top();
			s.pop();
			while (!tempStack.isEmpty() && tempStack.top() < tempData) {
				s.push(tempStack.top());
				tempStack.pop();
			}
			tempStack.push(tempData);

		}
		return tempStack;

	}

}
