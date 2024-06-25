package com.altheacruz.library.model;

public class NonFictionBook extends Book {
    private String subject;

    public NonFictionBook(int refNo, String title, String author, String ISBN, int pubYear, String subject) {
        super(refNo, title, author, ISBN, pubYear);
        this.subject = subject;
    }

    public String getSubject() {
        return subject;
    }

    @Override
    public String toString() {
        return super.toString() + ", Subject='" + subject + '\'' + '}';
    }
}
