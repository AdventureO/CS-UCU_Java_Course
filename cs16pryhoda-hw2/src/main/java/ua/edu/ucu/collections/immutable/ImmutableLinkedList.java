package ua.edu.ucu.collections.immutable;

public class ImmutableLinkedList implements ImmutableList{

    final LinkedNode head;
    final int size;

    public ImmutableLinkedList(LinkedNode head, int size) {
        this.head = head;
        this.size = size;
    }

    public ImmutableLinkedList() {
        this.head = null;
        this.size = 0;
    }

    public ImmutableLinkedList add(Object e) {
        if (this.size == 0) {
            ImmutableLinkedList resultArray = new ImmutableLinkedList(new LinkedNode(e), this.getSize() + 1);
            return resultArray;
        }
        else {
            LinkedNode new_head = cloneLinkedList();
            LinkedNode current_node = new_head;
            while (current_node.next != null) {
                current_node = current_node.next;
            }
            current_node.next = new LinkedNode(e);
            ImmutableLinkedList resultArray = new ImmutableLinkedList(new_head, this.getSize() + 1);
            return resultArray;
        }
    }

    public ImmutableLinkedList add(int index, Object e) {
        if (index >= this.getSize()) {
            throw new IndexOutOfBoundsException();
        }
        LinkedNode cloneLinkedList = cloneLinkedList();
        LinkedNode nodeCurrent = cloneLinkedList;
        if (index == -1) index = this.size();
        if (index == 0) {
            ImmutableLinkedList workList = new ImmutableLinkedList(new LinkedNode(e), getSize() + 1);
            LinkedNode toUse = workList.getHead();
            toUse.next = nodeCurrent;
            toUse = toUse.next;
            while (nodeCurrent.next != null) {
                toUse.next = nodeCurrent.next;
                toUse = toUse.next;
                nodeCurrent = nodeCurrent.next;


            }
            return workList;
        }
        int i = 0;

        LinkedNode newLinkedList = cloneLinkedList();
        LinkedNode tempLinkedList = newLinkedList;

        while (i < this.size) {
            if (i < index - 1) {
                cloneLinkedList = cloneLinkedList.next;
                tempLinkedList = tempLinkedList.next;

            } else if (i == index - 1) {
                tempLinkedList.next = new LinkedNode(e);
                tempLinkedList = tempLinkedList.next;

            } else if (i > index - 1) {
                cloneLinkedList = cloneLinkedList.next;
                tempLinkedList.next = cloneLinkedList;
                tempLinkedList = tempLinkedList.next;
            }
            i++;
        }
        return ReturnNewLinkedList(newLinkedList);
    }

    public ImmutableLinkedList addAll(Object[] c) {
        LinkedNode copyArray = cloneLinkedList();
        LinkedNode tempArray = copyArray;
        while (tempArray.next != null) {
            tempArray = tempArray.next;
        }
        for (int i = 0; i < c.length; i++) {
            tempArray.next = new LinkedNode(c[i]);
            tempArray = tempArray.next;
        }
        return ReturnNewLinkedList(copyArray);
    }

    public ImmutableLinkedList addAll(int index, Object[] c) {
        if (index >= size) throw new IndexOutOfBoundsException();
        LinkedNode cloneLinkedList = cloneLinkedList();
        if (index == -1) index = this.getSize();
        if (index == 0) {
            LinkedNode node = new LinkedNode(c[0]);
            LinkedNode tempNode = node;
            for (int z = 1; z < c.length; z++) {
                tempNode.next = new LinkedNode(c[z]);
                tempNode = tempNode.next;
            }
            while (cloneLinkedList != null) {
                tempNode.next = cloneLinkedList;
                tempNode = tempNode.next;
                cloneLinkedList = cloneLinkedList.next;
            }
            return ReturnNewLinkedList(node);
        }
        LinkedNode secondCloneLinkedList = cloneLinkedList();
        LinkedNode tempLinkedList = secondCloneLinkedList;
        for (int z = 0; z < index - 1; z++) {
            tempLinkedList = tempLinkedList.next;
            cloneLinkedList = cloneLinkedList.next;
        }
        for (int x = 0; x < c.length; x++) {
            tempLinkedList.next = new LinkedNode(c[x]);
            tempLinkedList = tempLinkedList.next;
        }
        while (cloneLinkedList.next != null) {
            tempLinkedList.next = cloneLinkedList.next;
            tempLinkedList = tempLinkedList.next;
            cloneLinkedList = cloneLinkedList.next;
        }
        return ReturnNewLinkedList(secondCloneLinkedList);
    }

    public ImmutableLinkedList ReturnNewLinkedList(LinkedNode e) {
        ImmutableLinkedList newList = new ImmutableLinkedList(e, this.getSize());
        LinkedNode currentNode = newList.getHead();
        int count = 0;
        while (currentNode != null) {
            currentNode = currentNode.next;
            count++;
        }
        ImmutableLinkedList finalList = new ImmutableLinkedList(e, count);
        return finalList;
    }

    public LinkedNode cloneLinkedList() {
        if (this.head != null) {
            LinkedNode current_node = this.head;
            LinkedNode clone_head = new LinkedNode(current_node.getData());
            LinkedNode current_node_clone = clone_head;
            while (current_node.next != null) {
                current_node = current_node.next;
                current_node_clone.next = current_node.clone();
                current_node_clone = current_node_clone.next;
            }
            return clone_head;
        }
        return null;
    }

    public Object get(int index) {
        if (index >= size) throw new IndexOutOfBoundsException();
        else {
            int i = 0;
            LinkedNode array = cloneLinkedList();
            while (i != index) {
                array = array.next;
                i++;
            }
            return array.getData();
        }
    }

    public ImmutableLinkedList remove(int index) {
        if (index >= this.getSize()) throw new IndexOutOfBoundsException();
        LinkedNode element = cloneLinkedList();
        LinkedNode list = element;
        LinkedNode tempList = cloneLinkedList();
        int i = 0;
        if (index == -1) index = this.getSize() - 1;
        while (list.next != null) {
            if (index == 0) {
                return ReturnNewLinkedList(element.next);
            } else if (index - 1 == i) {
                tempList = tempList.next.next; list.next = tempList;
            } else {
                list = list.next; tempList = tempList.next;
            }
            i++;
        }
        return ReturnNewLinkedList(element);
    }

    public ImmutableLinkedList set(int index, Object e) {
        if (index >= size) throw new IndexOutOfBoundsException();
        else {
            LinkedNode copyArray = cloneLinkedList();
            LinkedNode secondCopyArray = copyArray;
            int i = 0;
            while (secondCopyArray != null) {
                if (index == i) {
                    ImmutableLinkedList arrayWithoutElement = this.remove(i);
                    ImmutableLinkedList arrayWithElement = arrayWithoutElement.add(i, e);
                    LinkedNode resultArray = arrayWithElement.cloneLinkedList();
                    return new ImmutableLinkedList(resultArray, size);
                }
                secondCopyArray = secondCopyArray.next;
                i++;
            }
            return new ImmutableLinkedList(copyArray, size);
        }
    }

    public int indexOf(Object e) {
        LinkedNode copyArray = cloneLinkedList();
        int i = 0;
        while (i != size()) {
            if (copyArray.getData().equals(e)) return i;
            copyArray = copyArray.next;
            i++;
        }
        return -1;
    }

    public int size() {
        return this.size;
    }

    public ImmutableLinkedList clear() {
        LinkedNode copyArray = cloneLinkedList();
        int steps = 0;
        while (steps < size) {
            copyArray = null;
            steps++;
        }
        return new ImmutableLinkedList(copyArray, 0);
    }

    public Object getFirst() {
        return this.getHead().getData();
    }

    public Object getLast() {
        LinkedNode array = this.getHead();
        while (array.next != null) array = array.next;
        return array.getData();
    }

    public ImmutableLinkedList removeFirst() {
        return this.remove(0);
    }

    public ImmutableLinkedList removeLast() {
        return this.remove(-1);
    }

    public ImmutableLinkedList addFirst(Object e) {
        return this.add(0, e);
    }

    public ImmutableLinkedList addLast(Object e) {
        return add(-1, e);
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public Object[] toArray() {
        Object[] array = new Object[size()];
        LinkedNode linkedArray = cloneLinkedList();
        for(int i = 0; i < size(); i++){
            array[i] = linkedArray.getData();
            linkedArray = linkedArray.next;
        }
        return array;
    }

    private LinkedNode getHead() {
        return this.head;
    }

    private int getSize() {
        return this.size;
    }

    public ImmutableLinkedList clone() throws CloneNotSupportedException {
        return (ImmutableLinkedList) super.clone();
    }

    public String toString() {
        String result = "";
        LinkedNode start = this.head;
        while (start != null) {
            if (start.next == null) {
                result += start.getData().toString();
            } else {
                result += start.getData().toString() + " -> ";
            }
            start = start.next;
        }
        return result;

    }

}
