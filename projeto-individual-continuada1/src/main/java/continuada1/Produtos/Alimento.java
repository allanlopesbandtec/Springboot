package continuada1.Produtos;

import java.util.Date;

public class Alimento extends Produto {

    //Atributos

    //Construtor
    public Alimento(Integer codigo, String nome, Double valor, Integer quantidadeProduto, Double peso, Date dataCompra, Date dataVencimento) {
        super(codigo, nome, valor, quantidadeProduto, peso, dataCompra, dataVencimento);
    }

    @Override
    public Double getSubTotal() {
        return ((getPeso()/10) * getValor()) + (getValor()* getQuantidadeProduto());
    }

}
