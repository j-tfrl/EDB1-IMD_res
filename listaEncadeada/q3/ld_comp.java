public class ld_comp{
    String nome;
    int qtd;
    double preco;
    ld_comp prox;
    ld_comp ant;

    public ld_comp(String nome, int qtd, double preco){
    this.nome=nome;
    this.qtd=qtd;
    this.preco=preco;
    this.prox=null;
    this.ant=null; 
    
    }
}
