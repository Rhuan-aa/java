package br.com.studify.mymusics.models;

public class Podcast extends Audio {
    private String host;
    private String preview;

    public Podcast(String title, String host, String preview) {
        super(title);
        this.host = host;
        this.preview = preview;
    }

    public String getHost() {
        return host;
    }

    public String getPreview() {
        return preview;
    }

    @Override
    public int getClassification() {
        if (getTotalLikes() > 500) return 10;
        return 8;
    }
}
