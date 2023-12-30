package org.example;

public class Book {
    private final String title;
    private final String author;
    private final String publishedYear;

    public Book(String title, String author, String publishedYear) {
        this.title = title;
        this.author = author;
        this.publishedYear = publishedYear;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublishedYear() {
        return publishedYear;
    }

    public String toString (){
        return String.format("\"" + title + "\" Автор: " + author + "Год издания: " + publishedYear);
    }
}
