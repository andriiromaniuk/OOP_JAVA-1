
package laba9;

import java.io.*;
import java.util.Iterator;

public class Container implements Serializable, Iterator<String> {
    private int last = 0;
    private int size = 10;
    private String[] array = new String[size];
    private String[] toArray() { return array; }
    private void increaseSize() {
        size = (size * 3) / 2 + 1;
        String[] arrayCopy = new String[size];
        System.arraycopy(array, 0, arrayCopy, 0, array.length);
        array = arrayCopy;
    }
    public void add(String string) {
        if (last + 1 < size) array[last++] = string;
        else increaseSize();
    }
    public void clear() {
        size = 10;
        last = 0;
        array = new String[size];
    }
    public int size() { return last; }
    public void remove(String string) {
        for (int i = 0; i < size(); i++) {
            if (array[i].equals(string)) {
                String[] arrayCopy = new String[size];
                System.arraycopy(array, 0, arrayCopy, 0, i);
                System.arraycopy(array, i + 1, arrayCopy, i, last - i);
                array = arrayCopy;
                --last;
                return;
            }
        }
    }
    public int search(String string) {
        for (int i = 0; i < size(); i++)
            if (string.equals(array[i]))
                return i;
        return -1;
    }
    public void sort() {
        int min;
        for (int i = 0; i < size() - 1; i++) {
            min = i;
            for (int j = i + 1; j < size(); j++) {
                if (array[j].length() < array[min].length())
                    min = j;
            }
            String tmp = array[i];
            array[i] = array[min];
            array[min] = tmp;
        }
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[ ");
        for (int i = 0; i < size(); i++) {
            sb.append(array[i]);
            if (i != last - 1)
                sb.append(", ");
        }
        sb.append(" ]");
        return sb.toString();
    }
    public boolean contains(String string) {
        for (int i = 0; i < size(); i++)
            if (array[i].equals(string))
                return true;
        return false;
    }
    public boolean containsAll(Container container) {
        if (container.size() <= this.size()) {
            for (int i = 0; i < size(); i++)
                for (int j = 0; j < container.size(); j++)
                    if (!contains(container.toArray()[j]))
                        return false;
            return true;
        } else
            return false;
    }
    private int current = 0;
    public boolean hasNext() { return current < size(); }
    public String next() { return array[current++]; }
    public void remove() { remove(array[current]); }
    public void save(Object object){
        try {
            FileOutputStream fos = new FileOutputStream("data.bin");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(object);
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Container load(){
        Container list = new Container();
        try {
            FileInputStream fis = new FileInputStream("data.bin");
            ObjectInputStream ois = new ObjectInputStream(fis);
            list = (Container) ois.readObject();
            ois.close();

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("File not found!");
        }
        return list;
    }
}