package continuada1.Produtos;



import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class Produto {

    //Atributos
    private Integer codigo;
    private String nome;
    private Double valor;
    private Integer quantidadeProduto;
    private Double peso;
    private Date dataCompra;
    private Date dataVencimento;

    //Construtor
    public Produto(Integer codigo, String nome, Double valor, Integer quantidadeProduto, Double peso, Date dataCompra, Date dataVencimento) {
        this.codigo = codigo;
        this.nome = nome;
        this.valor = valor;
        this.quantidadeProduto = quantidadeProduto;
        this.peso = peso;
        this.dataCompra = dataCompra;
        this.dataVencimento = dataVencimento;
    }

    //Métodos
    public abstract Double getSubTotal();

    //Getters


    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Integer getQuantidadeProduto() {
        return quantidadeProduto;
    }

    public void setQuantidadeProduto(Integer quantidadeProduto) {
        this.quantidadeProduto = quantidadeProduto;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public Date getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(Date dataCompra) {
        this.dataCompra = dataCompra;
    }

    public Date getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(Date dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    //ToString
    @Override
    public String toString() {
        return "Produto" +
                "\nCodigo: " + codigo +
                "\nNome: " + nome +
                "\nValor: " + valor +
                "\nQuantidade produto: " + quantidadeProduto +
                "\nSubtotal do produto: " + getSubTotal();
                //"\nData compra: " + dataCompra;
    }
}
