package ru.job4j.generics;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimpleArray<T> implements Iterable<T> {
    private final Object[] array;
    private int size = 0;

    public SimpleArray(int size) {
        array = new Object[size];
    }

    public void add(T model) {
        array[size] = model;
        size++;
    }

    public void set(int index, T model) {
        if (Objects.checkIndex(index, size) == index) {
            array[index] = model;
        }
    }

    public void remove(int index) {
        if (Objects.checkIndex(index, size) == index) {
            System.arraycopy(array, index + 1, array, index, array.length - index - 1);
            size--;
        }
    }

    public T get(int index) {
        T rsl = null;
        if (Objects.checkIndex(index, size) == index) {
            rsl = (T) array[index];
        }
        return rsl;
    }

    public int getSize() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int point = 0;
            @Override
            public boolean hasNext() {
                return point < size;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return (T) array[point++];
            }
        };
    }
}
