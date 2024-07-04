package com.java_example;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public abstract class StandartLibraryInfo {

    protected final StringProperty title;
    protected final StringProperty author;
    protected final StringProperty isbn;
    protected final StringProperty typeOfLiterature;

    public StandartLibraryInfo(String title, String author, String isbn, String typeOfLiterature) {
        this.title = new SimpleStringProperty(title);
        this.author = new SimpleStringProperty(author);
        this.isbn = new SimpleStringProperty(isbn);
        this.typeOfLiterature = new SimpleStringProperty(typeOfLiterature);
    }

    public String getTitle() {
        return title.get();
    }

    public void setTitle(String title) {
        this.title.set(title);
    }

    public StringProperty titleProperty() {
        return title;
    }

    public String getAuthor() {
        return author.get();
    }

    public void setAuthor(String author) {
        this.author.set(author);
    }

    public StringProperty authorProperty() {
        return author;
    }

    public String getIsbn() {
        return isbn.get();
    }

    public void setIsbn(String isbn) {
        this.isbn.set(isbn);
    }

    public StringProperty isbnProperty() {
        return isbn;
    }

    public String getTypeOfLiterature() {
        return typeOfLiterature.get();
    }

    public StringProperty typeOfLiteratureProperty() {
        return typeOfLiterature;
    }
}
