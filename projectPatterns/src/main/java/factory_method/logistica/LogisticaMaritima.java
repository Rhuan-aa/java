package factory_method.logistica;

import factory_method.Navio;
import factory_method.Transporte;

public class LogisticaMaritima extends Logistica {
    @Override
    protected Transporte criarTransporte() {
        return new Navio();
    }
}
