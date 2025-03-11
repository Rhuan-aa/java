package br.com.studify.mymusics.models;

public class Audio {
    private String title;
    private int totalViews;
    private int totalLikes;
    private int classification;

    public Audio(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public int getTotalViews() {
        return totalViews;
    }

    public int getTotalLikes() {
        return totalLikes;
    }

    public int getClassification() {
        return classification;
    }

    public void like(){
        this.totalLikes++;
    }

    public void play(){
        this.totalViews++;
    }
}
