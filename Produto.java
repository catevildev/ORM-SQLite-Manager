public class Produto extends SQLClass {
    @Key
    int id;

    String descricao;
    double preco;
    String un;

    Produto(){
        this.setTableName("PRODUTOS");
    }
}
