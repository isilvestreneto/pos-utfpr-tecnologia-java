/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package atividade04;

/**
 *
 * @author ivneto
 */
import java.util.Arrays;
import java.util.Scanner;

public class Menu {

    final private Passeio[] veiculosPasseio;
    final private Carga[] veiculosCarga;
    final private Leitura leitura;

    public Menu() {
        veiculosPasseio = new Passeio[5];
        veiculosCarga = new Carga[5];
        leitura = new Leitura();
    }

    public void exibirMenu() {
        System.out.println("Sistema de Gestao de Veiculos - Menu Inicial");
        System.out.println("1. Cadastrar Veiculo de Passeio");
        System.out.println("2. Cadastrar Veiculo de Carga");
        System.out.println("3. Imprimir Todos os Veiculos de Passeio");
        System.out.println("4. Imprimir Todos os Veiculos de Carga");
        System.out.println("5. Imprimir Veiculo de Passeio pela Placa");
        System.out.println("6. Imprimir Veiculo de Carga pela Placa");
        System.out.println("7. Sair do Sistema");
    }

    public void controlarMenu() {
        Scanner scanner = new Scanner(System.in);
        int opcao;
        do {
            exibirMenu();
            opcao = Integer.parseInt(leitura.entDados(scanner.nextLine()));

            switch (opcao) {
                case 1 ->
                    cadastrarVeiculoPasseio();
                case 2 ->
                    cadastrarVeiculoCarga();
                case 3 ->
                    imprimirTodosVeiculosPasseio();
                case 4 ->
                    imprimirTodosVeiculosCarga();
                case 5 ->
                    imprimirVeiculoPasseioPorPlaca();
                case 6 ->
                    imprimirVeiculoCargaPorPlaca();
                case 7 ->
                    System.out.println("Saindo do sistema...");
                default ->
                    System.out.println("Opcao invalida. Tente novamente.");
            }
        } while (opcao != 7);
        scanner.close();
    }

    private void cadastrarVeiculoPasseio() {
        Scanner scanner = new Scanner(System.in);
        String resposta = "SIM";
        do {
            System.out.println("Cadastro de Veiculo de Passeio");
            System.out.print("Placa: ");
            String placa = leitura.entDados(scanner.nextLine());

            if (verificarSeHaPlacaCadastrada(placa)) {
                System.out.println("Placa ja cadastrada. Tente novamente.");
                System.out.println("============================================");
                System.out.println();
                return;
            }

            System.out.print("Marca: ");
            String marca = leitura.entDados(scanner.nextLine());
            System.out.print("Modelo: ");
            String modelo = leitura.entDados(scanner.nextLine());
            System.out.print("Cor: ");
            String cor = leitura.entDados(scanner.nextLine());
            System.out.print("Velocidade Maxima: ");
            float velocMax = Float.parseFloat(leitura.entDados(scanner.nextLine()));
            System.out.print("Quantidade de Rodas: ");
            int qtdRodas = Integer.parseInt(leitura.entDados(scanner.nextLine()));
            System.out.print("Quantidade de Pistoes do motor: ");
            int qtdPist = Integer.parseInt(leitura.entDados(scanner.nextLine()));
            System.out.print("Potencia do motor: ");
            int potencia = Integer.parseInt(leitura.entDados(scanner.nextLine()));
            System.out.print("Quantidade de Passageiros: ");
            int qtdPassageiros = Integer.parseInt(leitura.entDados(scanner.nextLine()));

            Passeio passeio = new Passeio(placa, marca, modelo, cor, velocMax, qtdRodas, qtdPist, potencia, qtdPassageiros);

            int posicao = encontrarPosicaoLivre(veiculosPasseio);
            if (posicao != -1) {
                veiculosPasseio[posicao] = passeio;
                System.out.println("Veiculo de passeio cadastrado com sucesso!");
            } else {
                System.out.println("Nao ha espaco disponivel para cadastrar mais veiculos de passeio.");
                continue;
            }

            System.out.println("Veiculo de passeio cadastrado com sucesso!");
            System.out.println("Deseja cadastrar outro veiculo de passeio? (SIM/NAO)");
            resposta = leitura.entDados(scanner.nextLine()).toUpperCase();
        } while (resposta.equals("SIM"));
    }

    private boolean verificarSeHaPlacaCadastrada(String placa) {
        return (Arrays.stream(veiculosPasseio).anyMatch(veiculo -> veiculo != null && veiculo.getPlaca().equalsIgnoreCase(placa)))
                || (Arrays.stream(veiculosCarga).anyMatch(veiculo -> veiculo != null && veiculo.getPlaca().equalsIgnoreCase(placa)));
    }

    private void cadastrarVeiculoCarga() {
        Scanner scanner = new Scanner(System.in);
        String resposta = "SIM";

        do {
            System.out.println("Cadastro de Veiculo de Carga");
            System.out.print("Placa: ");
            String placa = leitura.entDados(scanner.nextLine());

            if (verificarSeHaPlacaCadastrada(placa)) {
                System.out.println("Placa ja cadastrada. Tente novamente.");
                System.out.println("============================================");
                System.out.println();
                return;
            }

            System.out.print("Marca: ");
            String marca = leitura.entDados(scanner.nextLine());
            System.out.print("Modelo: ");
            String modelo = leitura.entDados(scanner.nextLine());
            System.out.print("Cor: ");
            String cor = leitura.entDados(scanner.nextLine());
            System.out.print("Velocidade Maxima: ");
            float velocMax = Float.parseFloat(leitura.entDados(scanner.nextLine()));
            System.out.print("Quantidade de Rodas: ");
            int qtdRodas = Integer.parseInt(leitura.entDados(scanner.nextLine()));
            System.out.print("Quantidade de Pistoes do motor: ");
            int qtdPist = Integer.parseInt(leitura.entDados(scanner.nextLine()));
            System.out.print("Potencia do motor: ");
            int potencia = Integer.parseInt(leitura.entDados(scanner.nextLine()));
            System.out.print("Carga maxima: ");
            int cargaMax = Integer.parseInt(leitura.entDados(scanner.nextLine()));
            System.out.print("Tara: ");
            int tara = Integer.parseInt(leitura.entDados(scanner.nextLine()));

            Carga carga = new Carga(placa, marca, modelo, cor, velocMax, qtdRodas, qtdPist, potencia, cargaMax, tara);

            int posicao = encontrarPosicaoLivre(veiculosCarga);
            if (posicao != -1) {
                veiculosCarga[posicao] = carga;
                System.out.println("Veiculo de passeio cadastrado com sucesso!");
            } else {
                System.out.println("Não ha espaco disponivel para cadastrar mais veiculos de passeio.");
            }

            System.out.println("Deseja cadastrar outro veiculo de carga? (SIM/NAO)");
            resposta = leitura.entDados(scanner.nextLine()).toUpperCase();
        } while (resposta.equals("SIM"));
    }

    private void imprimirTodosVeiculosPasseio() {
        if (isArrayEmpty(veiculosPasseio)) {
            System.out.println("Nenhum veiculo de passeio cadastrado.");
            System.out.println("Cadastre um veiculo de passeio para visualizar.");
            System.out.println("============================================");
            System.out.println();
            return;
        }

        System.out.println("=== Veiculos de Passeio ===");

        for (Passeio passeio : veiculosPasseio) {
            if (passeio != null) {
                System.out.println(passeio);
                System.out.println("--------------------------------------------");
                System.out.println();
            }
        }

        System.out.println("============================================");
        System.out.println();
    }

    private void imprimirTodosVeiculosCarga() {
        if (isArrayEmpty(veiculosCarga)) {
            System.out.println("Nenhum veiculo de carga cadastrado.");
            System.out.println("Cadastre um veiculo de carga para visualizar.");
            System.out.println("============================================");
            System.out.println();
            return;
        }

        System.out.println("=== Veiculos de Carga ===");
        for (Carga carga : veiculosCarga) {
            if (carga != null) {
                System.out.println(carga);
                System.out.println("--------------------------------------------");
                System.out.println();
            }
        }

        System.out.println("============================================");
        System.out.println();
    }

    private void imprimirVeiculoPasseioPorPlaca() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite a placa do veiculo de passeio: ");
        String placa = leitura.entDados(scanner.nextLine());
        for (Passeio passeio : veiculosPasseio) {
            if (passeio != null && passeio.getPlaca().equalsIgnoreCase(placa)) {
                System.out.println(passeio);
                System.out.println("Calculo velocidade maxima: " + passeio.calcVel(passeio.getVelocMax()) + " m/h");
                System.out.println("Quantidade de caracteres: " + passeio.calcular());
                System.out.println("============================================");
                System.out.println();
                return;
            }
        }
        System.out.println("Veiculo de passeio nao encontrado.");
        System.out.println("============================================");
        System.out.println();
    }

    private void imprimirVeiculoCargaPorPlaca() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite a placa do veiculo de passeio: ");
        String placa = leitura.entDados(scanner.nextLine());
        for (Carga carga : veiculosCarga) {
            if (carga!= null && carga.getPlaca().equalsIgnoreCase(placa)) {
                System.out.println(carga);
                System.out.println("Calculo velocidade maxima: " + carga.calcVel(carga.getVelocMax()) + " cm/h");
                System.out.println("Quantidade de caracteres: " + carga.calcular());
                System.out.println("============================================");
                System.out.println();
                return;
            }
        }
        System.out.println("Veiculo de carga nao encontrado.");
        System.out.println("============================================");
        System.out.println();
    }

    private int encontrarPosicaoLivre(Object[] veiculos) {
        for (int i = 0; i < veiculos.length; i++) {
            if (veiculos[i] == null) {
                return i;
            }
        }
        return -1;
    }

    private boolean isArrayEmpty(Object[] array) {
        for (Object element : array) {
            if (element != null) {
                return false;
            }
        }
        return true;
    }
}
