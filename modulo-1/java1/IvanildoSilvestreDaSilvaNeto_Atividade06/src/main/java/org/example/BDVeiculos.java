package org.example;

import java.util.Arrays;

public class BDVeiculos {
    private Passeio[] listaPasseio = new Passeio[5];
    private Carga[] listaCarga = new Carga[5];

    public BDVeiculos() {
    }

    public Passeio[] getListaPasseio() {
        return listaPasseio;
    }

    public Carga[] getListaCarga() {
        return listaCarga;
    }

    public void pushPasseio(Passeio passeio) {
            Arrays.asList(this.listaPasseio).add(passeio);
    }

    public void pushCarga(Carga carga) {
            Arrays.asList(this.listaCarga).add(carga);
    }

    public boolean isPasseioPresent(String placa) {
        return Arrays.stream(getListaPasseio()).anyMatch(veiculo -> veiculo != null && veiculo.getPlaca().equalsIgnoreCase(placa));
    }

    public boolean isCargaPresent(String placa) {
        return Arrays.stream(getListaCarga()).anyMatch(veiculo -> veiculo != null && veiculo.getPlaca().equalsIgnoreCase(placa));
    }
}
