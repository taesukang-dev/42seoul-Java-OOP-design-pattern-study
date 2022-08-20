package bridge;

import java.util.ArrayList;
import java.util.LinkedList;

interface AbstractList<T> {
    public void addElement(T obj);
    public T deleteElement(int i);
    public int insertElement(T obj, int i);
    public T getElement(int i);
    public int getElementSize();
}

class ArrayImpl<T> implements AbstractList<T> {
    ArrayList<T> store = new ArrayList<T>();
    @Override
    public void addElement(T obj) {
        store.add(obj);
    }

    @Override
    public T deleteElement(int i) {
        T t = store.get(i);
        store.remove(i);
        return t;
    }

    @Override
    public int insertElement(T obj, int i) {
        store.add(i, obj);
        return i;
    }

    @Override
    public T getElement(int i) {
        return store.get(i);
    }

    @Override
    public int getElementSize() {
        return store.size();
    }
}

class LinkedListImpl<T> implements AbstractList<T> {

    LinkedList<T> store = new LinkedList<>();

    @Override
    public void addElement(T obj) {
        store.add(obj);
    }

    @Override
    public T deleteElement(int i) {
        T t = store.get(i);
        store.remove(i);
        return t;
    }

    @Override
    public int insertElement(T obj, int i) {
        store.add(i, obj);
        return i;
    }

    @Override
    public T getElement(int i) {
        return store.get(i);
    }

    @Override
    public int getElementSize() {
        return store.size();
    }
}

class List<T>{
    AbstractList<T> impl;
    public List(AbstractList<T> list) {
        impl = list;
    }
    public  void add(T obj) {
        impl.addElement(obj);
    }
    public  T get(int i) {
        return impl.getElement(i);
    }
    public  T remove(int i) {
        return impl.deleteElement(i);
    }
    public  int getSize() {
        return impl.getElementSize();
    }
}

class Queue<T> extends List<T> {
    public Queue(AbstractList<T> list) {
        super(list);
        System.out.println("Queue를 구현합니다.");
    }
    public void enQueue(T obj) {
        impl.addElement(obj);
    }
    public T deQueue() {
        return impl.deleteElement(0);
    }
}

class Stack<T> extends List<T> {
    public Stack(AbstractList<T> list) {
        super(list);
        System.out.println("Stack을 구현합니다.");
    }

    public void push(T obj) {
        impl.addElement(obj);
    }

    public T pop() {
        return impl.deleteElement(impl.getElementSize() - 1);
    }
}

public class BridgeImpl {
    public static void main(String[] args) {
        Queue<String> arrayQueue = new Queue<String>(new ArrayImpl<String>());
        arrayQueue.enQueue("aaa");
        arrayQueue.enQueue("bbb");
        arrayQueue.enQueue("ccc");
        System.out.println(arrayQueue.deQueue());
        System.out.println(arrayQueue.deQueue());
        System.out.println(arrayQueue.deQueue());
        System.out.println("=========================");
        Queue<String> linkedQueue = new Queue<String>(new LinkedListImpl<String>());
        linkedQueue.enQueue("aaa");
        linkedQueue.enQueue("bbb");
        linkedQueue.enQueue("ccc");
        System.out.println(linkedQueue.deQueue());
        System.out.println(linkedQueue.deQueue());
        System.out.println(linkedQueue.deQueue());
        System.out.println("=========================");
        Stack<String> arrayStack = new Stack<String>(new ArrayImpl<String>());
        arrayStack.push("aaa");
        arrayStack.push("bbb");
        arrayStack.push("ccc");
        System.out.println(arrayStack.pop());
        System.out.println(arrayStack.pop());
        System.out.println(arrayStack.pop());
        System.out.println("=========================");
        Stack<String> linkedStack = new Stack<String>(new LinkedListImpl<String>());
        linkedStack.push("aaa");
        linkedStack.push("bbb");
        linkedStack.push("ccc");
        System.out.println(linkedStack.pop());
        System.out.println(linkedStack.pop());
        System.out.println(linkedStack.pop());
        System.out.println("=========================");
    }
}
