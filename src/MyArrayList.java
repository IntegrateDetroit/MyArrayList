public class MyArrayList {
    private int size = 0;

    private int[] array;

    public MyArrayList() {
        array = new int[10];
    }

    public MyArrayList(int capacity){
        array = new int[capacity];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(int numberToAdd) {
        array[size] = numberToAdd;
        size++;
    }

    public int size() {
        return size;
    }

    public int get(int index) {
        return array[index];
    }

    public int indexOf(int targetElement) {
        for (int index = 0; index < size; index++) {
            int valueAtCurrentIndex = array[index];
            if (valueAtCurrentIndex == targetElement) {
                return index;
            }
        }
        return -1;
    }

    public boolean contains(int element) {
        if (indexOf(element) >= 0) {
            return true;
        }
        return false;
    }

    public int set(int index, int element) {
        int oldValue = array[index];
        array[index] = element;
        return oldValue;
    }

    public void add(int index, int element) {

        for(int i = (size - 1); i >= index; i--){
            array[i +1] = array[i];
        }

        array[index] = element;

    }
}
