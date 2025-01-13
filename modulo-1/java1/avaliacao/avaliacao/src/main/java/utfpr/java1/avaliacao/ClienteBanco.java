// @author Ivanildo Silvestre da Silva Neto
package utfpr.java1.avaliacao;

public abstract class ClienteBanco implements Verifica {

    private int numeroConta;
    private String nome;
    private Endereco ender;

    @Override
    public void validar() {
        if (getNumeroConta() % 2 == 0) {
            System.out.println("Número da conta é par");
        } else {
            System.out.println("Número da conta é ímpar");
        }
    }

    public abstract void verifDoc();

    public int getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(int numeroConta) throws NumException {
        if (numeroConta > 0) {
            this.numeroConta = numeroConta;
        } else {
            throw new NumException();
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Endereco getEnder() {
        return ender;
    }

    public void setEnder(Endereco ender) {
        this.ender = ender;
    }
    
    public void setRua(String rua) {
        var endereco = new Endereco();
        endereco.setRua(rua);
        setEnder(endereco);
    }

}
