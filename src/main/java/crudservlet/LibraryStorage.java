package crudservlet;

import crudservlet.model.Author;
import crudservlet.model.Book;

public class LibraryStorage {
    private Library library;

    public LibraryStorage() {
        library = new Library();
        library.assignBook(new Author("Agatha Christie"), new Book("And Then There Were None", 29.58, "978-0062073488"));
        library.assignBook(new Author("Cao Xueqin"), new Book("Dream of the Red Chamber", 34.80, "978-0804840965"));
        library.assignBook(new Author("J. R. R. Tolkien"), new Book("The Hobbit", 15.99, "978-0804877965"));
        library.assignBook(new Author("J.K.Rowling"), new Book("Harry Potter and the Philosopher's Stone", 42.99, "978-0804840968"));
        library.assignBook(new Author("Antoine de Saint-Exupéry"), new Book("The Little Prince", 23.56, "978-0804840964"));
        library.assignBook(new Author("J. D. Salinger"), new Book("The Catcher in the Rye", 19.99, "978-0804840917"));
        library.assignBook(new Author("Anna Sewell"), new Book("Black Beauty", 28.79, "998-0804840999"));
        library.assignBook(new Author("Jack Higgins"), new Book("The Eagle Has Landed", 40.00, "978-0807648475"));
        library.assignBook(new Author("J. P. Donleavy"), new Book("The Ginger Man", 55.60, "945-0804848888"));
        library.assignBook(new Author("Harper Lee"), new Book("To Kill a Mockingbird", 49.99, "968-0804840970"));
        library.assignBook(new Author("R. L. Stine"), new Book("Goosebumps", 30.00, "997-0062073488"));
        library.assignBook(new Author("Various authors"), new Book("Choose Your Own Adventure", 34.80, "908-0800840965"));
        library.assignBook(new Author("Francine Pascal and ghostwriters"), new Book("Sweet Valley High", 15.99, " "));
        library.assignBook(new Author("Stephenie Meyer"), new Book("Twilight", 27.60, "956-0804840968"));
        library.assignBook(new Author("E.L.James"), new Book("Fifty Shades", 23.50, "978-0004840964"));
        library.assignBook(new Author("Suzanne Collins"), new Book("The Hunger Games", 57.99, "978-0804840917"));
        library.assignBook(new Author("George R. R. Martin"), new Book("A Song of Ice and Fire", 13.50, "998-0804849119"));
        library.assignBook(new Author("A. A. Milne"), new Book("Winnie-the-Pooh", 18.00, "978-0804848475"));
        library.assignBook(new Author("Laura Ingalls Wilder"), new Book("Little House on the Prairie", 25.50, "971-0804498888"));
        library.assignBook(new Author("Laura Lee Hope"), new Book("The Bobbsey Twins", 39.99, "968-0807840970"));
    }

    public Library getLibrary() {
        return library;
    }
}
