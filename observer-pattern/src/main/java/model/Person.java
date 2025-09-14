package model;

import interfaces.Subscriber;

public class Person implements Subscriber {
    private String name;

    public Person(String name) {
        this.name = name;
    }

    @Override
    public void receiveNews(String edition) {
        System.out.println("Olá, " + name + "! A nova edição do jornal ('" + edition + "') acabou de sair!");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
