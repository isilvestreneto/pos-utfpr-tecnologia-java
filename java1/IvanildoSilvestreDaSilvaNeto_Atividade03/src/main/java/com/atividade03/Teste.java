/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.atividade03;

/**
 *
 * @author ivneto
 */
public class Teste {

    public static void main(String[] args) {
        Passeio carro1 = new Passeio("ABC-1234", "Fiat", "Uno", "Vermelho",
                160f, 4, new Motor(4, 75), 5);

        Passeio carro2 = new Passeio("DEF-5678", "Volkswagen", "Golf", "Prata",
                220f, 4, new Motor(4, 150), 5);

        Passeio carro3 = new Passeio("GHI-9101", "Honda", "Civic", "Preto",
                200f, 4, new Motor(4, 140), 5);

        Passeio carro4 = new Passeio("JKL-1123", "Toyota", "Corolla", "Branco",
                180f, 4, new Motor(4, 130), 5);

        Passeio carro5 = new Passeio("MNO-3456", "Chevrolet", "Onix", "Azul",
                170f, 4, new Motor(4, 116), 5);

        Carga carga1 = new Carga("ABC-9876", "Scania", "R450", "Branco",
                120f, 6, new Motor(6, 450), 20000, 8000);

        Carga carga2 = new Carga("DEF-5432", "Volvo", "FH16", "Prata",
                130f, 6, new Motor(6, 540), 25000, 9000);

        Carga carga3 = new Carga("GHI-3210", "Mercedes-Benz", "Actros", "Azul",
                110f, 8, new Motor(6, 476), 22000, 8500);

        Carga carga4 = new Carga("JKL-6543", "MAN", "TGX", "Vermelho",
                125f, 8, new Motor(6, 500), 24000, 9500);

        Carga carga5 = new Carga("MNO-1122", "Iveco", "Hi-Way", "Preto",
                115f, 6, new Motor(6, 480), 23000, 8200);

        System.out.println(carro1);
        System.out.println("");

        System.out.println(carro2);
        System.out.println("");

        System.out.println(carro3);
        System.out.println("");

        System.out.println(carro4);
        System.out.println("");

        System.out.println(carro5);
        System.out.println("");

        System.out.println(carga1);
        System.out.println("");

        System.out.println(carga2);
        System.out.println("");

        System.out.println(carga3);
        System.out.println("");

        System.out.println(carga4);
        System.out.println("");

        System.out.println(carga5);

    }
}
