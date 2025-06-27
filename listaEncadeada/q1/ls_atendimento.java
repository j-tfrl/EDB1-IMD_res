//q. 1: Lista de Exercícios – Listas Encadeadas | parte 2

import java.util.Scanner;

public class ls_atendimento{
    private ls_atNo inicio;
    private ls_atNo fim; //inicio e fim da fila


    //fila
    public void inLine(int senha, int idade, int arrival, String nome){
        ls_atNo novo_no= new ls_atNo(senha, idade, arrival, nome);


        if(inicio==null){
            inicio=novo_no;
            fim=novo_no; //fila com uma só pessoa
        }else{
            if(idade>=60){
                //encontra o paciente que tem prioridade para inserir pessoas depois dela
                ls_atNo atual=inicio;
                ls_atNo anterior=null;

            while(atual!=null && atual.idade>=60){
                //idade toma o dado sobre um novo paciente
                anterior=atual;
                atual=atual.prox;
            }

            if(anterior==null){
                novo_no.prox=inicio; //paciente anterior vai ser o começo da fila
                inicio=novo_no;
            }else{
                //insere mais algum paciente com prioridade
                anterior.prox=novo_no;
                novo_no.prox=atual;
            }

                if(novo_no.prox==null){
                    fim=novo_no;
                }
            }else{
                ls_atNo atual=inicio;
                ls_atNo anterior=null;

                while (atual!=null && atual.idade>=60){
                    anterior=atual;
                    atual=atual.prox;
                }

                while (atual != null && atual.arrival < arrival) { //posiciona com ordem de chegada
                anterior = atual;
                atual = atual.prox;
                  }   

                  if(anterior==null){
                    novo_no.prox=inicio;
                    inicio=novo_no;
                  }
                  else{
                    anterior.prox=novo_no;
                    novo_no.prox=atual;
                  }

                  if(novo_no.prox==null) fim=novo_no;

                //pacientes sem prioridade vão para o fim
            }
        }
    }

    public void chamarProximo(){
        if(inicio==null){
            System.out.println("Nenhum paciente na fila.");
            return;
        }

        ls_atNo proximo=inicio;
        inicio=inicio.prox; //remove o primeiro da fila

        System.out.println("Chamando paciente: " + proximo.nome + " (Senha: " + proximo.senha + ")");
    }

    
    public void restoFila(){
        ls_atNo atual=inicio;
        System.out.println("Próximos: \n");
        while(atual!=null){
           System.out.println(atual.nome+" "+atual.senha+"\n");
           atual=atual.prox;
        }

    }


    public static void main(String[] args){
        int option=0;
        ls_atendimento fila=new ls_atendimento(); //representa todo o conj. de pacientes
        boolean running=true;
         Scanner s=new Scanner(System.in);
        while(running){
          
            System.out.println("\n Menu: \n");
            System.out.println("1 - Inserir paciente; \n 2 - Chamar próximo paciente; \n"+
                "3 - Listar pacientes em fila; \n 4 - Sair do programa");
            System.out.println("\n\n Insira a opção desejada: ");
            option=s.nextInt();

            boolean u_opt=false;

            if(option < 1 || option > 3){
                System.err.println("Digite um número válido");
            }else{
                u_opt=true;
            }


            if(u_opt){
                
                switch (option) {
                    case 1: {
                        
                        System.out.println("\nInsira a idade: ");
                        int idade=s.nextInt();

                        System.out.println("\nInsira a senha: ");
                        int senha=s.nextInt();

                        System.out.println("\n Insira o número na fila (ordem de chegada): ");
                        int arrival=s.nextInt();

                        System.out.println("\n Insira o nome do paciente: ");
                        String nome=s.next();

                       // fila.inFim(senha, idade, arrival, nome); 
                        fila.inLine(senha, idade, arrival, nome);

                        break;

                    }
                        
                case 2: {
                fila.chamarProximo();
                break;
                }
                    
                case 3: {
                fila.restoFila();
                break;    
                }

                case 4: {
                running=false;
                System.out.println("Saindo do programa...");
                break;    
                }
                    default: { break; }
                }

        }else{
        System.err.println("Insira uma opção válida.\n");
        }
    }
     s.close();
   
    }
}

