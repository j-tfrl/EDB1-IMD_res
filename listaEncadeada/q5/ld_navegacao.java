//q. 5: Lista de Exercícios – Listas Encadeadas | parte 2

import java.util.Scanner;

public class ld_navegacao{
    ld_nav begin;
    ld_nav tail;

    public ld_navegacao(){
        this.begin=null;
        this.tail=null;
    }


    public void insPag(String url, String titulo){
        ld_nav p=new ld_nav(url, titulo);

        if(begin==null){
            begin=p;
            tail=p;
            p.prox=null;
            p.ant=null;
        }else{
            tail.prox=p;
            p.ant=tail;
            tail=p;
            p.prox=null;
        }
    }


    public boolean removerPag(String url, String titulo){
        ld_nav atual=begin;
        ld_nav ant=null;

        while(atual!=null){
            if(atual.url.equals(url) && atual.titulo.equals(titulo)){
                if(ant==null){
                    begin=atual.prox;
                    if(begin!=null){
                        begin.ant=null;
                    }
                }else{
                    ant.prox=atual.prox;
                }

                if(atual.prox!=null){
                    atual.prox.ant=ant;
                }
                System.out.println("Página removida\n.");

                return true;
            }
            ant=atual;
            atual=atual.prox;

        }
        System.out.println("Página não removida. Tente novamente.\n");
        return false;



    }


    public void browse(){
        if(begin==null){
            System.out.println("Não foram inserida(s) página(s)\n");
            return;
        }

        ld_nav current=begin;
        Scanner sb=new Scanner(System.in);
        int opt=0;

        do{
            System.out.println("\n--- Página Atual ---");
            System.out.println("Título: " + current.titulo);
            System.out.println("Link: " + current.url);
            System.out.println("------------------");

            System.out.println("\nNavegação:");
            System.out.println("1. Próximo item");
            System.out.println("2. Item anterior");
            System.out.println("3. Voltar ao menu principal");
            System.out.print("Escolha: ");
            
            opt = sb.nextInt();
            switch (opt) {
                case 1:{
                    if(current.prox!=null){
                        current=current.prox;
                    }else{
                        System.out.println("Fim da lista de páginas.\n");
                    }
                    
                    break;

                }

                case 2:{
                    if(current.ant!=null){
                        current=current.ant;
                    }else{
                        System.out.println("Início da lista alcançado.\n");
                    }

                    break;

                }

                case 3:{

                    System.out.println("Retomando ao menu...\n");
                    break;

                }


            
                default: System.out.println("Opção inválida.\n");
            }
            

        }while(opt!=3);
    }


    public void exibirPagFull(){
        ld_nav atual=begin;

       System.out.println("\nPáginas inseridas: \n");
       System.out.print("TITULO"+"     "+"URL"+"\n");
       System.out.println("______.________._______________"+"\n");
       while(atual!=null){
        System.out.println(atual.titulo+"     "+atual.url+"\n");
        atual=atual.prox;
       }
    }

    public static void main(String[] args){
        int option=0;
        ld_navegacao fullPag=new ld_navegacao();

        boolean running=true;
        Scanner s=new Scanner(System.in);

        while(running){
            System.out.println("\n Menu: \n");
            System.out.println("1 - Adicionar página; \n2 - Remover página;\n"+
                "3 - Navegar entre as páginas; \n 4 - Ver todos os páginas \n 5 - Sair do programa");
            System.out.println("\n\n Insira a opção desejada: ");
            option=s.nextInt();

            boolean u_opt=false; 


            if(option < 1 || option > 5){
                System.err.println("Digite um número válido");
            }else{
                u_opt=true;
            }  

            if(u_opt){
                switch(option){
                    case 1:{
                        System.out.println("Insira o título da página: \n");
                        String titulo=s.next();

                        System.out.println("Insira o link da página: \n"); 
                        String url=s.next();

                        fullPag.insPag(url, titulo);
                        break;

                    }
                    case 2:{

                        System.out.println("Insira o título da página: \n");
                        String titulo=s.next();

                        System.out.println("Insira o link da página: \n"); 
                        String url=s.next();

                        fullPag.removerPag(url, titulo);

                        break;
                    }
                    case 3:{
                        fullPag.browse();
                        break;
                    }
                    case 4:{
                        fullPag.exibirPagFull();
                        break;
                    }
                    case 5:{

                         running=false;
                        System.out.println("Saindo do programa...\n");
                        break;
                    }
                    default: break;
                }
            }else{
                System.err.println("Insira uma opção válida.\n");
            }
            
        }

        s.close();
    }
    
}
