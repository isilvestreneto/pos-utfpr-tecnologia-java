package utfpr.java1.atividade8;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Janela {

    static BDVeiculos bd = new BDVeiculos();

    public static void main(String[] args) {
        Janela.construirFrame1();
    }

    private static void construirFrame1() {
        final String title = "Gestão de veículos";
        JFrame jf = new JFrame(title);
        jf.setSize(500, 500);
        jf.setLocationRelativeTo(null);

        var botaoPasseio = new JButton("Passeio");
        var botaoCarga = new JButton("Carga");

        jf.add(botaoPasseio);
        jf.add(botaoCarga);

        botaoPasseio.addActionListener(e -> tratarBotaoPasseio(e, jf));

        botaoCarga.addActionListener(e -> tratarBotaoCarga(e, jf));

        jf.setLayout(new FlowLayout());
        jf.setVisible(true);
    }

    static void tratarBotaoPasseio(ActionEvent e, JFrame jf) {
        jf.dispose();

        final String title = "Veículos de Passeio";
        JFrame jfPasseio = new JFrame(title);
        jfPasseio.setSize(500, 500);
        jfPasseio.setLocationRelativeTo(null);

        var botaoCadastrar = new JButton("Cadastrar");
        botaoCadastrar.addActionListener(evt -> {
            openPageCadastroPasseio(jfPasseio);
        });

        var botaoConsultarExcluirPorPlaca = new JButton("Consultar / Excluir por placa");
        botaoConsultarExcluirPorPlaca.addActionListener(evt -> {
            consultarExcluirPorPlacaPasseio(jfPasseio);
        });

        var botaoImprimirExcluirTodos = new JButton("Imprimir / Excluir todos");
        botaoImprimirExcluirTodos.addActionListener(evt -> {
            imprimirExcluirTodosPasseio(jfPasseio);
        });

        var botaoSair = new JButton("Sair");
        botaoSair.addActionListener(evt -> {
            jfPasseio.dispose();
            jf.setVisible(true);
        });

        jfPasseio.add(botaoCadastrar);
        jfPasseio.add(botaoConsultarExcluirPorPlaca);
        jfPasseio.add(botaoImprimirExcluirTodos);
        jfPasseio.add(botaoSair);

        jfPasseio.setLayout(new FlowLayout());
        jfPasseio.setVisible(true);

    }

    static void tratarBotaoCarga(ActionEvent e, JFrame jf) {
        jf.dispose();

        final String title = "Veículos de Carga";
        JFrame jfCarga = new JFrame(title);
        jfCarga.setSize(500, 500);
        jfCarga.setLocationRelativeTo(null);

        var botaoCadastrar = new JButton("Cadastrar");
        botaoCadastrar.addActionListener(evt -> {
            openPageCadastroCarga(jfCarga);
        });

        var botaoConsultarExcluirPorPlaca = new JButton("Consultar / Excluir por placa");
        botaoConsultarExcluirPorPlaca.addActionListener(evt -> {
            consultarExcluirPorPlacaCarga(jfCarga);
        });

        var botaoImprimirExcluirTodos = new JButton("Imprimir / Excluir todos");
        botaoImprimirExcluirTodos.addActionListener(evt -> {
            imprimirExcluirTodosCarga(jfCarga);
        });

        var botaoSair = new JButton("Sair");
        botaoSair.addActionListener(evt -> {
            jfCarga.dispose();
            jf.setVisible(true);
        });

        jfCarga.add(botaoCadastrar);
        jfCarga.add(botaoConsultarExcluirPorPlaca);
        jfCarga.add(botaoImprimirExcluirTodos);
        jfCarga.add(botaoSair);

        jfCarga.setLayout(new FlowLayout());
        jfCarga.setVisible(true);

    }

    static void openPageCadastroPasseio(JFrame jfPasseioHome) {
        jfPasseioHome.dispose();

        List<JTextField> textFields = new ArrayList<>();

        final String title = "Cadastro de Passeio";
        JFrame jf = new JFrame(title);
        jf.setSize(500, 500);
        jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        jf.setLocationRelativeTo(null);

        jf.setLayout(new BorderLayout(10, 10));

        JPanel inputPanel = new JPanel(new GridLayout(9, 2, 10, 10));

        inputPanel.add(new JLabel("Qtd. Passageiros:"));
        JTextField txtQtdPassageiros = new JTextField();
        textFields.add(txtQtdPassageiros);
        inputPanel.add(txtQtdPassageiros);

        inputPanel.add(new JLabel("Placa:"));
        JTextField txtPlaca = new JTextField();
        textFields.add(txtPlaca);
        inputPanel.add(txtPlaca);

        inputPanel.add(new JLabel("Marca:"));
        JTextField txtMarca = new JTextField();
        textFields.add(txtMarca);
        inputPanel.add(txtMarca);

        inputPanel.add(new JLabel("Modelo:"));
        JTextField txtModelo = new JTextField();
        textFields.add(txtModelo);
        inputPanel.add(txtModelo);

        inputPanel.add(new JLabel("Cor:"));
        JTextField txtCor = new JTextField();
        textFields.add(txtCor);
        inputPanel.add(txtCor);

        inputPanel.add(new JLabel("Qtd. Rodas:"));
        JTextField txtQtdRodas = new JTextField();
        textFields.add(txtQtdRodas);
        inputPanel.add(txtQtdRodas);

        inputPanel.add(new JLabel("Velocidade Máx.:"));
        JTextField txtVelocMax = new JTextField();
        textFields.add(txtVelocMax);
        inputPanel.add(txtVelocMax);

        inputPanel.add(new JLabel("Qtd. Pistões:"));
        JTextField txtQtdPistoes = new JTextField();
        textFields.add(txtQtdPistoes);
        inputPanel.add(txtQtdPistoes);

        inputPanel.add(new JLabel("Potência:"));
        JTextField txtPotencia = new JTextField();
        textFields.add(txtPotencia);
        inputPanel.add(txtPotencia);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        JButton btnCadastrar = new JButton("Cadastrar");
        JButton btnLimpar = new JButton("Limpar");
        JButton btnNovo = new JButton("Novo");
        JButton btnSair = new JButton("Sair");

        buttonPanel.add(btnCadastrar);
        buttonPanel.add(btnLimpar);
        buttonPanel.add(btnNovo);
        buttonPanel.add(btnSair);

        btnCadastrar.addActionListener(e -> {
            Passeio passeio = new Passeio();

            if (txtPlaca.getText().trim().isEmpty()
                    || txtMarca.getText().trim().isEmpty()
                    || txtModelo.getText().trim().isEmpty()
                    || txtCor.getText().trim().isEmpty()
                    || txtQtdRodas.getText().trim().isEmpty()
                    || txtVelocMax.getText().trim().isEmpty()
                    || txtQtdPistoes.getText().trim().isEmpty()
                    || txtPotencia.getText().trim().isEmpty()
                    || txtQtdPassageiros.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(jf, "Todos os campos são obrigatórios!", "Erro", JOptionPane.ERROR_MESSAGE);
            } else {
                try {
                    passeio.setQtdPassageiros(Integer.parseInt(txtQtdPassageiros.getText()));
                    String placa = txtPlaca.getText();
                    if (bd.isPasseioPresent(placa) || bd.isCargaPresent(placa)) {
                        throw new VeicExistException();
                    } else {
                        passeio.setPlaca(placa);
                    }
                    passeio.setMarca(txtMarca.getText());
                    passeio.setModelo(txtModelo.getText());
                    passeio.setCor(txtCor.getText());
                    passeio.setQtdRodas(Integer.parseInt(txtQtdRodas.getText()));

                    float velocMax = Float.parseFloat(txtVelocMax.getText());

                    if (velocMax < 100) {
                        throw new VelocException("Velocidade Máxima inválida! Valor padrão atribuído: 100.");
                    }

                    passeio.setVelocMax(Float.parseFloat(txtVelocMax.getText()));

                    int qtdPistoes = Integer.parseInt(txtQtdPistoes.getText());
                    int potencia = Integer.parseInt(txtPotencia.getText());
                    passeio.setMotor(qtdPistoes, potencia);

                    BDVeiculos.pushPasseio(passeio);
                    System.out.println("Veículo cadastrado com sucesso: " + passeio);
                    JOptionPane.showMessageDialog(jf, "Veiculo de placa " + passeio.getPlaca() + " cadastrado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                    clearFields(textFields);
                } catch (VeicExistException ex) {
                    JOptionPane.showMessageDialog(jf, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                    clearFields(textFields);
                } catch (VelocException ex) {
                    passeio.setVelocMax(100);

                    int qtdPistoes = Integer.parseInt(txtQtdPistoes.getText());
                    int potencia = Integer.parseInt(txtPotencia.getText());
                    passeio.setMotor(qtdPistoes, potencia);

                    BDVeiculos.pushPasseio(passeio);
                    System.out.println("Veículo cadastrado com sucesso: " + passeio);
                    JOptionPane.showMessageDialog(jf, "Veiculo de placa " + passeio.getPlaca() + " cadastrado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                    clearFields(textFields);
                }
            }
        });

        btnLimpar.addActionListener(e -> {
            clearFields(textFields);
        });

        btnNovo.addActionListener(e -> {
            clearFields(textFields);
            JOptionPane.showMessageDialog(jf, "Novo formulário iniciado!");
        });

        btnSair.addActionListener(e -> {
            jf.dispose();
            jfPasseioHome.setVisible(true);
        });

        jf.add(inputPanel, BorderLayout.CENTER);
        jf.add(buttonPanel, BorderLayout.SOUTH);

        jf.setVisible(true);
    }

    static void openPageCadastroCarga(JFrame jfPasseioHome) {
        jfPasseioHome.dispose();

        List<JTextField> textFields = new ArrayList<>();

        final String title = "Cadastro de Carga";
        JFrame jf = new JFrame(title);
        jf.setSize(500, 500);
        jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        jf.setLocationRelativeTo(null);

        jf.setLayout(new BorderLayout(10, 10));

        JPanel inputPanel = new JPanel(new GridLayout(10, 2, 10, 10));

        inputPanel.add(new JLabel("Carga max:"));
        JTextField txtCargaMax = new JTextField();
        textFields.add(txtCargaMax);
        inputPanel.add(txtCargaMax);

        inputPanel.add(new JLabel("Tara:"));
        JTextField txtTara = new JTextField();
        textFields.add(txtTara);
        inputPanel.add(txtTara);

        inputPanel.add(new JLabel("Placa:"));
        JTextField txtPlaca = new JTextField();
        textFields.add(txtPlaca);
        inputPanel.add(txtPlaca);

        inputPanel.add(new JLabel("Marca:"));
        JTextField txtMarca = new JTextField();
        textFields.add(txtMarca);
        inputPanel.add(txtMarca);

        inputPanel.add(new JLabel("Modelo:"));
        JTextField txtModelo = new JTextField();
        textFields.add(txtModelo);
        inputPanel.add(txtModelo);

        inputPanel.add(new JLabel("Cor:"));
        JTextField txtCor = new JTextField();
        textFields.add(txtCor);
        inputPanel.add(txtCor);

        inputPanel.add(new JLabel("Qtd. Rodas:"));
        JTextField txtQtdRodas = new JTextField();
        textFields.add(txtQtdRodas);
        inputPanel.add(txtQtdRodas);

        inputPanel.add(new JLabel("Velocidade Máx.:"));
        JTextField txtVelocMax = new JTextField();
        textFields.add(txtVelocMax);
        inputPanel.add(txtVelocMax);

        inputPanel.add(new JLabel("Qtd. Pistões:"));
        JTextField txtQtdPistoes = new JTextField();
        textFields.add(txtQtdPistoes);
        inputPanel.add(txtQtdPistoes);

        inputPanel.add(new JLabel("Potência:"));
        JTextField txtPotencia = new JTextField();
        textFields.add(txtPotencia);
        inputPanel.add(txtPotencia);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        JButton btnCadastrar = new JButton("Cadastrar");
        JButton btnLimpar = new JButton("Limpar");
        JButton btnNovo = new JButton("Novo");
        JButton btnSair = new JButton("Sair");

        buttonPanel.add(btnCadastrar);
        buttonPanel.add(btnLimpar);
        buttonPanel.add(btnNovo);
        buttonPanel.add(btnSair);

        btnCadastrar.addActionListener(e -> {
            Carga carga = new Carga();

            if (txtPlaca.getText().trim().isEmpty()
                    || txtMarca.getText().trim().isEmpty()
                    || txtModelo.getText().trim().isEmpty()
                    || txtCor.getText().trim().isEmpty()
                    || txtQtdRodas.getText().trim().isEmpty()
                    || txtVelocMax.getText().trim().isEmpty()
                    || txtQtdPistoes.getText().trim().isEmpty()
                    || txtPotencia.getText().trim().isEmpty()
                    || txtCargaMax.getText().trim().isEmpty()
                    || txtTara.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(jf, "Todos os campos são obrigatórios!", "Erro", JOptionPane.ERROR_MESSAGE);
            } else {
                try {
                    String placa = txtPlaca.getText();
                    if (bd.isPasseioPresent(placa) || bd.isCargaPresent(placa)) {
                        throw new VeicExistException();
                    } else {
                        carga.setPlaca(placa);
                    }
                    carga.setMarca(txtMarca.getText());
                    carga.setModelo(txtModelo.getText());
                    carga.setCor(txtCor.getText());
                    carga.setQtdRodas(Integer.parseInt(txtQtdRodas.getText()));

                    float velocMax = Float.parseFloat(txtVelocMax.getText());

                    if (velocMax < 100) {
                        throw new VelocException("Velocidade Máxima inválida! Valor padrão atribuído: 100.");
                    }

                    carga.setVelocMax(Float.parseFloat(txtVelocMax.getText()));

                    int qtdPistoes = Integer.parseInt(txtQtdPistoes.getText());
                    int potencia = Integer.parseInt(txtPotencia.getText());
                    carga.setMotor(qtdPistoes, potencia);

                    carga.setCargaMax(Integer.parseInt(txtCargaMax.getText()));
                    carga.setTara(Integer.parseInt(txtTara.getText()));

                    BDVeiculos.pushCarga(carga);
                    System.out.println("Veículo cadastrado com sucesso: " + carga);
                    JOptionPane.showMessageDialog(jf, "Veiculo de placa " + carga.getPlaca() + " cadastrado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                    clearFields(textFields);
                } catch (VeicExistException ex) {
                    JOptionPane.showMessageDialog(jf, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                    clearFields(textFields);
                } catch (VelocException ex) {
                    carga.setVelocMax(90);

                    int qtdPistoes = Integer.parseInt(txtQtdPistoes.getText());
                    int potencia = Integer.parseInt(txtPotencia.getText());
                    carga.setMotor(qtdPistoes, potencia);

                    BDVeiculos.pushCarga(carga);
                    System.out.println("Veículo cadastrado com sucesso: " + carga);
                    JOptionPane.showMessageDialog(jf, "Veiculo de placa " + carga.getPlaca() + " cadastrado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                    clearFields(textFields);
                }
            }
        });

        btnLimpar.addActionListener(e -> {
            clearFields(textFields);
        });

        btnNovo.addActionListener(e -> {
            clearFields(textFields);
            JOptionPane.showMessageDialog(jf, "Novo formulário iniciado!");
        });

        btnSair.addActionListener(e -> {
            jf.dispose();
            jfPasseioHome.setVisible(true);
        });

        jf.add(inputPanel, BorderLayout.CENTER);
        jf.add(buttonPanel, BorderLayout.SOUTH);

        jf.setVisible(true);
    }

    private static void clearFields(List<JTextField> textFields) {
        for (JTextField field : textFields) {
            field.setText("");
        }
    }

    private static void imprimirExcluirTodosPasseio(JFrame jfPasseio) {
        jfPasseio.dispose();

        List<JTextField> textFields = new ArrayList<>();

        final String title = "Consultar / Excluir pela placa";
        JFrame jf = new JFrame(title);
        jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        jf.setSize(800, 600);
        jf.setLayout(new BorderLayout(10, 10));
        jf.setLocationRelativeTo(null);

        String[] colunas = {"Placa", "Marca", "Modelo", "Cor", "Qtd. Rodas", "Veloc. Máx.", "Qtd. Pistões", "Potência", "Qtd. Passageiros"};
        DefaultTableModel tableModel = new DefaultTableModel(colunas, 0);
        JTable table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        jf.add(scrollPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 10));
        JButton btnImprimirTodos = new JButton("Imprimir Todos");
        JButton btnExcluirTodos = new JButton("Excluir Todos");
        JButton btnSair = new JButton("Sair");

        buttonPanel.add(btnImprimirTodos);
        buttonPanel.add(btnExcluirTodos);
        buttonPanel.add(btnSair);
        jf.add(buttonPanel, BorderLayout.SOUTH);

        btnImprimirTodos.addActionListener(e -> imprimirTodosPasseio(tableModel));

        btnExcluirTodos.addActionListener(e -> excluirTodosPasseio(jf, tableModel));

        btnSair.addActionListener(e -> {
            jf.dispose();
            jfPasseio.setVisible(true);
        });

        atualizarTabelaPasseio(tableModel);

        jf.setVisible(true);
        jf.setLayout(new FlowLayout());
        jf.setVisible(true);

    }

    private static void imprimirExcluirTodosCarga(JFrame jfPasseio) {
        jfPasseio.dispose();

        List<JTextField> textFields = new ArrayList<>();

        final String title = "Consultar / Excluir pela placa";
        JFrame jf = new JFrame(title);
        jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        jf.setSize(800, 600);
        jf.setLayout(new BorderLayout(10, 10));
        jf.setLocationRelativeTo(null);

        String[] colunas = {"Placa", "Marca", "Modelo", "Cor", "Qtd. Rodas", "Veloc. Máx.", "Qtd. Pistões", "Potência", "Carga maxima", "Tara"};
        DefaultTableModel tableModel = new DefaultTableModel(colunas, 0);
        JTable table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        jf.add(scrollPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 10));
        JButton btnImprimirTodos = new JButton("Imprimir Todos");
        JButton btnExcluirTodos = new JButton("Excluir Todos");
        JButton btnSair = new JButton("Sair");

        buttonPanel.add(btnImprimirTodos);
        buttonPanel.add(btnExcluirTodos);
        buttonPanel.add(btnSair);
        jf.add(buttonPanel, BorderLayout.SOUTH);

        btnImprimirTodos.addActionListener(e -> imprimirTodosCarga(tableModel));

        btnExcluirTodos.addActionListener(e -> excluirTodosCarga(jf, tableModel));

        btnSair.addActionListener(e -> {
            jf.dispose();
            jfPasseio.setVisible(true);
        });

        Carga carga1 = new Carga("ABC1234", "Volvo", "FH", "Branco", 120.0f, 6, 6, 540, 25000, 8000);
        Carga carga2 = new Carga("DEF5678", "Scania", "R450", "Azul", 110.0f, 6, 6, 450, 24000, 7500);
        Carga carga3 = new Carga("GHI9012", "Mercedes", "Actros", "Vermelho", 115.0f, 8, 8, 600, 26000, 8500);
        Carga carga4 = new Carga("JKL3456", "Iveco", "Stralis", "Prata", 108.0f, 6, 6, 400, 23000, 7000);
        Carga carga5 = new Carga("MNO7890", "DAF", "XF", "Preto", 125.0f, 10, 8, 530, 28000, 9000);

        BDVeiculos.pushCarga(carga1);
        BDVeiculos.pushCarga(carga2);
        BDVeiculos.pushCarga(carga3);
        BDVeiculos.pushCarga(carga4);
        BDVeiculos.pushCarga(carga5);

        atualizarTabelaCarga(tableModel);

        jf.setVisible(true);
        jf.setLayout(new FlowLayout());
        jf.setVisible(true);

    }

    private static void atualizarTabelaPasseio(DefaultTableModel tableModel) {
        tableModel.setRowCount(0);

        for (Passeio passeio : BDVeiculos.getListaPasseio()) {
            tableModel.addRow(new Object[]{
                passeio.getPlaca(),
                passeio.getMarca(),
                passeio.getModelo(),
                passeio.getCor(),
                passeio.getQtdRodas(),
                passeio.getVelocMax(),
                passeio.getQtdPist(),
                passeio.getPotencia(),
                passeio.getQtdPassageiros()
            });
        }
    }

    private static void imprimirTodosPasseio(DefaultTableModel tableModel) {
        if (BDVeiculos.getListaPasseio().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Não há veículos para imprimir!", "Aviso", JOptionPane.WARNING_MESSAGE);
        } else {
            tableModel.setRowCount(0);

            for (Passeio passeio : BDVeiculos.getListaPasseio()) {
                System.out.println(passeio);
                tableModel.addRow(new Object[]{
                    passeio.getPlaca(),
                    passeio.getMarca(),
                    passeio.getModelo(),
                    passeio.getCor(),
                    passeio.getQtdRodas(),
                    passeio.getVelocMax(),
                    passeio.getMotor().getQtdPist(),
                    passeio.getMotor().getPotencia(),
                    passeio.getQtdPassageiros()
                });
            }
        }
    }

    private static void imprimirTodosCarga(DefaultTableModel tableModel) {
        if (BDVeiculos.getListaCarga().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Não há veículos para imprimir!", "Aviso", JOptionPane.WARNING_MESSAGE);
        } else {
            tableModel.setRowCount(0);

            for (Carga carga : BDVeiculos.getListaCarga()) {
                tableModel.addRow(new Object[]{
                    carga.getPlaca(),
                    carga.getMarca(),
                    carga.getModelo(),
                    carga.getCor(),
                    carga.getQtdRodas(),
                    carga.getVelocMax(),
                    carga.getMotor().getQtdPist(),
                    carga.getMotor().getPotencia(),
                    carga.getCargaMax(),
                    carga.getTara()
                });
            }
        }
    }

    private static void excluirTodosPasseio(JFrame frame, DefaultTableModel tableModel) {
        int confirm = JOptionPane.showConfirmDialog(frame, "Tem certeza que deseja excluir todos os veículos?", "Confirmação", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            if (BDVeiculos.getListaPasseio().isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Não há veículo para excluir", "Erro", JOptionPane.ERROR_MESSAGE);
            } else {
                BDVeiculos.clearPasseios();
                atualizarTabelaPasseio(tableModel);
                JOptionPane.showMessageDialog(frame, "Todos os veículos foram excluídos com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }

    private static void excluirTodosCarga(JFrame frame, DefaultTableModel tableModel) {
        int confirm = JOptionPane.showConfirmDialog(frame, "Tem certeza que deseja excluir todos os veículos?", "Confirmação", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            if (BDVeiculos.getListaCarga().isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Não há veículo para excluir", "Erro", JOptionPane.ERROR_MESSAGE);
            } else {
                BDVeiculos.clearCargas();
                atualizarTabelaPasseio(tableModel);
                JOptionPane.showMessageDialog(frame, "Todos os veículos foram excluídos com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            }
        }

    }

    private static void consultarExcluirPorPlacaPasseio(JFrame jfPasseio) {
        jfPasseio.dispose();

        JFrame frame = new JFrame("Consulta / Excluir por Placa");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(800, 400);
        frame.setLayout(new BorderLayout(10, 10));
        frame.setLocationRelativeTo(null);

        JPanel inputPanel = new JPanel(new GridLayout(9, 2, 10, 10));

        inputPanel.add(new JLabel("Placa:"));
        JTextField txtPlaca = new JTextField();
        inputPanel.add(txtPlaca);

        inputPanel.add(new JLabel("Marca:"));
        JTextField txtMarca = new JTextField();
        txtMarca.setEditable(false);
        inputPanel.add(txtMarca);

        inputPanel.add(new JLabel("Modelo:"));
        JTextField txtModelo = new JTextField();
        txtModelo.setEditable(false);
        inputPanel.add(txtModelo);

        inputPanel.add(new JLabel("Cor:"));
        JTextField txtCor = new JTextField();
        txtCor.setEditable(false);
        inputPanel.add(txtCor);

        inputPanel.add(new JLabel("Qtd. Rodas:"));
        JTextField txtQtdRodas = new JTextField();
        txtQtdRodas.setEditable(false);
        inputPanel.add(txtQtdRodas);

        inputPanel.add(new JLabel("Velocidade Máx.:"));
        JTextField txtVelocMax = new JTextField();
        txtVelocMax.setEditable(false);
        inputPanel.add(txtVelocMax);

        inputPanel.add(new JLabel("Qtd. Pistões:"));
        JTextField txtQtdPistoes = new JTextField();
        txtQtdPistoes.setEditable(false);
        inputPanel.add(txtQtdPistoes);

        inputPanel.add(new JLabel("Potência:"));
        JTextField txtPotencia = new JTextField();
        txtPotencia.setEditable(false);
        inputPanel.add(txtPotencia);

        inputPanel.add(new JLabel("Qtd. Passageiros:"));
        JTextField txtQtdPassageiros = new JTextField();
        txtQtdPassageiros.setEditable(false);
        inputPanel.add(txtQtdPassageiros);

        // Painel de botões
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 10));
        JButton btnConsultar = new JButton("Consultar");
        JButton btnExcluir = new JButton("Excluir");
        JButton btnSair = new JButton("Sair");

        buttonPanel.add(btnConsultar);
        buttonPanel.add(btnExcluir);
        buttonPanel.add(btnSair);

        frame.add(inputPanel, BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        btnConsultar.addActionListener(e -> {
            String placa = txtPlaca.getText().trim();
            Passeio passeio = BDVeiculos.getListaPasseio().stream()
                    .filter(p -> p.getPlaca().equalsIgnoreCase(placa))
                    .findFirst()
                    .orElse(null);

            if (passeio != null) {
                txtMarca.setText(passeio.getMarca());
                txtModelo.setText(passeio.getModelo());
                txtCor.setText(passeio.getCor());
                txtQtdRodas.setText(String.valueOf(passeio.getQtdRodas()));
                txtVelocMax.setText(String.valueOf(passeio.getVelocMax()));
                txtQtdPistoes.setText(String.valueOf(passeio.getMotor().getQtdPist()));
                txtPotencia.setText(String.valueOf(passeio.getMotor().getPotencia()));
                txtQtdPassageiros.setText(String.valueOf(passeio.getQtdPassageiros()));
                JOptionPane.showMessageDialog(frame, "Veículo encontrado!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(frame, "Veículo não encontrado.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        });

        btnExcluir.addActionListener(e -> {
            String placa = txtPlaca.getText().trim();
            boolean removido = BDVeiculos.getListaPasseio().removeIf(p -> p.getPlaca().equalsIgnoreCase(placa));

            if (removido) {
                txtPlaca.setText("");
                txtMarca.setText("");
                txtModelo.setText("");
                txtCor.setText("");
                txtQtdRodas.setText("");
                txtVelocMax.setText("");
                txtQtdPistoes.setText("");
                txtPotencia.setText("");
                txtQtdPassageiros.setText("");
                JOptionPane.showMessageDialog(frame, "Veículo excluído com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(frame, "Veículo não encontrado.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        });

        btnSair.addActionListener(e -> {
            frame.dispose();
            jfPasseio.setVisible(true);
        });

        frame.setVisible(true);
    }

    private static void consultarExcluirPorPlacaCarga(JFrame jfCarga) {
        jfCarga.dispose();

        JFrame frame = new JFrame("Consulta / Excluir por Placa");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(800, 400);
        frame.setLayout(new BorderLayout(10, 10));
        frame.setLocationRelativeTo(null);

        JPanel inputPanel = new JPanel(new GridLayout(10, 2, 10, 10));

        inputPanel.add(new JLabel("Placa:"));
        JTextField txtPlaca = new JTextField();
        inputPanel.add(txtPlaca);

        inputPanel.add(new JLabel("Marca:"));
        JTextField txtMarca = new JTextField();
        txtMarca.setEditable(false);
        inputPanel.add(txtMarca);

        inputPanel.add(new JLabel("Modelo:"));
        JTextField txtModelo = new JTextField();
        txtModelo.setEditable(false);
        inputPanel.add(txtModelo);

        inputPanel.add(new JLabel("Cor:"));
        JTextField txtCor = new JTextField();
        txtCor.setEditable(false);
        inputPanel.add(txtCor);

        inputPanel.add(new JLabel("Qtd. Rodas:"));
        JTextField txtQtdRodas = new JTextField();
        txtQtdRodas.setEditable(false);
        inputPanel.add(txtQtdRodas);

        inputPanel.add(new JLabel("Velocidade Máx.:"));
        JTextField txtVelocMax = new JTextField();
        txtVelocMax.setEditable(false);
        inputPanel.add(txtVelocMax);

        inputPanel.add(new JLabel("Qtd. Pistões:"));
        JTextField txtQtdPistoes = new JTextField();
        txtQtdPistoes.setEditable(false);
        inputPanel.add(txtQtdPistoes);

        inputPanel.add(new JLabel("Potência:"));
        JTextField txtPotencia = new JTextField();
        txtPotencia.setEditable(false);
        inputPanel.add(txtPotencia);

        inputPanel.add(new JLabel("Carga maxima:"));
        JTextField txtCargaMax = new JTextField();
        txtCargaMax.setEditable(false);
        inputPanel.add(txtCargaMax);

        inputPanel.add(new JLabel("Tara:"));
        JTextField txtTara = new JTextField();
        txtTara.setEditable(false);
        inputPanel.add(txtTara);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 10));
        JButton btnConsultar = new JButton("Consultar");
        JButton btnExcluir = new JButton("Excluir");
        JButton btnSair = new JButton("Sair");

        buttonPanel.add(btnConsultar);
        buttonPanel.add(btnExcluir);
        buttonPanel.add(btnSair);

        frame.add(inputPanel, BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        btnConsultar.addActionListener(e -> {
            String placa = txtPlaca.getText().trim();
            Carga carga = BDVeiculos.getListaCarga().stream()
                    .filter(p -> p.getPlaca().equalsIgnoreCase(placa))
                    .findFirst()
                    .orElse(null);

            if (carga != null) {
                txtMarca.setText(carga.getMarca());
                txtModelo.setText(carga.getModelo());
                txtCor.setText(carga.getCor());
                txtQtdRodas.setText(String.valueOf(carga.getQtdRodas()));
                txtVelocMax.setText(String.valueOf(carga.getVelocMax()));
                txtQtdPistoes.setText(String.valueOf(carga.getMotor().getQtdPist()));
                txtPotencia.setText(String.valueOf(carga.getMotor().getPotencia()));
                txtCargaMax.setText(String.valueOf(carga.getCargaMax()));
                txtTara.setText(String.valueOf(carga.getTara()));
                JOptionPane.showMessageDialog(frame, "Veículo encontrado!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(frame, "Veículo não encontrado.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        });

        btnExcluir.addActionListener(e -> {
            String placa = txtPlaca.getText().trim();
            boolean removido = BDVeiculos.getListaCarga().removeIf(p -> p.getPlaca().equalsIgnoreCase(placa));

            if (removido) {
                txtPlaca.setText("");
                txtMarca.setText("");
                txtModelo.setText("");
                txtCor.setText("");
                txtQtdRodas.setText("");
                txtVelocMax.setText("");
                txtQtdPistoes.setText("");
                txtPotencia.setText("");
                txtCargaMax.setText("");
                txtTara.setText("");
                JOptionPane.showMessageDialog(frame, "Veículo excluído com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(frame, "Veículo não encontrado.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        });

        btnSair.addActionListener(e -> {
            frame.dispose();
            jfCarga.setVisible(true);
        });

        frame.setVisible(true);
    }

    private static void atualizarTabelaCarga(DefaultTableModel tableModel) {
        tableModel.setRowCount(0);

        for (Carga carga : BDVeiculos.getListaCarga()) {
            tableModel.addRow(new Object[]{
                carga.getPlaca(),
                carga.getMarca(),
                carga.getModelo(),
                carga.getCor(),
                carga.getQtdRodas(),
                carga.getVelocMax(),
                carga.getQtdPist(),
                carga.getPotencia(),
                carga.getCargaMax(),
                carga.getTara()
            });
        }
    }

}
