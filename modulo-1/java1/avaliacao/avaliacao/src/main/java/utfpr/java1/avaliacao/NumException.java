// @author Ivanildo Silvestre da Silva Neto

package utfpr.java1.avaliacao;

public class NumException extends Exception {
    public void impMsg() {
        System.out.println("ERRO: Não pode haver Número Negativo para conta!");
    }
}
