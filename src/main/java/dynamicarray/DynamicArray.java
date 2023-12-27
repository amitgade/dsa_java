package dynamicarray;

/**
 * Created by amitgade on 28-Jan-2021
 */
public class DynamicArray<String> {

    private Object[] data;
    private int size;
    private int initialCapacity;

    public DynamicArray(int initialCapacity) {
        this.initialCapacity = initialCapacity;
        data = new Object[initialCapacity];
    }

    public String get(int index) {
        return (String) data[index];
    }

    public void set(int index, String value) {
        data[index] = value;
    }

    public void insert(int index, String value) {
        // check size
        if (size == initialCapacity) {
            this.reSize();
        }

        if (index != size) {
            // copy up
            for (int j = size; j > index; j--) {
                data[j] = data[j - 1];
            }
        }

        // Do insert
        data[index] = value;
        size++;
    }

    public void delete(int index) {

        // check for last element to delete
        if (index != size) {
            for (int j = index; j < size - 1; j++) {
                data[j] = data[j + 1];
            }
        }
        data[size-1] = null;
        size--;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean contains(String value) {
        for (int i = 0; i < size; i++) {
            String currentValue = (String) data[i];
            if (currentValue.equals(value)) {
                return true;
            }
        }
        return false;
    }

    public void reSize() {
        // double the capacity
        initialCapacity = initialCapacity * 2;

        // create a new array with double capacity
        Object[] newData = new Object[initialCapacity];

        //copy over
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        // reassign
        data = newData;
    }

    public int size() {
        return size;
    }

    public void add(String value) {
        // insert at the end i.e. index == size
        insert(size, value);
    }

    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.println("data[" + i + "] = " + data[i]);
        }
    }
}
