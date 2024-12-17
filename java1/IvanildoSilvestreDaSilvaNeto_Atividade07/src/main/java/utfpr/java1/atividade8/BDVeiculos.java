package utfpr.java1.atividade8;

import java.util.ArrayList;
import java.util.List;

public class BDVeiculos {

    static final private List<Passeio> listaPasseio = new ArrayList<>();
    static final private List<Carga> listaCarga = new ArrayList<>();

    public BDVeiculos() {
    }

    static public List<Passeio> getListaPasseio() {
        return listaPasseio;
    }

    static public List<Carga> getListaCarga() {
        return listaCarga;
    }

    static public void pushPasseio(Passeio passeio) {
        listaPasseio.add(passeio);
    }

    static public void pushCarga(Carga carga) {
        listaCarga.add(carga);
    }

    public boolean isPasseioPresent(String placa) {
        return listaPasseio.stream().anyMatch(passeio -> passeio.getPlaca().equals(placa));
    }

    public boolean isCargaPresent(String placa) {
        return listaCarga.stream().anyMatch(carga -> carga.getPlaca().equals(placa));
    }

    void deletePasseioByPlaca(String placa) {
        boolean removido = this.listaPasseio.removeIf(passeio -> passeio.getPlaca().equals(placa));
        if (!removido) {
            System.out.printf("Veiculo de placa %s nao encontrado\n", placa);
        } else {
            System.out.println("Veiculo removido com sucesso");
        }
    }

    void deleteCargaByPlaca(String placa) {
        boolean removido = this.listaCarga.removeIf(passeio -> passeio.getPlaca().equals(placa));
        if (!removido) {
            System.out.printf("Veiculo de placa %s nao encontrado\n", placa);
        } else {
            System.out.println("Veiculo removido com sucesso");
        }
    }

    static void clearPasseios() {
        listaPasseio.clear();
    }

    static void clearCargas() {
        listaCarga.clear();
    }
}
