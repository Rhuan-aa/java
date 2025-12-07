package factory_method.logistica;

import factory_method.Caminhao;
import factory_method.Transporte;

public class LogisticaTerrestre extends Logistica{
    @Override
    protected Transporte criarTransporte() {
        return new Caminhao();
    }
}
