package com.atividade01;

public class Teste {

    public static void main(String[] args) {
        Veiculo moto = new Veiculo();
        moto.setPlaca("ABC1D23");
        moto.setMarca("Honda");
        moto.setModelo("CB500F");
        moto.setCor("Vermelho");
        moto.setVelocMax(180.0f);
        moto.setQtdRodas(2);
        moto.setMotor(new Motor(2, 50));

        Veiculo triciclo = new Veiculo();
        triciclo.setPlaca("XYZ9W87");
        triciclo.setMarca("Can-Am");
        triciclo.setModelo("Spyder");
        triciclo.setCor("Preto");
        triciclo.setVelocMax(160.0f);
        triciclo.setQtdRodas(3);
        triciclo.setMotor(new Motor(3, 115));

        Veiculo quadriciclo = new Veiculo();
        quadriciclo.setPlaca("JKL3M56");
        quadriciclo.setMarca("Polaris");
        quadriciclo.setModelo("Sportsman");
        quadriciclo.setCor("Verde");
        quadriciclo.setVelocMax(120.0f);
        quadriciclo.setQtdRodas(4);
        quadriciclo.setMotor(new Motor(4, 90));

        Veiculo carro = new Veiculo();
        carro.setPlaca("QWE4R89");
        carro.setMarca("Toyota");
        carro.setModelo("Corolla");
        carro.setCor("Branco");
        carro.setVelocMax(210.0f);
        carro.setQtdRodas(4);
        carro.setMotor(new Motor(4, 140));

        Veiculo caminhao = new Veiculo();
        caminhao.setPlaca("RTY5U12");
        caminhao.setMarca("Volvo");
        caminhao.setModelo("FH16");
        caminhao.setCor("Azul");
        caminhao.setVelocMax(120.0f);
        caminhao.setQtdRodas(18);
        caminhao.setMotor(new Motor(6, 750));
        
        System.out.println("# Moto");
        System.out.println(moto);
        
        System.out.println("# Triciclo");
        System.out.println(triciclo);
        
        System.out.println("# Quadriciclo");
        System.out.println(quadriciclo);
        
        System.out.println("# Carro");
        System.out.println(carro);
        
        System.out.println("# Caminhao");
        System.out.println(caminhao);

    }

}
