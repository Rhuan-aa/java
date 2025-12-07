package factory_method;

public class Navio implements Transporte{
    @Override
    public void entregar() {
        System.out.println("Entregando de container pelo mar.");
    }
}
