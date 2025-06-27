//q. 1: Lista de Exercícios – Listas Encadeadas | parte 1


public class ls_atNo{
    int senha;
    int idade;
    int arrival; //ordem de chegada
    String nome; //não relevante
    ls_atNo prox;

    ls_atNo(int senha, int idade, int arrival, String nome){
        this.senha=senha;
        this.idade=idade;
        this.arrival=arrival;
        this.nome=nome;
        this.prox=null;
    }
   

}


