/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package atividade04;

<<<<<<<< HEAD:java1/IvanildoSilvestreDaSilvaNeto_Atividade04/src/main/java/atividade04/Menu.java
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
========
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
>>>>>>>> 65f3268a51bacb2349e83079705764a855bc73be:java1/IvanildoSilvestreDaSilvaNeto_Atividade06/src/main/java/org/example/Teste.java
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

    public void controlarMenu() throws VeicExistException {
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

<<<<<<<< HEAD:java1/IvanildoSilvestreDaSilvaNeto_Atividade04/src/main/java/atividade04/Menu.java
    private void cadastrarVeiculoPasseio() {
========
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
>>>>>>>> 65f3268a51bacb2349e83079705764a855bc73be:java1/IvanildoSilvestreDaSilvaNeto_Atividade06/src/main/java/org/example/Teste.java
        Scanner scanner = new Scanner(System.in);
        String resposta;

        do {
<<<<<<<< HEAD:java1/IvanildoSilvestreDaSilvaNeto_Atividade04/src/main/java/atividade04/Menu.java
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
========
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
>>>>>>>> 65f3268a51bacb2349e83079705764a855bc73be:java1/IvanildoSilvestreDaSilvaNeto_Atividade06/src/main/java/org/example/Teste.java
            System.out.println("Deseja cadastrar outro veiculo de passeio? (SIM/NAO)");
            resposta = leitura.entDados(scanner.nextLine()).toUpperCase();
        } while (resposta.equals("SIM"));
    }

<<<<<<<< HEAD:java1/IvanildoSilvestreDaSilvaNeto_Atividade04/src/main/java/atividade04/Menu.java
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
========
    private void cadastrarVeiculoCarga() throws VeicExistException {
        Scanner scanner = new Scanner(System.in);
        String resposta;

        do {
            Map<String, Object> dados = obterDadosBasicos("Carga");

            System.out.print("Carga máxima: ");
>>>>>>>> 65f3268a51bacb2349e83079705764a855bc73be:java1/IvanildoSilvestreDaSilvaNeto_Atividade06/src/main/java/org/example/Teste.java
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

<<<<<<<< HEAD:java1/IvanildoSilvestreDaSilvaNeto_Atividade04/src/main/java/atividade04/Menu.java
            int posicao = encontrarPosicaoLivre(veiculosCarga);
            if (posicao != -1) {
                veiculosCarga[posicao] = carga;
                System.out.println("Veiculo de passeio cadastrado com sucesso!");
            } else {
                System.out.println("Não ha espaco disponivel para cadastrar mais veiculos de passeio.");
            }
========
            this.bd.pushCarga(carga);
>>>>>>>> 65f3268a51bacb2349e83079705764a855bc73be:java1/IvanildoSilvestreDaSilvaNeto_Atividade06/src/main/java/org/example/Teste.java

            System.out.println("Veículo de carga cadastrado com sucesso!");
            System.out.println("Deseja cadastrar outro veiculo de carga? (SIM/NAO)");
            resposta = leitura.entDados(scanner.nextLine()).toUpperCase();
        } while (resposta.equals("SIM"));
    }

    private void imprimirTodosVeiculosPasseio() {
<<<<<<<< HEAD:java1/IvanildoSilvestreDaSilvaNeto_Atividade04/src/main/java/atividade04/Menu.java
        if (isArrayEmpty(veiculosPasseio)) {
            System.out.println("Nenhum veiculo de passeio cadastrado.");
            System.out.println("Cadastre um veiculo de passeio para visualizar.");
========
        Passeio[] listaPasseio = this.bd.getListaPasseio();

        if (isArrayEmpty(listaPasseio)) {
            System.out.println("Nenhum veículo de passeio cadastrado.");
            System.out.println("Cadastre um veículo de passeio para visualizar.");
>>>>>>>> 65f3268a51bacb2349e83079705764a855bc73be:java1/IvanildoSilvestreDaSilvaNeto_Atividade06/src/main/java/org/example/Teste.java
            System.out.println("============================================");
            System.out.println();
            return;
        }

        System.out.println("=== Veiculos de Passeio ===");

<<<<<<<< HEAD:java1/IvanildoSilvestreDaSilvaNeto_Atividade04/src/main/java/atividade04/Menu.java
        for (Passeio passeio : veiculosPasseio) {
            if (passeio != null) {
                System.out.println(passeio);
                System.out.println("--------------------------------------------");
                System.out.println();
            }
========
        for (Passeio passeio : listaPasseio) {
            System.out.println(passeio);
            System.out.println("--------------------------------------------");
            System.out.println();
>>>>>>>> 65f3268a51bacb2349e83079705764a855bc73be:java1/IvanildoSilvestreDaSilvaNeto_Atividade06/src/main/java/org/example/Teste.java
        }

        System.out.println("============================================");
        System.out.println();
    }

    private void imprimirTodosVeiculosCarga() {
<<<<<<<< HEAD:java1/IvanildoSilvestreDaSilvaNeto_Atividade04/src/main/java/atividade04/Menu.java
        if (isArrayEmpty(veiculosCarga)) {
            System.out.println("Nenhum veiculo de carga cadastrado.");
            System.out.println("Cadastre um veiculo de carga para visualizar.");
========

        Carga[] listaCarga = this.bd.getListaCarga();

        if (isArrayEmpty(listaCarga)) {
            System.out.println("Nenhum veículo de carga cadastrado.");
            System.out.println("Cadastre um veículo de carga para visualizar.");
>>>>>>>> 65f3268a51bacb2349e83079705764a855bc73be:java1/IvanildoSilvestreDaSilvaNeto_Atividade06/src/main/java/org/example/Teste.java
            System.out.println("============================================");
            System.out.println();
            return;
        }

<<<<<<<< HEAD:java1/IvanildoSilvestreDaSilvaNeto_Atividade04/src/main/java/atividade04/Menu.java
        System.out.println("=== Veiculos de Carga ===");
        for (Carga carga : veiculosCarga) {
            if (carga != null) {
                System.out.println(carga);
                System.out.println("--------------------------------------------");
                System.out.println();
            }
========
        System.out.println("=== Veículos de Carga ===");
        for (Carga carga : listaCarga) {
            System.out.println(carga);
            System.out.println("--------------------------------------------");
            System.out.println();
>>>>>>>> 65f3268a51bacb2349e83079705764a855bc73be:java1/IvanildoSilvestreDaSilvaNeto_Atividade06/src/main/java/org/example/Teste.java
        }

        System.out.println("============================================");
        System.out.println();
    }

    private void imprimirVeiculoPasseioPorPlaca() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite a placa do veiculo de passeio: ");
        String placa = leitura.entDados(scanner.nextLine());

        Passeio[] veiculosPasseio = this.bd.getListaPasseio();

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

        Carga[] veiculosCarga = this.bd.getListaCarga();

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

    private boolean isArrayEmpty(Object[] array) {
        for (Object element : array) {
            if (element != null) {
                return false;
            }
        }
        return true;
    }
}
