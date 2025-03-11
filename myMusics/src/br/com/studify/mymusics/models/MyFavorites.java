package br.com.studify.mymusics.models;

public class MyFavorites {

    public void include(Audio audio){
        if (audio.getClassification() >= 8){
            System.out.println(audio.getTitle() + " é considero sucesso! e preferido por todos!");
        } else {
            System.out.println(audio.getTitle() + " também é um dos que todo mundo está curtindo");
        }
    }
}
