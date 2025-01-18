package utfpr.java1.atividade08;

public final class Carga extends Veiculo implements Calcular {

    private int cargaMax;
    private int tara;

    public Carga() {
        super();
        this.cargaMax = 0;
        this.tara = 0;
    }

    public Carga(String placa, String marca, String modelo, String cor,
            float velocMax, int qtdRodas, int qtdPist, int potencia, int cargaMax, int tara) throws VelocException {
        super();
        this.setPlaca(placa);
        this.setMarca(marca);
        this.setModelo(modelo);
        this.setCor(cor);
        try {
            this.setVelocMax(velocMax);
        } catch (VelocException ex) {
            System.err.println("Velocidade Máxima inválida: " + ex.getMessage() + ". Valor padrão atribuído: 90.");
            this.setVelocMax(90);
        } finally {
            this.setQtdRodas(qtdRodas);
            this.setMotor(qtdPist, potencia);
            this.cargaMax = cargaMax;
            this.tara = tara;
        }
    }

    public int getCargaMax() {
        return cargaMax;
    }

    public final void setCargaMax(int cargaMax) {
        this.cargaMax = cargaMax;
    }

    public int getTara() {
        return tara;
    }

    public final void setTara(int tara) {
        this.tara = tara;
    }

    @Override
    float calcVel(float velocMax) {
        return velocMax * 100000;
    }

    @Override
    public String toString() {
        return "=== Carro Carga ===\n"
                + "Placa           : " + super.getPlaca() + "\n"
                + "Marca           : " + super.getMarca() + "\n"
                + "Modelo          : " + super.getModelo() + "\n"
                + "Cor             : " + super.getCor() + "\n"
                + "Velocidade max. : " + String.format("%.2f km/h", super.getVelocMax()) + "\n"
                + "Quantidade Rodas: " + super.getQtdRodas() + "\n"
                + "Motor:\n"
                + "  - Quantidade pistoes: " + super.getMotor().getQtdPist() + "\n"
                + "  - Potencia         : " + super.getMotor().getPotencia() + " CV\n"
                + "Carga maxima     : " + cargaMax + " kg\n"
                + "Tara             : " + tara + " kg";
    }

    @Override
    public int calcular() {
        int contagem = 0;

        float velocMax = this.getVelocMax();
        int qtdRodas = this.getQtdRodas();
        int qtdPist = this.getQtdPist();
        int potencia = this.getPotencia();
        int cargaMax = this.getCargaMax();
        int tara = this.getTara();

        contagem = (int) (velocMax + qtdRodas + qtdPist + potencia + cargaMax + tara);

        return contagem;
    }
}
