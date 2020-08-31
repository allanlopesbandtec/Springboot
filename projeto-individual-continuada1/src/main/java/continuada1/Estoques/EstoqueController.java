package continuada1.Estoques;
import continuada1.Produtos.Higiene;
import continuada1.Produtos.Produto;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/estoque")
public class EstoqueController {

    private List<Produto> listaProdutos = new ArrayList<>();
    //private String msg = "";


    @PostMapping("/adicionar")
    public void adicionarProdutos(@RequestBody Higiene higiene){
        listaProdutos.add(higiene);
    }


    @GetMapping("/exibeProduto")
    public List<Produto> exibeProduto(){
            return listaProdutos;
    }

    @DeleteMapping("/deletarProduto/{id}")
    public void deletarProduto(@PathVariable Integer id){
        listaProdutos.remove(id -1);
    }

    @PutMapping("/editarProduto/{id}")
    public void editarProduto(@PathVariable Integer id, @RequestBody Higiene higiene){
        listaProdutos.remove(id -1);
        listaProdutos.add(id -1, higiene);
    }

    @GetMapping("/gastoGeral")
    public Double gastoGeral(){

        Double gastoGeral = 0.0;

        for (Produto produto : listaProdutos){
            gastoGeral += produto.subTotal();
        }

        return gastoGeral;
    }



//
//    //Método de exibição
//    @GetMapping("/exibe")
//    public String exibeIndividualmente() {
//        if (listaProdutos.isEmpty()){
//            //Se tiver vendo não me julgue
//            msg = "A lista está vazia.";
//        }
//
//        else{
//            msg = "Oi";
//        }
//
//        return msg;
//    }

}
