//q. 5: Lista de Exercícios – Listas Encadeadas | parte 1

/*
 * 
 * REQUISITOS
 * 
 * Implemente uma playlist onde as músicas tocam
 *  em modo contínuo (loop infinito). Cada
música possui nome e duração. A playlist deve permitir:
a) Avançar para a próxima música.
b) Voltar para a música anterior.
c) Adicionar ou remover músicas em qualquer posição.

Tarefa: Implemente a estrutura da playlist.
Justifique qual tipo de lista é mais adequada 
(simples, dupla ou circular) e por quê.
 * 
 * 
 */

public class lc_play{
    String nome;
    String formatTime;
    int temp_s;
    lc_play prox;
    lc_play ant;

    lc_play(String nome, String ft){
        this.nome=nome;
        setempo(ft);

        this.prox=null;
        this.ant=null; 
    }

    public void setempo(String ft){
         ft = ft.trim();
    if (!ft.matches("^([0-9]|[0-5][0-9]):[0-5][0-9]$")) {
        throw new IllegalArgumentException("Formato de tempo inválido. Insira: X:YY ou XX:YY, onde X corresponde aos minutos (0-59) e Y aos segundos (00-59).\n");
    }
    String[] t = ft.split(":");
    int min = Integer.parseInt(t[0]);
    int seg = Integer.parseInt(t[1]);
        if (min < 0 || min > 59) {
            throw new IllegalArgumentException("Minutos devem estar entre 0 e 59.\n");
        }
        if (seg < 0 || seg > 59) {
            throw new IllegalArgumentException("Segundos devem estar entre 0 e 59.\n");
        }
        this.formatTime = String.format("%d:%02d", min, seg); // 
        this.temp_s = min * 60 + seg;
    
    }

    public int getTempoS(){
        return temp_s;
    }


    
}