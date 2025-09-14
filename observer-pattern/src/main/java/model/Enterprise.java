package model;

import interfaces.Subscriber;

public class Enterprise implements Subscriber {
    private String corporateName;

    public Enterprise(String corporateName) {
        this.corporateName = corporateName;
    }

    @Override
    public void receiveNews(String edition) {
        System.out.println("Atenção, " + corporateName + ". O jornal com a edição '" + edition
                + "' foi entregue na recepção.");
    }

    public String getCorporateName() {
        return corporateName;
    }

    public void setCorporateName(String corporateName) {
        this.corporateName = corporateName;
    }
}
