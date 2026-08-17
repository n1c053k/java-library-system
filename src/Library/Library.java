package Library;

import java.util.HashMap;

public class Library {
    private final HashMap<Integer, Book> books;
    private final HashMap<Integer, User> users;
    private int totalBooks;
    private int totalUsers;

    public Library() {
        this.books = new HashMap<>();
        this.users = new HashMap<>();
        this.totalBooks = 0;
        this.totalUsers = 0;
    }

    public void registerBook(String title, String author) {
        Book book = new Book(this.totalBooks++, title, author, true);
        this.books.put(book.getId(), book);
        IO.println(String.format("Livro %s de: %s registrado com sucesso", title, author));
    }

    public void deleteBook(int id) {
        Book book = this.books.get(id);
        if (book == null) {
            return;
        }
        IO.println(String.format("Livro %s de: %s removido com sucesso", book.getTitle(), book.getAuthor()));
        this.books.remove(id);
    }

    public void printBooks() {
        if (this.books.isEmpty()) {
            IO.println("Books are empty.");
            return;
        }

        for (Book book : books.values()) {
            IO.println(String.format("[%d] %s, %s, %b, %s", book.getId(), book.getTitle(), book.getAuthor(), book.isAvailable(), book.isBorrowedByAnyone() ? book.getBorrowedBy().getName() : "free"));
        }
    }

    public void clearBooks() {
        this.books.clear();
        totalBooks = 0;
    }

    public void registerUser(String name) {
        User user = new User(this.totalUsers++, name);
        this.users.put(user.getId(), user);
        IO.println(String.format("Usuário %s registrado com sucesso", name));
    }

    public void borrowBook(int bookId, int userId) {
        Book book = this.books.get(bookId);
        if (book == null) {
            IO.println("Livro inválido");
            return;
        }

        if (book.isBorrowedByAnyone()) {
            IO.println("Livro já emprestado");
            return;
        }

        User user = this.users.get(userId);
        if (user == null) {
            IO.println("Usuário invalido");
            return;
        }

        book.setBorrowedBy(user);
        IO.println(String.format("Livro %s emprestado com sucesso para: %s", book.getTitle(), user.getName()));
    }

    public void returnBook(int bookId, int userId) {
        Book book = this.books.get(bookId);
        if (book == null) {
            IO.println("Livro inválido");
            return;
        }

        User user = this.users.get(userId);
        if (user == null) {
            IO.println("Usuário invalido");
            return;
        }

        User borrowedFrom = book.getBorrowedBy();
        if (borrowedFrom == null || borrowedFrom.getId() != userId) {
            IO.println("Usuário invalido");
            return;
        }

        book.setBorrowedBy(null);
        IO.println(String.format("Livro %s devolvido com sucesso de: %s", book.getTitle(), user.getName()));
    }
}
