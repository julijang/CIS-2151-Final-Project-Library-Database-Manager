package librarymanagement;

public class Book {
    private String title;
    private String author;
    private String ISBN;
    private String publicationDate;
    public Boolean checkedOut;

    public Book(String title, String author, String ISBN, String publicationDate) {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.publicationDate = publicationDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(String publicationDate) {
        this.publicationDate = publicationDate;
    }

    public Boolean getCheckedOut() {
        return checkedOut;
    }

    public void setCheckedOut(Boolean checkedOut) {
        this.checkedOut = checkedOut;
    }

    @Override
    public String toString() {
        return "Book{" + "title=" + title + ", author=" + author + ", ISBN=" + ISBN + ", publicationDate=" + publicationDate + '}';
    }
}
