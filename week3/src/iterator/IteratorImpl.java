package iterator;

class Constant {
    public static final int FORWARD = 0;
    public static final int REVERSE = 1;
}

abstract class Factory {
    public final Iterator create(Aggregate list, int type) {
        Iterator p = createProduct(list, type);
        return p;
    }

    protected abstract Iterator createProduct(Aggregate list, int type);
}

class IteratorFactory extends Factory {
    public static IteratorFactory iteratorFactory = new IteratorFactory();
    private IteratorFactory() {
    }
    public static IteratorFactory getInstance() {
        return iteratorFactory;
    }
    @Override
    protected Iterator createProduct(Aggregate list, int type) {
        if (type == Constant.FORWARD)
            return new BookShelfIterator(list);
        else
            return new BookShelfReverseIterator(list);
    }
}

interface Iterator {
    public abstract boolean hasNext();
    public abstract Object next();
}

interface Aggregate {
    public abstract Iterator iterator(int type);
    public int getLength();
}

class Book {
    private String name;
    public Book(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
}

class BookShelfReverseIterator implements Iterator {

    BookShelf aggregate;
    int idx;

    public BookShelfReverseIterator(Aggregate aggregate) {
        this.aggregate = (BookShelf) aggregate;
        this.idx = aggregate.getLength() - 1;
    }

    @Override
    public boolean hasNext() {
        return idx >= 0;
    }

    @Override
    public Object next() {
        return aggregate.arr[idx--];
    }
}


class BookShelfIterator implements Iterator {

    BookShelf aggregate;
    int idx;

    public BookShelfIterator(Aggregate aggregate) {
        this.aggregate = (BookShelf) aggregate;
        this.idx = 0;
    }

    @Override
    public boolean hasNext() {
        return aggregate.getLength() - idx > 0;
    }

    @Override
    public Object next() {
        return aggregate.arr[idx++];
    }
}

class BookShelf implements Aggregate {
    int size;
    public Book arr[];
    int cnt;
    Factory factory = IteratorFactory.getInstance();

    public BookShelf(int size) {
        this.size = size;
        this.arr = new Book[size];
        this.cnt = 0;
    }

    @Override
    public Iterator iterator(int type) {
        return factory.create(this, type);
    }

    @Override
    public int getLength() {
        return this.cnt;
    }

    public void appendBox(Book book) {
        if (this.cnt >= size)
            return ;
        arr[cnt] = book;
        this.cnt += 1;
    }
}

public class IteratorImpl {
    public static void main(String[] args) {
        BookShelf bookShelf = new BookShelf(3);
        bookShelf.appendBox(new Book("asd1"));
        bookShelf.appendBox(new Book("asd2"));
        bookShelf.appendBox(new Book("asd3"));
        Iterator iterator = bookShelf.iterator(Constant.FORWARD);
        while (iterator.hasNext()) {
            Book next = (Book) iterator.next();
            System.out.println("next.getName() = " + next.getName());
        }
    }
}
