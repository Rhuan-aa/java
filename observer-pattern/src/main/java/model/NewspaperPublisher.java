package model;

import interfaces.Publisher;
import interfaces.Subscriber;

import java.util.ArrayList;
import java.util.List;

public class NewspaperPublisher implements Publisher {
    private final List<Subscriber> subscribers = new ArrayList<>();
    private final String newspaperName;
    private String lastEdition;

    public NewspaperPublisher(String newspaperName) {
        this.newspaperName = newspaperName;
    }

    public void publishNewEdition(String edition) {
        lastEdition = edition;
        System.out.println("\n--- Jornal " + newspaperName + " publicando nova edição: " + edition + " ---");
        notifySubscribers();
    }

    @Override
    public void addSubscriber(Subscriber subscriber) {
        subscribers.add(subscriber);
        System.out.println("Novo assinante registrado");
    }

    @Override
    public void removeSubscriber(Subscriber subscriber) {
        subscribers.remove(subscriber);
        System.out.println("Assinatura cancelada");
    }

    @Override
    public void notifySubscribers() {
        subscribers.forEach(subscriber -> subscriber.receiveNews(lastEdition));
    }
}
