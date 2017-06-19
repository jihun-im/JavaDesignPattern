package Iterator.IteratorSimpleExample;

import com.sun.xml.internal.fastinfoset.stax.events.ReadIterator;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by jihun.im on 2017-04-28.
 */
public class IteratorSimpleMain {
    public static void main(String[] args) {
        ArrayList<Book> bookList = new ArrayList<>();
        bookList.add(new Book("Wind",1,"good"));
        bookList.add(new Book("Sand",2,"good2"));


        Iterator<Book> it = bookList.iterator();

        while(it.hasNext()) {
            System.out.println(it.next());
        }

    }
}
