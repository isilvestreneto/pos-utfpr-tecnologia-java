/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package atividade04;

/**
 *
 * @author ivneto
 */
public final class Passeio extends Veiculo implements Calcular {

    private int qtdPassageiros;

    public Passeio() {
        this.qtdPassageiros = 0;
    }

    public Passeio(String placa, String marca, String modelo, String cor,
            float velocMax, int qtdRodas, int qtdPist, int potencia, int qtdPassageiros) {
        super();
        this.setPlaca(placa);
        this.setMarca(marca);
        this.setModelo(modelo);
        this.setCor(cor);
        this.setVelocMax(velocMax);
        this.setQtdRodas(qtdRodas);
        this.setMotor(qtdPist, potencia);
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
