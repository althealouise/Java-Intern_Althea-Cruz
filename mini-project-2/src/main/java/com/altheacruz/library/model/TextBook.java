package com.altheacruz.library.model;

public class TextBook extends Book {
    private String subject;
    private String academicLevel;

    public TextBook(int refNo, String title, String author, String ISBN, int pubYear, String category, String subject, String academicLevel) {
        super(refNo, title, author, ISBN, pubYear, "Textbook");
        this.subject = subject;
        this.academicLevel = academicLevel;
    }

    public String getAcademicLevel() {
        return academicLevel;
    }

    public void setAcademicLevel(String academicLevel) {
        this.academicLevel = academicLevel;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Override
    public String toString() {
        return super.toString() + ", subject='" + subject + '\'' + ", academicLevel='" + academicLevel + '\'' + '}';
    }
}
