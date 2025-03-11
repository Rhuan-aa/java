package br.com.studify.mymusics.main;

import br.com.studify.mymusics.models.Music;
import br.com.studify.mymusics.models.MyFavorites;
import br.com.studify.mymusics.models.Podcast;

public class Main {
    public static void main(String[] args) {
        Music forever = new Music("Forever", "Hot in the Shade", "Kiss", "Rock");

        for (int i = 0; i < 1000; i++) {
            forever.play();
        }

        for (int i = 0; i < 50; i++) {
            forever.like();
        }

        Podcast nerdCast = new Podcast("NerdCast", "Jovem Nerd", "O podcast de hoje será sobre um sistema de RPG novo!");

        for (int i = 0; i < 5000; i++) {
            nerdCast.play();
        }

        for (int i = 0; i < 1000; i++) {
            nerdCast.like();
        }

        MyFavorites myFavorites = new MyFavorites();
        myFavorites.include(forever);
        myFavorites.include(nerdCast);

    }
}