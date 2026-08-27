package exercicios;


public class Produto {
    String nome;
    double preco;
    int quantidade;
    
    public void venda(int quantidade) {
    	this.quantidade -= quantidade;
    }
   
}