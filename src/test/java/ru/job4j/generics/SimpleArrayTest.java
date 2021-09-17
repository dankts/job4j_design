package ru.job4j.generics;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SimpleArrayTest {

    @Test
    public void whenAdd() {
        SimpleArray<Integer> simpleArray = new SimpleArray<>(3);
        simpleArray.add(2);
        simpleArray.add(1);
        assertThat(simpleArray.getSize(), is(2));
        assertThat(simpleArray.get(0), is(2));
    }

    @Test
    public void whenAddAndSet() {
        SimpleArray<Boolean> simpleArray = new SimpleArray<>(3);
        simpleArray.add(false);
        simpleArray.add(false);
        simpleArray.add(false);
        simpleArray.set(2, true);
        assertTrue(simpleArray.get(2));
    }

    @Test
    public void whenAddAndRemove() {
        SimpleArray<Character> simpleArray = new SimpleArray<>(3);
        simpleArray.add('A');
        simpleArray.add('C');
        simpleArray.add('B');
        simpleArray.remove(1);
        assertThat(simpleArray.get(1), is('B'));
        assertThat(simpleArray.getSize(), is(2));
    }

    @Test
    public void whenAddAndGet() {
        SimpleArray<String> simpleArray = new SimpleArray<>(4);
        simpleArray.add("Hello");
        simpleArray.add("Java");
        assertThat(simpleArray.get(0), is("Hello"));
        assertThat(simpleArray.get(1), is("Java"));
        assertThat(simpleArray.getSize(), is(2));
    }

    @Test
    public void whenNext() {
        SimpleArray<String> simpleArray = new SimpleArray<>(4);
        simpleArray.add("Hello");
        simpleArray.add("Java");
        assertThat(simpleArray.iterator().hasNext(), is(true));
        assertThat(simpleArray.iterator().next(), is("Hello"));
        assertThat(simpleArray.iterator().hasNext(), is(true));
    }
}