package org.atividade04;

abstract class Veiculo {

    private String placa;
    private String marca;
    private String modelo;
    private String cor;
    private float velocMax;
    private int qtdRodas;
    private Motor motor;

    public Veiculo() {
        this.placa = " ";
        this.marca = " ";
        this.modelo = " ";
        this.cor = " ";
        this.velocMax = 0f;
        this.qtdRodas = 0;
        this.motor = new Motor();
    }
    
    abstract float calcVel(float velocMax);

    public String getPlaca() {
        return placa;
    }

    public final void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public final void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public final void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getCor() {
        return cor;
    }

    public final void setCor(String cor) {
        this.cor = cor;
    }

    public float getVelocMax() {
        return velocMax;
    }

    public final void setVelocMax(float velocMax) {
        this.velocMax = velocMax;
    }

    public int getQtdRodas() {
        return qtdRodas;
    }

    public final void setQtdRodas(int qtdRodas) {
        this.qtdRodas = qtdRodas;
    }

    public Motor getMotor() {
        return motor;
    }

    public int getQtdPist() {
        return getMotor().getQtdPist();
    }

    public int getPotencia() {
        return getMotor().getPotencia();
    }

    public final void setMotor(int qtdPist, int potencia) {
        Motor motor = new Motor();
        motor.setQtdPist(qtdPist);
        motor.setPotencia(potencia);
        this.motor = motor;
    }

    @Override
    public String toString() {
        return "Veiculo{" + "placa=" + placa + ", marca=" + marca + ", modelo=" + modelo + ", cor=" + cor + ", velocMax=" + velocMax + ", qtdRodas=" + qtdRodas + ", motor=" + motor + '}';
    }

}
