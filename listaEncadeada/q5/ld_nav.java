//q. 5: Lista de Exercícios – Listas Encadeadas | parte 1


public class ld_nav{
    String url, titulo; 
    ld_nav prox;
    ld_nav ant;

    public ld_nav(String url, String titulo){
        this.url=url;
        this.titulo=titulo;
        this.prox=null;
        this.ant=null;
    }
}