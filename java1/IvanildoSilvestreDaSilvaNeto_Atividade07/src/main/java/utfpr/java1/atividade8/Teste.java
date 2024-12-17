/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utfpr.java1.atividade8;

import java.util.List;
import java.util.Scanner;

/**
 *
 * @author ivneto
 */
/**
 * Hello world!
 *
 */
public class Teste {

    private final Leitura leitura = new Leitura();
    private final BDVeiculos bd = new BDVeiculos();

    public static void main(String[] args) {

        Teste teste = new Teste();
        boolean continuar = true;

        while (continuar) {
            try {
                teste.controlarMenu();
                continuar = false;
            } catch (VeicExistException | VelocException e) {
                System.out.println(e.getMessage());
            }
        }

    }

    public void exibirMenu() {
        System.out.println("Sistema de Gestao de Veiculos - Menu Inicial");
        System.out.println("1. Cadastrar Veiculo de Passeio");
        System.out.println("2. Cadastrar Veiculo de Carga");
        System.out.println("3. Imprimir Todos os Veiculos de Passeio");
        System.out.println("4. Imprimir Todos os Veiculos de Carga");
        System.out.println("5. Imprimir Veiculo de Passeio pela Placa");
        System.out.println("6. Imprimir Veiculo de Carga pela Placa");
        System.out.println("7. Excluir Veiculo de Passeio pela Placa");
        System.out.println("8. Excluir Veiculo de Carga pela Placa");
        System.out.println("9. Sair do Sistema");
    }

    public void controlarMenu() throws VeicExistException, VelocException {
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
                    excluirVeiculoPasseioPelaPlaca();
                case 8 ->
                    excluirVeiculoCargaPelaPlaca();
                case 9 ->
                    System.out.println("Saindo do menu");
                default ->
                    System.out.println("Opção invalida. Tente novamente.");
            }
        } while (opcao != 9);
        scanner.close();
    }

    private void cadastrarVeiculoPasseio() throws VeicExistException, VelocException {
        Scanner scanner = new Scanner(System.in);
        String resposta;

        do {
            Passeio passeio = new Passeio("ABC1234", "Toyota", "Corolla", "Preto", 180.0F, 1, 1, 4, 140, 5);
            System.out.println("Cadastro de Veiculo de Passeio");

            System.out.print("Placa: ");
            String placa = leitura.entDados(scanner.nextLine());
            if (this.bd.isPasseioPresent(placa) || this.bd.isCargaPresent(placa)) {
                throw new VeicExistException();
            } else {
                passeio.setPlaca(placa);
            }

            System.out.print("Marca: ");
            passeio.setMarca(leitura.entDados(scanner.nextLine()));

            System.out.print("Modelo: ");
            passeio.setModelo(leitura.entDados(scanner.nextLine()));

            System.out.print("Cor: ");
            passeio.setCor(leitura.entDados(scanner.nextLine()));

            try {
                System.out.print("Velocidade Maxima: ");
                passeio.setVelocMax(Float.parseFloat(leitura.entDados(scanner.nextLine())));
            } catch (VelocException e) {
                System.err.println("Erro: " + e.getMessage());
                passeio.setVelocMax(100);
            }
            System.out.print("Quantidade de Rodas: ");
            passeio.setQtdRodas(Integer.parseInt(leitura.entDados(scanner.nextLine())));

            System.out.print("Quantidade de Pistoes do motor: ");
            int qtdPist = Integer.parseInt(leitura.entDados(scanner.nextLine()));

            System.out.print("Potencia do motor: ");
            int potencia = Integer.parseInt(leitura.entDados(scanner.nextLine()));

            passeio.setMotor(qtdPist, potencia);

            System.out.print("Quantidade de Passageiros: ");
            passeio.setQtdPassageiros(Integer.parseInt(leitura.entDados(scanner.nextLine())));

            this.bd.pushPasseio(passeio);

            System.out.println("Veiculo de passeio cadastrado com sucesso!");
            System.out.println("Deseja cadastrar outro veiculo de passeio? (SIM/NAO)");
            resposta = leitura.entDados(scanner.nextLine()).toUpperCase();

        } while (resposta.equals("SIM"));
    }

    private void cadastrarVeiculoCarga() throws VeicExistException, VelocException {
        Scanner scanner = new Scanner(System.in);
        String resposta;

        do {
            Carga carga = new Carga();
            System.out.println("Cadastro de Veiculo de Carga");

            System.out.print("Placa: ");
            String placa = leitura.entDados(scanner.nextLine());
            if (this.bd.isPasseioPresent(placa) || this.bd.isCargaPresent(placa)) {
                throw new VeicExistException();
            } else {
                carga.setPlaca(placa);
            }

            System.out.print("Marca: ");
            carga.setMarca(leitura.entDados(scanner.nextLine()));

            System.out.print("Modelo: ");
            carga.setModelo(leitura.entDados(scanner.nextLine()));

            System.out.print("Cor: ");
            carga.setCor(leitura.entDados(scanner.nextLine()));

            try {
                System.out.print("Velocidade Maxima: ");
                carga.setVelocMax(Float.parseFloat(leitura.entDados(scanner.nextLine())));
            } catch (VelocException e) {
                System.err.println("Erro: " + e.getMessage());
                carga.setVelocMax(90);
            }

            System.out.print("Quantidade de Rodas: ");
            carga.setQtdRodas(Integer.parseInt(leitura.entDados(scanner.nextLine())));

            System.out.print("Quantidade de Pistoes do motor: ");
            int qtdPist = Integer.parseInt(leitura.entDados(scanner.nextLine()));

            System.out.print("Potência do motor: ");
            int potencia = Integer.parseInt(leitura.entDados(scanner.nextLine()));

            carga.setMotor(qtdPist, potencia);

            System.out.print("Carga maxima: ");
            carga.setCargaMax(Integer.parseInt(leitura.entDados(scanner.nextLine())));

            System.out.println("Tara:");
            carga.setTara(Integer.parseInt(leitura.entDados(scanner.nextLine())));

            this.bd.pushCarga(carga);

            System.out.println("Veiculo de carga cadastrado com sucesso!");
            System.out.println("Deseja cadastrar outro veiculo de carga? (SIM/NAO)");
            resposta = leitura.entDados(scanner.nextLine()).toUpperCase();
        } while (resposta.equals("SIM"));
    }

    private void imprimirTodosVeiculosPasseio() {
        List<Passeio> listaPasseio = this.bd.getListaPasseio();

        if (listaPasseio.isEmpty()) {
            System.out.println("Nenhum veiculo de passeio cadastrado.");
            System.out.println("Cadastre um veículo de passeio para visualizar.");
            System.out.println("============================================");
            System.out.println();
            return;
        }

        System.out.println("=== Veiculos de Passeio ===");

        for (Passeio passeio : listaPasseio) {
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

        List<Carga> listaCarga = this.bd.getListaCarga();

        if (listaCarga.isEmpty()) {
            System.out.println("Nenhum veiculo de carga cadastrado.");
            System.out.println("Cadastre um veiculo de carga para visualizar.");
            System.out.println("============================================");
            System.out.println();
            return;
        }

        System.out.println("=== Veiculos de Carga ===");
        for (Carga carga : listaCarga) {
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
        System.out.print("Digite a placa do veículo de passeio: ");
        String placa = leitura.entDados(scanner.nextLine());

        List<Passeio> veiculosPasseio = this.bd.getListaPasseio();

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
        System.out.println("Veiculo de passeio não encontrado.");
        System.out.println("============================================");
        System.out.println();
    }

    private void imprimirVeiculoCargaPorPlaca() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite a placa do veiculo de passeio: ");
        String placa = leitura.entDados(scanner.nextLine());

        List<Carga> veiculosCarga = this.bd.getListaCarga();

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

    private void excluirVeiculoPasseioPelaPlaca() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Informe a placa do veiculo que deseja excluir:");
        String placa = leitura.entDados(scanner.nextLine());
        this.bd.deletePasseioByPlaca(placa);
    }

    private void excluirVeiculoCargaPelaPlaca() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Informe a placa do veiculo que deseja excluir:");
        String placa = leitura.entDados(scanner.nextLine());
        this.bd.deleteCargaByPlaca(placa);
    }

}
