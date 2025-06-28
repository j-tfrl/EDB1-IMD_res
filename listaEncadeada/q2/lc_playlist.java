//q. 5: Lista de Exercícios – Listas Encadeadas | parte 2

import java.util.Scanner;

public class lc_playlist{
    private lc_play begin;
    private lc_play tail;
    private int size;


    public lc_playlist(){
        this.begin=null;
        this.tail=null;
        this.size=0;
    }



    public void inMus(String nome, String ft, int pos){
        lc_play m=new lc_play(nome, ft);

        if(pos<0 || pos>size){
            throw new IndexOutOfBoundsException("Posição inválida: "+pos);
        }
        
        if(begin==null){
            begin=m;
            tail=m;
            tail.prox=begin;
        }else if(pos == 0){
            m.prox=begin;
            begin=m;
            tail.prox=begin;
        }else if(pos==size){
            tail.prox=m;
            tail=m;
            tail.prox=begin;

        }else{
            lc_play atual=begin;
            for(int i=0;i<pos-1;i++){
                atual=atual.prox;
            }
            m.prox=atual.prox;
            atual.prox=m;
        }
        size++;
    }

    public void rmvMus(String nome, String ft, int pos){
        lc_play atual=begin;
        lc_play ant=null;

        if(pos<0 || pos>size){
            throw new IndexOutOfBoundsException("Posição inválida: "+pos);
        }else{
            if(pos==0){
                if(size==1){
                    begin=null;
                    tail=null;
                }else{
                    begin=begin.prox;
                    tail.prox=begin;
                }
            }else{
                for(int i=0; i<pos;i++){
                    ant=atual;
                    atual=atual.prox;
                }
                ant.prox=atual.prox;
 
                if(pos==size-1){//remove o último item
                    tail=ant;
                }
            }
        }
        size--;
    }

    public void browse(Scanner sMain){

        if(begin==null){
            System.out.println("Playlist vazia. Adicione músicas para navegar!\n");
            return;
        }

        lc_play current=begin;
        int op;

        do{

            System.out.println("\n--- --- --- Música da Playlist: --- --- ");
            System.out.println("Nome: " + current.nome);
            System.out.println("Tempo: " + current.formatTime);
            System.out.println("---------------------------");

            System.out.println("\nNavegação:");
            System.out.println("1. Próximo item");
            System.out.println("2. Item anterior");
            System.out.println("3. Voltar ao menu principal");
            System.out.print("\nEscolha: ");
            try{

                    op=sMain.nextInt();
                    sMain.nextLine();

                    switch(op){
                        case 1:{
                        if (current.prox != null) {
                            current = current.prox;
                        } else {
                            System.out.println("Fim da playlist!");
                        }
                        break;
                    }
                        
                    case 2:{
                        if (current.ant != null) {
                            current = current.ant;
                        } else {
                            System.out.println("Início da playlist!");
                        }
                        break;
                    }
                        
                    case 3:{
                        System.out.println("Retornando ao menu...");
                        break;
                    }
                        
                    default:
                        System.out.println("Opção inválida!");

                    }

                }catch(Exception e){
                System.out.println("Digite apenas números de 1 a 3!");
                sMain.nextLine();  // Clear invalid input
                op = 0;
                }
        }while(op!=3);
    }


    public void exPlaylist(){
        if(begin==null){
            System.out.println("\nPlaylist vazia");
            return;
        }



        System.out.println("\n+++Playlist: ++++");
        System.out.println("Pos | MÚSICA\t\tDuração");
        lc_play atual=begin;
        int pos=0;

        do{
            System.out.printf("%3d | %-20s %s\n", 
                         pos + 1, 
                         atual.nome, 
                         atual.formatTime);
            atual=atual.prox;
            pos++;
        }while(atual!=begin && pos<size);

    }


    public int getSize(){
        return this.size; //mostra o tamanho da playlist
    }

    
    public static void main(String[] args){
        int option=0;
        lc_playlist pls=new lc_playlist();

        boolean running=true;
        Scanner s=new Scanner(System.in);
        while(running){
            System.out.println("\n Menu: \n");
            System.out.println("1 - Adicionar música; \n 2 - Remover música; \n"+
                "3 - Explorar playlist; \n 4 - Ver playlist\n 5 - Sair do programa");
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
                        System.out.println("Insira o nome da música: ");
                        s.nextLine(); //permite nome com espaço
                        String nome=s.nextLine();

                        System.out.println("Insira o tempo (minutos:segundos): ");
                        String u_ft=s.next().trim();


                        try{
                            lc_play newMus=new lc_play(nome, u_ft);
                            System.out.println("Insira a posição onde colocar: ");
                            int p=s.nextInt();

                            if(p<0||p>pls.getSize()){
                                System.err.println("Posição inválida.\n");
                                break;
                            }

                            pls.inMus(nome, newMus.formatTime, p);

                        }catch(IllegalArgumentException e){
                            System.err.println("Erro: "+e.getMessage());
                        }

                        break;
                    }
                    case 2:{ 
                         System.out.println("Insira o nome da música: ");
                         s.nextLine();
                        String nome=s.next();

                        System.out.println("Insira o tempo (minutos:segundos): ");
                        String u_ft=s.next().trim();
                        
                        try{
                            lc_play newMus=new lc_play(nome,u_ft);
                            System.out.println("Insira a posição onde colocar: ");
                            int p=s.nextInt();

                            if(p<0||p>pls.getSize()){
                                System.err.println("Posição inválida.\n");
                                break;
                            }
                            pls.inMus(nome, newMus.formatTime, p);

                        }catch(IllegalArgumentException e){
                            System.err.println("Erro: "+e.getMessage());
                        }

                        break;
                        
                        }
                    case 3:{ 
                        pls.browse(s);
                        break;}
                    case 4:{ 
                        pls.exPlaylist();
                        break;}
                    case 5:{ 
                        running=false;
                        System.out.println("Saindo do programa...");
                        break;}

                    default: break;
                }
               
            } else{
                    System.err.println("Insira uma opção válida.\n");
                }
          

        }
        s.close();

    }


}

