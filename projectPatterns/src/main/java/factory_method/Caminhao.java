package factory_method;

public class Caminhao implements Transporte{
    @Override
    public void entregar() {
        System.out.println("Entregando de caixa por estradas.");
    }
}
