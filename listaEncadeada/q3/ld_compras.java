//q. 3: Lista de Exercícios – Listas Encadeadas | parte 1
import java.util.Scanner;

public class ld_compras{
    ld_comp begin;
    ld_comp tail;

    public ld_compras(){
        this.begin=null;
        this.tail=null; //permitem explorar a lista
    }

    public void inserirProd(String nome, int qtd, double preco){
        ld_comp prod=new ld_comp(nome, qtd, preco);

        if(begin==tail){
            begin=tail;
            tail=prod; //o 'prod' erá o produto que começa a lista
        }else{
            tail.prox=prod;
            prod.anterior=tail;
            tail=prod; //configura os 'ponteiros'
        }
    }


    public boolean removerProd(String nome, int qtd, double preco){
        ld_comp atual=begin;
        ld_comp ant=null;

        while(atual!=null){
            if(atual.nome.equals(nome) && atual.qtd == qtd && atual.preco == preco){
                if(ant==null){
                    //item encontrado no incio da lista (rotina 1)
                    begin=atual.prox;
                    if(begin!=null){
                        begin.ant=null;
                    }
                }else{
                    ant.prox=atual.prox;
                }

                //se estiver no último nó/item
                if(atual.prox!=null){
                    atual.prox.ant=ant;
                }
                    System.out.println("Item removido com sucesso.\n");
                   return true;
            } 
        //indo ao próximo nó
        ant=atual;
        atual=atual.prox;
        }
        System.out.println("Item não removido. Tente novamente. \n");
        return false;
    }

public void browse() {
    if (begin == null) {
        System.out.println("Carrinho vazio!");
        return;
    }

    ld_comp current = begin;
    Scanner scanner = new Scanner(System.in);
    int option;
    
    do {
        // Display current item
        System.out.println("\n--- Item Atual ---");
        System.out.println("Nome: " + current.nome);
        System.out.println("Quantidade: " + current.qtd);
        System.out.println("Preço: R$" + current.preco);
        System.out.println("------------------");
        
        // Navigation menu
        System.out.println("\nNavegação:");
        System.out.println("1. Próximo item");
        System.out.println("2. Item anterior");
        System.out.println("3. Voltar ao menu principal");
        System.out.print("Escolha: ");
        
        option = scanner.nextInt();
        
        switch (option) {
            case 1:
                if (current.prox != null) {
                    current = current.prox;
                } else {
                    System.out.println("Fim da lista alcançado!");
                }
                break;
                
            case 2:
                if (current.ant != null) {
                    current = current.ant;
                } else {
                    System.out.println("Início da lista alcançado!");
                }
                break;
                
            case 3:
                System.out.println("Retornando ao menu...");
                break;
                
            default:
                System.out.println("Opção inválida!");
        }
    } while (option != 3);
}

    public void exibirCarro(){
       ld_comp atual=begin;
       System.out.println("Itens no carrinho: \n");
       while(atual!=null){
            System.out.println(atual.nome+" "+atual.qtd+" "+atual.preco+" "+"\n");
            atual=atual.prox;
       }
    }

    public static void main(String[] args){
        int option=0;
        ld_compras carrinho=new ld_compras();

        boolean running=true;
        Scanner s=new Scanner(System.in);
        while(running){
            System.out.println("\n Menu: \n");
            System.out.println("1 - Adicionar produto; \n 2 - Remover produto; \n"+
                "3 - Navegar entre os pedidos; \n 4 - Ver todos os produtos no carrinho"+
                + " \n 5 - Sair do programa");
            System.out.println("\n\n Insira a opção desejada: ");
            option=s.nextInt();

            boolean u_opt=false;

            if(option < 1 || option > 3){
                System.err.println("Digite um número válido");
            }else{
                u_opt=true;
            }        
            
            if(u_opt){
                switch(option){
                    case 1{

                        System.out.println("\nInsira o nome do produto: ");
                        String nome=s.nextLine();

                        System.out.println("\nInsira a quantidade: ");
                        int qtd=s.nextInt();

                        System.out.println("\n Insira o valor do produto: ");
                        double preco=s.nextDouble();

                        carrinho.inserirProd(nome, qtd, preco);

                        break;
                    }

                    case 2:{
                         System.out.println("\nInsira o nome do produto: ");
                        String nome=s.nextLine();

                        System.out.println("\nInsira a quantidade: ");
                        int qtd=s.nextInt();

                        System.out.println("\n Insira o valor do produto: ");
                        double preco=s.nextDouble();

                        carrinho.removerProd(nome, qtd, preco);

                    }




                }
            }
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            }





    }
}
