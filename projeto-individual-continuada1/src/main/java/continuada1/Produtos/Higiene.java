package continuada1.Produtos;

import java.util.Date;

public class Higiene extends Produto {

    //Atributos




    //Construtor

    public Higiene(Integer codigo, String nome, Double valor, Integer quantidadeProduto, Double peso, Date dataCompra, Date dataVencimento) {
        super(codigo, nome, valor, quantidadeProduto, peso, dataCompra, dataVencimento);
    }

    //Métodos
    @Override
    public Double getSubTotal() {
        return getQuantidadeProduto() * getValor();
    }

}
