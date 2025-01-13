package org.example;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class Teste
{
    private Passeio[] veiculosPasseio = new Passeio[5];
    private Carga[] veiculosCarga = new Carga[5];
    private Leitura leitura = new Leitura();

    public static void main( String[] args ) {
        Teste teste = new Teste();
        teste.controlarMenu();
    }

    public void exibirMenu() {
        System.out.println("Sistema de Gestão de Veículos - Menu Inicial");
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
                case 1:
                    cadastrarVeiculoPasseio();
                    break;
                case 2:
                    cadastrarVeiculoCarga();
                    break;
                case 3:
                    imprimirTodosVeiculosPasseio();
                    break;
                case 4:
                    imprimirTodosVeiculosCarga();
                    break;
                case 5:
                    imprimirVeiculoPasseioPorPlaca();
                    break;
                case 6:
                    imprimirVeiculoCargaPorPlaca();
                    break;
                case 7:
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 7);
        scanner.close();
    }

    private void cadastrarVeiculoPasseio() throws VeicExistException {
        Scanner scanner = new Scanner(System.in);
        String resposta = "SIM";
        do {
            scanner = new Scanner(System.in);
            System.out.println("Cadastro de Veículo de Passeio");
            System.out.print("Placa: ");
            String placa = leitura.entDados(scanner.nextLine());

            if (Arrays.stream(veiculosPasseio).anyMatch(veiculo -> veiculo != null && veiculo.getPlaca().equalsIgnoreCase(placa))) {
                throw new VeicExistException("Já existe um veículo com esta placa");
            }

            System.out.print("Marca: ");
            String marca = leitura.entDados(scanner.nextLine());
            System.out.print("Modelo: ");
            String modelo = leitura.entDados(scanner.nextLine());
            System.out.print("Cor: ");
            String cor = leitura.entDados(scanner.nextLine());
            System.out.print("Velocidade Máxima: ");
            float velocMax = Float.parseFloat(leitura.entDados(scanner.nextLine()));
            System.out.print("Quantidade de Rodas: ");
            int qtdRodas = Integer.parseInt(leitura.entDados(scanner.nextLine()));
            System.out.print("Quantidade de Pistões do motor: ");
            int qtdPist = Integer.parseInt(leitura.entDados(scanner.nextLine()));
            System.out.print("Potência do motor: ");
            int potencia = Integer.parseInt(leitura.entDados(scanner.nextLine()));
            System.out.print("Quantidade de Passageiros: ");
            int qtdPassageiros = Integer.parseInt(leitura.entDados(scanner.nextLine()));

            Passeio passeio = new Passeio(placa, marca, modelo, cor, velocMax, qtdRodas, qtdPist, potencia, qtdPassageiros);

            int posicao = encontrarPosicaoLivre(veiculosPasseio);
            if (posicao != -1) {
                veiculosPasseio[posicao] = passeio;
                System.out.println("Veículo de passeio cadastrado com sucesso!");
            } else {
                System.out.println("Não há espaço disponível para cadastrar mais veículos de passeio.");
                continue;
            }

            System.out.println("Veículo de passeio cadastrado com sucesso!");
            System.out.println("Deseja cadastrar outro veiculo de passeio? (SIM/NAO)");
            resposta = leitura.entDados(scanner.nextLine()).toUpperCase();
        } while (resposta.equals("SIM"));
    }

    private void cadastrarVeiculoCarga() {
        Scanner scanner = new Scanner(System.in);
        String resposta = "SIM";

        do {
            System.out.println("Cadastro de Veículo de Carga");
            System.out.print("Placa: ");
            String placa = leitura.entDados(scanner.nextLine());

            if (Arrays.stream(veiculosCarga).anyMatch(veiculo -> veiculo != null && veiculo.getPlaca().equalsIgnoreCase(placa))) {
                System.out.println("Placa já cadastrada. Tente novamente.");
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
            System.out.print("Velocidade Máxima: ");
            float velocMax = Float.parseFloat(leitura.entDados(scanner.nextLine()));
            System.out.print("Quantidade de Rodas: ");
            int qtdRodas = Integer.parseInt(leitura.entDados(scanner.nextLine()));
            System.out.print("Quantidade de Pistões do motor: ");
            int qtdPist = Integer.parseInt(leitura.entDados(scanner.nextLine()));
            System.out.print("Potência do motor: ");
            int potencia = Integer.parseInt(leitura.entDados(scanner.nextLine()));
            System.out.print("Carga maxima: ");
            int cargaMax = Integer.parseInt(leitura.entDados(scanner.nextLine()));
            System.out.print("Tara: ");
            int tara = Integer.parseInt(leitura.entDados(scanner.nextLine()));

            Carga carga = new Carga(placa, marca, modelo, cor, velocMax, qtdRodas, qtdPist, potencia, cargaMax, tara);

            int posicao = encontrarPosicaoLivre(veiculosCarga);
            if (posicao != -1) {
                veiculosCarga[posicao] = carga;
                System.out.println("Veículo de passeio cadastrado com sucesso!");
            } else {
                System.out.println("Não há espaço disponível para cadastrar mais veículos de passeio.");
            }

            System.out.println("Deseja cadastrar outro veiculo de carga? (SIM/NAO)");
            resposta = leitura.entDados(scanner.nextLine()).toUpperCase();
        } while (resposta.equals("SIM"));
    }

    private void imprimirTodosVeiculosPasseio() {
        if (isArrayEmpty(veiculosPasseio)) {
            System.out.println("Nenhum veículo de passeio cadastrado.");
            System.out.println("Cadastre um veículo de passeio para visualizar.");
            System.out.println("============================================");
            System.out.println();
            return;
        }

        System.out.println("=== Veículos de Passeio ===");

        for (Passeio passeio : veiculosPasseio) {
            System.out.println(passeio);
            System.out.println("--------------------------------------------");
            System.out.println();
        }

        System.out.println("============================================");
        System.out.println();
    }

    private void imprimirTodosVeiculosCarga() {
        if (isArrayEmpty(veiculosCarga)) {
            System.out.println("Nenhum veículo de carga cadastrado.");
            System.out.println("Cadastre um veículo de carga para visualizar.");
            System.out.println("============================================");
            System.out.println();
            return;
        }

        System.out.println("=== Veículos de Carga ===");
        for (Carga carga : veiculosCarga) {
            System.out.println(carga);
            System.out.println("--------------------------------------------");
            System.out.println();
        }

        System.out.println("============================================");
        System.out.println();
    }

    private void imprimirVeiculoPasseioPorPlaca() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite a placa do veículo de passeio: ");
        String placa = leitura.entDados(scanner.nextLine());
        for (Passeio passeio : veiculosPasseio) {
            if (passeio.getPlaca().equalsIgnoreCase(placa)) {
                System.out.println(passeio);
                System.out.println("Calculo velocidade maxima: " + passeio.calcVel(passeio.getVelocMax()) + " m/h");
                System.out.println("Quantidade de caracteres: " + passeio.calcular());
                System.out.println("============================================");
                System.out.println();
                return;
            }
        }
        System.out.println("Veículo de passeio não encontrado.");
        System.out.println("============================================");
        System.out.println();
    }

    private void imprimirVeiculoCargaPorPlaca() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite a placa do veículo de passeio: ");
        String placa = leitura.entDados(scanner.nextLine());
        for (Carga carga : veiculosCarga) {
            if (carga.getPlaca().equalsIgnoreCase(placa)) {
                System.out.println(carga);
                System.out.println("Calculo velocidade maxima: " + carga.calcVel(carga.getVelocMax()) + " cm/h");
                System.out.println("Quantidade de caracteres: " + carga.calcular());
                System.out.println("============================================");
                System.out.println();
                return;
            }
        }
        System.out.println("Veículo de carga não encontrado.");
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

