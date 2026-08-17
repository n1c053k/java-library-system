package Library;

public class Book {
    private final int id;
    private final String title;
    private final String author;
    private boolean available;
    private User borrowedBy;

    public Book(int id, String title, String author, boolean available) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.available = available;
        this.borrowedBy = null;
    }

    public boolean isBorrowedByAnyone(){
        return this.borrowedBy != null;
    }

    public User getBorrowedBy() {
        return this.borrowedBy;
    }

    public void setBorrowedBy(User user) {
        this.borrowedBy = user;
    }

    public int getId() {
        return this.id;
    }

    public String getTitle() {
        return this.title;
    }

    public String getAuthor() {
        return this.author;
    }

    public void setAvailable(boolean available){
        this.available = available;
    }

    public boolean isAvailable() {
        return this.available;
    }
}
