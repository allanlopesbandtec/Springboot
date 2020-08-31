package continuada1.Produtos;

import java.util.Date;

public class Higiene extends Produto {

    //Atributos
    private Double peso;
    //private Date dataVencimento = new Date("dd/MM/yyyy");


    //Data dtaCompra,


    //Construtor
    public Higiene(Integer codigo, String nome, Double valor, Integer quantidadeProduto, String dataCompra, Double peso) {
        super(codigo, nome, valor, quantidadeProduto, dataCompra);
        this.peso = peso;
        //this.dtaVencimento = dtaVencimento;
    }

    //Métodos
    @Override
    public Double subTotal() {
        return getQuantidadeProduto() * getValor();
    }

    //Getters
    public Double getPeso() {
        return peso;
    }

//    public Date getDtaVencimento() {
//        return dataVencimento;
//    }
}
