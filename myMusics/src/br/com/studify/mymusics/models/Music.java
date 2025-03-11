package br.com.studify.mymusics.models;

public class Music extends Audio{
    private String album;
    private String singer;
    private String genre;

    public Music(String title, String album, String singer, String genre) {
        super(title);
        this.album = album;
        this.singer = singer;
        this.genre = genre;
    }

    public String getAlbum() {
        return album;
    }

    public String getSinger() {
        return singer;
    }

    public String getGenre() {
        return genre;
    }

    @Override
    public int getClassification() {
        if (this.getTotalViews() > 2000) return 10;
        return 7;
    }
}
