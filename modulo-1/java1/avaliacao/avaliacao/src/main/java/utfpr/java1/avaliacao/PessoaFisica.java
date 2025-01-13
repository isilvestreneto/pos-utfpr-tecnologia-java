// @author Ivanildo Silvestre da Silva Neto

package utfpr.java1.avaliacao;

public final class PessoaFisica extends ClienteBanco {
    
    private int cpf;

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    @Override
    public void verifDoc() {
        if (getCpf() >= 10 && getCpf() <= 20) {
            System.out.println("CPF válido");
        } else {
            System.out.println("CPF inválido");
        }
    }

}
