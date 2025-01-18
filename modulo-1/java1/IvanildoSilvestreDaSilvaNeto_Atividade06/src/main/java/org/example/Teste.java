package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class Teste
{
    private final Leitura leitura = new Leitura();
    private final BDVeiculos bd = new BDVeiculos();

    public static void main( String[] args ) {
        Teste teste = new Teste();
        try {
            teste.controlarMenu();
        } catch (VeicExistException e) {
            System.out.println(e.getMessage());
        }
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

    public void controlarMenu() throws VeicExistException {
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

    private Map<String, Object> obterDadosBasicos(String tipoVeiculo) throws VeicExistException {
        Scanner scanner = new Scanner(System.in);
        Map<String, Object> dados = new HashMap<>();

        System.out.println("Cadastro de Veículo de " + tipoVeiculo);
        System.out.print("Placa: ");
        String placa = leitura.entDados(scanner.nextLine());

        if ((tipoVeiculo.equals("Passeio") && this.bd.isPasseioPresent(placa)) ||
                (tipoVeiculo.equals("Carga") && this.bd.isCargaPresent(placa))) {
            throw new VeicExistException();
        }
        dados.put("placa", placa);

        System.out.print("Marca: ");
        dados.put("marca", leitura.entDados(scanner.nextLine()));
        System.out.print("Modelo: ");
        dados.put("modelo", leitura.entDados(scanner.nextLine()));
        System.out.print("Cor: ");
        dados.put("cor", leitura.entDados(scanner.nextLine()));
        System.out.print("Velocidade Máxima: ");
        dados.put("velocMax", Float.parseFloat(leitura.entDados(scanner.nextLine())));
        System.out.print("Quantidade de Rodas: ");
        dados.put("qtdRodas", Integer.parseInt(leitura.entDados(scanner.nextLine())));
        System.out.print("Quantidade de Pistões do motor: ");
        dados.put("qtdPist", Integer.parseInt(leitura.entDados(scanner.nextLine())));
        System.out.print("Potência do motor: ");
        dados.put("potencia", Integer.parseInt(leitura.entDados(scanner.nextLine())));

        return dados;
    }

    private void cadastrarVeiculoPasseio() throws VeicExistException {
        Scanner scanner = new Scanner(System.in);
        String resposta;

        do {
            Map<String, Object> dados = obterDadosBasicos("Passeio");

            System.out.print("Quantidade de Passageiros: ");
            int qtdPassageiros = Integer.parseInt(leitura.entDados(scanner.nextLine()));

            Passeio passeio = new Passeio(
                    (String) dados.get("placa"),
                    (String) dados.get("marca"),
                    (String) dados.get("modelo"),
                    (String) dados.get("cor"),
                    (float) dados.get("velocMax"),
                    (int) dados.get("qtdRodas"),
                    (int) dados.get("qtdPist"),
                    (int) dados.get("potencia"),
                    qtdPassageiros
            );

            this.bd.pushPasseio(passeio);

            System.out.println("Veículo de passeio cadastrado com sucesso!");
            System.out.println("Deseja cadastrar outro veiculo de passeio? (SIM/NAO)");
            resposta = leitura.entDados(scanner.nextLine()).toUpperCase();
        } while (resposta.equals("SIM"));
    }

    private void cadastrarVeiculoCarga() throws VeicExistException {
        Scanner scanner = new Scanner(System.in);
        String resposta;

        do {
            Map<String, Object> dados = obterDadosBasicos("Carga");

            System.out.print("Carga máxima: ");
            int cargaMax = Integer.parseInt(leitura.entDados(scanner.nextLine()));
            System.out.print("Tara: ");
            int tara = Integer.parseInt(leitura.entDados(scanner.nextLine()));

            Carga carga = new Carga(
                    (String) dados.get("placa"),
                    (String) dados.get("marca"),
                    (String) dados.get("modelo"),
                    (String) dados.get("cor"),
                    (float) dados.get("velocMax"),
                    (int) dados.get("qtdRodas"),
                    (int) dados.get("qtdPist"),
                    (int) dados.get("potencia"),
                    cargaMax,
                    tara
            );

            this.bd.pushCarga(carga);

            System.out.println("Veículo de carga cadastrado com sucesso!");
            System.out.println("Deseja cadastrar outro veiculo de carga? (SIM/NAO)");
            resposta = leitura.entDados(scanner.nextLine()).toUpperCase();
        } while (resposta.equals("SIM"));
    }

    private void imprimirTodosVeiculosPasseio() {
        Passeio[] listaPasseio = this.bd.getListaPasseio();

        if (isArrayEmpty(listaPasseio)) {
            System.out.println("Nenhum veículo de passeio cadastrado.");
            System.out.println("Cadastre um veículo de passeio para visualizar.");
            System.out.println("============================================");
            System.out.println();
            return;
        }

        System.out.println("=== Veículos de Passeio ===");

        for (Passeio passeio : listaPasseio) {
            System.out.println(passeio);
            System.out.println("--------------------------------------------");
            System.out.println();
        }

        System.out.println("============================================");
        System.out.println();
    }

    private void imprimirTodosVeiculosCarga() {

        Carga[] listaCarga = this.bd.getListaCarga();

        if (isArrayEmpty(listaCarga)) {
            System.out.println("Nenhum veículo de carga cadastrado.");
            System.out.println("Cadastre um veículo de carga para visualizar.");
            System.out.println("============================================");
            System.out.println();
            return;
        }

        System.out.println("=== Veículos de Carga ===");
        for (Carga carga : listaCarga) {
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

        Passeio[] veiculosPasseio = this.bd.getListaPasseio();

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

        Carga[] veiculosCarga = this.bd.getListaCarga();

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

    private boolean isArrayEmpty(Object[] array) {
        for (Object element : array) {
            if (element != null) {
                return false;
            }
        }
        return true;
    }

}

