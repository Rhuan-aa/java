import interfaces.Publisher;
import interfaces.Subscriber;
import model.Enterprise;
import model.NewspaperPublisher;
import model.Person;

public class Main {
    public static void main(String[] args) {
        NewspaperPublisher folhaDeSaoPaulo = new NewspaperPublisher("Folha de São Paulo");

        Subscriber joao = new Person("João Silva");
        Subscriber maria = new Person("Maria Souza");
        Subscriber techCorp = new Enterprise("Tech Corp");

        folhaDeSaoPaulo.addSubscriber(joao);
        folhaDeSaoPaulo.addSubscriber(techCorp);

        folhaDeSaoPaulo.publishNewEdition("Trump ta louco por taxas!");

        folhaDeSaoPaulo.addSubscriber(maria);
        folhaDeSaoPaulo.removeSubscriber(techCorp);

        folhaDeSaoPaulo.publishNewEdition("Novidades de Esporte");
    }
}
