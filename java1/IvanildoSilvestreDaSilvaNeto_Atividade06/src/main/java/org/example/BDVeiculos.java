package org.example;

public class BDVeiculos {
    private Passeio[] listaPasseio = new Passeio[5];
    private Carga[] listaCarga = new Carga[5];

    public BDVeiculos() { }

    public Passeio[] getListaPasseio() {
        return listaPasseio;
    }

    public void setListaPasseio(Passeio[] listaPasseio) {
        this.listaPasseio = listaPasseio;
    }

    public Carga[] getListaCarga() {
        return listaCarga;
    }

    public void setListaCarga(Carga[] listaCarga) {
        this.listaCarga = listaCarga;
    }
}
