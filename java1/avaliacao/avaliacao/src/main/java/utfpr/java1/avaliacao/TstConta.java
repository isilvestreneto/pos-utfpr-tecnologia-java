// @author Ivanildo Silvestre da Silva Neto
package utfpr.java1.avaliacao;

public class TstConta {

    public static void main(String[] args) throws NumException {

        var pessoaJuridica = new PessoaJuridica();

        try {
            pessoaJuridica.setNumeroConta(10);
        } catch (NumException e) {
            e.impMsg();
        }

        pessoaJuridica.setCnpj(1);
        pessoaJuridica.setRua("Rua Tal");
        pessoaJuridica.setResponsavel("Fulana Ciclana da Silva", 15);

        pessoaJuridica.imprimirDadosPessoaJuridica();
        pessoaJuridica.imprimirDadosResponsavel();
    }
}
