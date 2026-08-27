package exercicios;

import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void  main(String[] args) {

        Locale.setDefault(Locale.US);

        Scanner entrada = new Scanner(System.in);

        Produto produto = new Produto();

        int opcao = -1;
        
        boolean haProduto = false;
        
        while (opcao != 0) {
            System.out.println("=== SISTEMA DA LOJA ===");
            System.out.println("1 - Cadastrar produto.");
            System.out.println("2 - Consultar produto.");
            System.out.println("3 - Verificar estoque.");
            System.out.println("4 - Vender produto.");
            System.out.println("0 - Sair.");

            System.out.print("Escolha uma opção: ");
            opcao = entrada.nextInt();
            entrada.nextLine();
                       
            switch (opcao) {
                case 1:
                    System.out.println("\n=== CADASTRO ===");

                    System.out.print("Nome do produto: ");
                    produto.nome = entrada.nextLine();

                    System.out.print("Preço: R$ ");
                    produto.preco = entrada.nextDouble();
                    
                    if(produto.preco < 0) {
                    	while(produto.preco < 0) {
                    		System.out.println("Digite um valor válido para o preço");
                    		produto.preco = entrada.nextDouble();
                    	}
                    }

                    System.out.print("Quantidade: ");
                    produto.quantidade = entrada.nextInt();
                    
                    if(produto.quantidade < 0) {
                    	while(produto.quantidade < 0) {
                    		System.out.println("Digite um valor válido para a quantidade");
                    		produto.quantidade = entrada.nextInt();
                    	}
                    }

                    System.out.println("Produto cadastrado!");

                    haProduto = true;

                break;
                
                case 2:
                    if(haProduto) {
                        System.out.println("\n=== PRODUTO ===");

                        System.out.println("Nome: " + produto.nome);
                        System.out.printf("Preço: R$ %.2f%n", produto.preco);
                        System.out.println("Quantidade: " + produto.quantidade);
                        System.out.println();
                    } else {
                        System.out.println("Não há produtos em estoque");
                        System.out.println();
                    }
                break;
                
                case 3:
                    System.out.println("\n=== SITUAÇÃO DO ESTOQUE ===");

                    if (produto.quantidade > 0) {
                        System.out.printf("Temos o produto %s, com %d unidades.%n", produto.nome, produto.quantidade);
                        System.out.println();
                        
                    } else if(!haProduto){
                    	System.out.println("Não há produto cadastrado.");
                        System.out.println();
                    } else {	
                        System.out.println("Produto sem estoque.");
                        System.out.println();
                    }
                break;
                
                case 4:
                    if(haProduto) {
                        int quantidade = produto.quantidade;
                        System.out.println();
                        System.out.println("Realizar uma venda");

                        System.out.printf("Digite quantas unidades de %s de você deseja vender: ", produto.nome.toUpperCase());
                        int venda = entrada.nextInt();

                        if (venda <= quantidade) {
                            produto.venda(venda);
                            System.out.println("Venda bem sucedida!!  ");
                            System.out.printf("Agora temos %d unidades%n", produto.quantidade);
                            System.out.println();
                        } else {
                            System.out.println("Quantidade insuficiente!");
                            System.out.println();
                        }
                    } else {
                        System.out.println("Não há produtos em estoque");
                        System.out.println();
                    }
                break;
                
                case 0:
                    System.out.println();
                    System.out.println("Sistema encerrado.");

                break;
                
                default:
                    System.out.println();
                    System.out.println("Opção inválida!");
            }
        }
        entrada.close();
    }
}