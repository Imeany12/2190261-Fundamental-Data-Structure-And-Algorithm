
public class StudentList extends CDLinkedList {
	// you can write additional methods.

	// implement this method
	public void swapNode(DListIterator i1, DListIterator i2) {
//		previous node
		i1.currentNode.previousNode.nextNode = i2.currentNode;
		i2.currentNode.previousNode.nextNode = i1.currentNode;

//		after node
		i1.currentNode.nextNode.previousNode = i2.currentNode;
		i2.currentNode.nextNode.previousNode = i1.currentNode;

//		current node
		DListNode previousNode = i1.currentNode.previousNode;
		i1.currentNode.previousNode = i2.currentNode.previousNode;
		i2.currentNode.previousNode = previousNode;

		DListNode nextNode = i1.currentNode.nextNode;
		i1.currentNode.nextNode = i2.currentNode.nextNode;
		i2.currentNode.nextNode = nextNode;

	}

	// implement this method
	public void insertList(DListIterator i1, CDLinkedList lst) {
		if (lst.isEmpty()) {
			return;
		}

		DListNode nextNode = i1.currentNode.nextNode;
		DListNode previousNode = lst.header.previousNode;
		i1.currentNode.nextNode = lst.header.nextNode;
		lst.header.nextNode.previousNode = i1.currentNode;

		lst.header.previousNode.nextNode = nextNode;
		nextNode.previousNode = previousNode;

	}

	// implement this method
	public void gender(String g) throws Exception {
		DListIterator itr = new DListIterator(this.header);
		DListIterator h = new DListIterator(this.header);
		printList();
		while (itr.currentNode.nextNode != header) {
			itr.next();
			if ((((Student) itr.currentNode.data).getSex()).equals(g)) {
				super.insert(itr.currentNode.data, h);
				h.next();

				itr.currentNode.previousNode.nextNode = itr.currentNode.nextNode;
				itr.currentNode.nextNode.previousNode = itr.currentNode.previousNode;

			}
		}
	}

}
