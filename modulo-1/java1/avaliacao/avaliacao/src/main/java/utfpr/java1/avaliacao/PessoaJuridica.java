// @author Ivanildo Silvestre da Silva Neto
package utfpr.java1.avaliacao;

public final class PessoaJuridica extends ClienteBanco {

    private int cnpj;
    private PessoaFisica responsavel;

    public int getCnpj() {
        return cnpj;
    }

    public void setCnpj(int cnpj) {
        this.cnpj = cnpj;
    }

    public PessoaFisica getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String nome, int cpf) {
        PessoaFisica responsavel = new PessoaFisica();
        responsavel.setCpf(cpf);
        responsavel.setNome(nome);
        
        this.responsavel = responsavel;
    }

    @Override
    public void verifDoc() {
        if (getResponsavel().getNome().length() > 30) {
            System.out.println("Nome inválido para Responsável");
        } else {
            System.out.println("Nome válido para Responsável");
        }
    }

    public void imprimirDadosPessoaJuridica() {
        System.out.println("Numero da conta: " + getNumeroConta());

        validar();

        System.out.println("CNPJ: " + getCnpj());
        System.out.println("Rua: " + getEnder().getRua());
    }

    public void imprimirDadosResponsavel() {
        System.out.println("CPF responsavel: " + getResponsavel().getCpf());
        getResponsavel().verifDoc();
        System.out.println("Nome responsavel: " + getResponsavel().getNome());
        verifDoc();
    }

}
