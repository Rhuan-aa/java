package factory_method.logistica;

import factory_method.Transporte;

public abstract class Logistica {
    public void planejarEntrega() {
        Transporte transporte = criarTransporte();
        transporte.entregar();
    }
    protected abstract Transporte criarTransporte();
}
