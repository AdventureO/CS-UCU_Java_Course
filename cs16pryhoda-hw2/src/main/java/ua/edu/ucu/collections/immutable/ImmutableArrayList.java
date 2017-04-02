package ua.edu.ucu.collections.immutable;

public class ImmutableArrayList implements ImmutableList{

    final int size;
    final Object[] data;

    public ImmutableArrayList() {
        this.size = 0;
        this.data = null;
    }

    public ImmutableArrayList(Object[] data) {
        this.data = data;
        this.size = this.data.length;
    }

    public Object[] getData() {
        return this.data;
    }

    @Override
    public ImmutableArrayList add(Object e) {
        Object[] immutArrayList = new Object[this.size() + 1];
        for (int i = 0; i < this.size(); i++) {
            immutArrayList[i] = this.data[i];
        }

        immutArrayList[this.size()] = e;
        return new ImmutableArrayList(immutArrayList);
    }

    @Override
    public ImmutableArrayList add(int index, Object e) {
        Object[] immutArrayList = new Object[this.size() + 1];
        for (int i = 0; i < index; i++) {
            immutArrayList[i] = this.data[i];
        }

        immutArrayList[index] = e;
        for (int i = index; i < this.size(); i++) {
            immutArrayList[i + 1] = this.data[i];
        }
        return new ImmutableArrayList(immutArrayList);
    }

    @Override
    public ImmutableArrayList addAll(Object[] c) {
        Object[] immutArrayList = new Object[this.size + c.length];
        for (int i = 0; i < this.size(); i++) {
            immutArrayList[i] = this.data[i];
        }

        for (int i = 0; i < c.length; i++) {
            immutArrayList[this.size + i] = c[i];
        }
        return new ImmutableArrayList(immutArrayList);
    }

    @Override
    public ImmutableArrayList addAll(int index, Object[] c) {
        if (index == -1) index = this.size();

        Object[] immutArrayList = new Object[this.size + c.length];
        for (int i = 0; i < index; i++) {
            immutArrayList[i] = this.data[i];
        }

        for (int i = 0; i < c.length; i++) {
            immutArrayList[index + i] = c[i];
        }

        for (int i = 0; i < this.size() - index; i++) {
            immutArrayList[c.length + i] = this.data[index + i];
        }

        return new ImmutableArrayList(immutArrayList);
    }

    @Override
    public Object get(int index) {
        if (index < this.size && index >= 0) {
            return this.data[index];
        }
        throw new IndexOutOfBoundsException();
    }

    @Override
    public ImmutableArrayList remove(int index) {
        if (index == -1) index = this.size()-1;

        Object[] immutArrayList = new Object[this.size() - 1];
        for (int i = 0; i < index; i++) {
            immutArrayList[i] = this.data[i];
        }

        for (int i = index; i < this.size()-1; i++ ) {
            immutArrayList[i] = this.data[i + 1];
        }
        return new ImmutableArrayList(immutArrayList);
    }

    @Override
    public ImmutableArrayList set(int index, Object e) {
        if (index == -1) index = this.size()-1;

        Object[] immutArrayList = new Object[this.size()];
        for (int i = 0; i < this.size(); i++) {
            if (i == index) {
                immutArrayList[index] = e;
            }
            else {
                immutArrayList[i] = this.data[i];
            }
        }
        return new ImmutableArrayList(immutArrayList);
    }

    @Override
    public int indexOf(Object e) {
        for (int i = 0; i < this.size(); i++) {
            if (this.data[i] == e) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public ImmutableArrayList clear() {
        return new ImmutableArrayList();
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public Object[] toArray() {
        Object[] immutArrayList = new Object[this.size()];
        for (int i = 0; i < this.size(); i++) {
            immutArrayList[i] = this.data[i];
        }
        return immutArrayList;
    }

    @Override
    public String toString() {
        String stringResult = "";
        for (int i = 0; i<this.size(); i++) {
            stringResult += this.data[i] + ",";
        }
        return stringResult;
    }
}