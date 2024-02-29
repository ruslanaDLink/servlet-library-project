package crudservlet;

import crudservlet.model.Author;
import crudservlet.model.Book;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.Map;

@WebServlet(name = "bookServlet", urlPatterns = "/bookServlet")
public class BookServlet extends HttpServlet {
    private Library library;

    @Override
    public void init() throws ServletException {
        super.init();
        library = new LibraryStorage().getLibrary();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter writer = response.getWriter();
        writer.println("Welcome to the Library!");
        writer.println("(Accession Time: " + LocalDateTime.now() + ")");

        if (library.getMap().isEmpty()) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }
        writer.println("____________________________________________________________________________________");
        writer.println("\n       AUTHOR\t                                           BOOK\t");
        for (Map.Entry<Author, Book> entry : library.getMap().entrySet()) {
            writer.println("\n" + entry.getKey() + " " + entry.getValue());
            writer.flush();
        }
        response.setStatus(HttpServletResponse.SC_OK);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        Book book = library.retrieveData(name);
        library.assignBook(book.getAuthor(), book);
        response.setStatus(HttpServletResponse.SC_CREATED);
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        Book book = library.retrieveData(name);
        double currentPrice = book.getPrice();
        Book updatedBook = library.updatePrice(book, currentPrice - 5.0);
        if (currentPrice == updatedBook.getPrice()) {
            response.sendError(HttpServletResponse.SC_EXPECTATION_FAILED, "Incapable to update price.");
        }
        response.setHeader("PRICE", "updated");
        response.setStatus(HttpServletResponse.SC_OK);
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        Book book = library.retrieveData(name);
        Author author = book.getAuthor();
        library.reassignBook(author, book);
        response.setStatus(HttpServletResponse.SC_NO_CONTENT);
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.service(req, resp);
    }
}
