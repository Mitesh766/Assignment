import java.util.Arrays;

public class DynamicArray {
    private int size;
    private int capacity;
    private int[] data;

    public DynamicArray(int size) {
        if (size <= 0) {
            System.out.println("Error: Size must be greater than 0. Initializing with capacity 10.");
            size = 10;
        }
        this.size = size;
        this.capacity = size * 2;
        this.data = new int[capacity];
    }

    public int get(int index) {
        if (index >= 0 && index < size) {
            return data[index];
        } else {
            System.out.println("Error: Index out of bound.");
            return -1;
        }
    }

    public void set(int index, int value) {
        if (index >= 0 && index < size) {
            data[index] = value;
        } else {
            System.out.println("Error: Index out of bound.");
        }
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void resize() {
        capacity *= 2; 
        int[] newArray = Arrays.copyOf(data, capacity);
        data = newArray;
    }

    public void append(int value) {
        if (size == capacity) {
            resize();
        }
        data[size++] = value;
    }

    public void prepend(int value) {
        insert(0, value);
    }

    public void insert(int index, int value) {
        if (index < 0 || index > size) {
            System.out.println("Error: Index out of bound.");
            return;
        }
        if (size == capacity) {
            resize();
        }
        for (int i = size; i > index; i--) {
            data[i] = data[i - 1];
        }
        data[index] = value;
        size++;
    }

    public void delete(int index) {
        if (index < 0 || index >= size) {
            System.out.println("Error: Index out of bound.");
            return;
        }
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        size--;
    }

    public void rotateRight(int k) {
        if (size == 0)
            return;
        k = k % size;
        if (k < 0)
            k += size;
        reverse(0, size - 1);
        reverse(0, k - 1);
        reverse(k, size - 1);
    }

    public void reverse() {
        reverse(0, size - 1);
    }

    private void reverse(int start, int end) {
        while (start < end) {
            int temp = data[start];
            data[start] = data[end];
            data[end] = temp;
            start++;
            end--;
        }
    }

    public static DynamicArray merge(DynamicArray arr1, DynamicArray arr2) {
        DynamicArray result = new DynamicArray(arr1.size + arr2.size);
        for (int i = 0; i < arr1.size; i++) {
            result.append(arr1.data[i]);
        }
        for (int i = 0; i < arr2.size; i++) {
            result.append(arr2.data[i]);
        }
        return result;
    }

    public static DynamicArray interleave(DynamicArray arr1, DynamicArray arr2) {
        DynamicArray result = new DynamicArray(arr1.size + arr2.size);
        int i = 0, j = 0;
        while (i < arr1.size && j < arr2.size) {
            result.append(arr1.data[i++]);
            result.append(arr2.data[j++]);
        }
        while (i < arr1.size) {
            result.append(arr1.data[i++]);
        }
        while (j < arr2.size) {
            result.append(arr2.data[j++]);
        }
        return result;
    }

    public int middleElement() {
        if (size == 0) {
            System.out.println("Error: Array is empty.");
            return -1;
        }
        return data[size / 2];
    }

    public int indexOf(int element) {
        for (int i = 0; i < size; i++) {
            if (data[i] == element) {
                return i;
            }
        }
        return -1;
    }

    public DynamicArray[] splitAtIndex(int index) {
        if (index < 0 || index > size) {
            System.out.println("Error: Index out of bound.");
            return null;
        }
        DynamicArray first = new DynamicArray(index);
        DynamicArray second = new DynamicArray(size - index);
        for (int i = 0; i < index; i++) {
            first.append(data[i]);
        }
        for (int i = index; i < size; i++) {
            second.append(data[i]);
        }
        return new DynamicArray[] { first, second };
    }

    public static void main(String[] args) {
        DynamicArray arr = new DynamicArray(5);
        arr.append(1);
        arr.append(2);
        arr.append(3);

        arr.prepend(0);

        arr.insert(2, 10);

        arr.delete(2);

        arr.rotateRight(2);

        arr.reverse();

    }
}
