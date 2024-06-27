package com.altheacruz.library.model;

public class Magazine extends Book {
    private int issueNo;
    private String seasonEdition;

    public Magazine(int refNo, String title, String author, String ISBN, int pubYear, String category, int issueNo, String monthlyEdition) {
        super(refNo, title, author, ISBN, pubYear, "Magazine");
        this.issueNo = issueNo;
        this.seasonEdition = monthlyEdition;
    }

    public int getIssueNo() {
        return issueNo;
    }

    public void setIssueNo(int issueNo) {
        this.issueNo = issueNo;
    }

    public String getSeasonEdition() {
        return seasonEdition;
    }

    public void setSeasonEdition(String seasonEdition) {
        this.seasonEdition = seasonEdition;
    }

    @Override
    public String toString() {
        return super.toString() + ", issueNo='" + issueNo + '\'' + ", monthlyEdition='" + seasonEdition + '\'' + '}';
    }
}
