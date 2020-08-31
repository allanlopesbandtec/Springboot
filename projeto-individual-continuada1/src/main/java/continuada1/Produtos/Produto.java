package continuada1.Produtos;



import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class Produto {

    //Atributos
    private Integer codigo;
    private String nome;
    private Double valor;
    private Integer quantidadeProduto;
    private Date data = new Date();
    SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");

    private String dataCompra = formatador.format(data);


    //Construtor
    public Produto(Integer codigo, String nome, Double valor, Integer quantidadeProduto, String dataCompra) {
        this.codigo = codigo;
        this.nome = nome;
        this.valor = valor;
        this.quantidadeProduto = quantidadeProduto;
        this.dataCompra = dataCompra;
    }

    //Métodos
    public abstract Double subTotal();

    //Getters
    public Integer getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public Double getValor() {
        return valor;
    }

    public Integer getQuantidadeProduto() {
        return quantidadeProduto;
    }

    public String getDataCompra() {
        return dataCompra;
    }



    //ToString
    @Override
    public String toString() {
        return "Produto" +
                "\nCodigo: " + codigo +
                "\nNome: " + nome +
                "\nValor: " + valor +
                "\nQuantidade produto: " + quantidadeProduto +
                "\n Subtotal do produto: " + subTotal();
                //"\nData compra: " + dtaCompra;
    }
}
