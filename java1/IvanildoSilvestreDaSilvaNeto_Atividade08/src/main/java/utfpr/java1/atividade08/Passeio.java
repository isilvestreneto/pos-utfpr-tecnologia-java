package utfpr.java1.atividade08;

/**
 *
 * @author ivneto
 */
public final class Passeio extends Veiculo implements Calcular {

    private int qtdPassageiros;

    public Passeio() {
        super();
        this.qtdPassageiros = 0;
    }

    public Passeio(String placa, String marca, String modelo, String cor, float velocMax,
            int qtdRodas, int atrMotor1, int atrMotor2, int par4, int qtdPassageiros) {
        super(placa, marca, modelo, cor, velocMax, qtdRodas, atrMotor1, atrMotor2);
        this.qtdPassageiros = qtdPassageiros;
    }

    public int getQtdPassageiros() {
        return qtdPassageiros;
    }

    public final void setQtdPassageiros(int qtdPassageiros) {
        this.qtdPassageiros = qtdPassageiros;
    }

    @Override
    float calcVel(float velocMax) {
        return velocMax * 1000;
    }

    @Override
    public String toString() {
        return "=== Carro Passeio ===\n"
                + "Placa           : " + super.getPlaca() + "\n"
                + "Marca           : " + super.getMarca() + "\n"
                + "Modelo          : " + super.getModelo() + "\n"
                + "Cor             : " + super.getCor() + "\n"
                + "Velocidade max. : " + String.format("%.2f km/h", super.getVelocMax()) + "\n"
                + "Quantidade Rodas: " + super.getQtdRodas() + "\n"
                + "Motor:\n"
                + "  - Quantidade pistoes: " + super.getMotor().getQtdPist() + "\n"
                + "  - Potencia         : " + super.getMotor().getPotencia() + " CV\n"
                + "Quantidade passageiros: " + getQtdPassageiros();
    }

    @Override
    public int calcular() {
        int contagem = 0;
        int qtdCaracteresPlaca = this.getPlaca().length();
        int marca = this.getMarca().length();
        int modelo = this.getModelo().length();
        int cor = this.getCor().length();
        contagem = qtdCaracteresPlaca + marca + modelo + cor;
        return contagem;
    }
}
