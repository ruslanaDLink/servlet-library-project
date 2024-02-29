package crudservlet;

import crudservlet.model.Author;
import crudservlet.model.Book;

import java.security.InvalidParameterException;
import java.util.HashMap;
import java.util.Map;

public class Library {
    private Map<Author, Book> map;

    public Library() {
        map = new HashMap<>();
    }

    public Book assignBook(Author author, Book book) {
        return map.putIfAbsent(author, book);
    }

    public Book retrieveData(String bookName) {
        Book book;
        for (Map.Entry<Author, Book> entry : map.entrySet()) {
            book = entry.getValue();
            if (book.getBookName().equalsIgnoreCase(bookName)) {
                return book;
            }
        }
        throw new InvalidParameterException("Invalid name. Book not found '" + bookName + "'.");
    }

    public Book updatePrice(Book book, double price) {
        book.setPrice(price);
        return book;
    }

    public void reassignBook(Author author, Book book) {
        map.remove(author, book);
        System.out.println("Book reassign from library " + book.getBookName() + " " + book.getIsbn() + ".");
    }

    public Map<Author, Book> getMap() {
        return map;
    }

    public boolean isExist(String name) {
        return getMap().entrySet()
                .stream()
                .anyMatch(x -> x.getValue().getBookName().equalsIgnoreCase(name));
    }
}
