public class lc_play{
    String nome;
    String formatTime;
    int temp_s;
    lc_play prox;
    lc_play ant;

    lc_play(String nome){
        this.nome=nome;

        this.prox=null;
        this.ant=null; 
    }


}