package continuada1.Estoques;
import continuada1.Produtos.Alimento;
import continuada1.Produtos.Higiene;
import continuada1.Produtos.Produto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/estoques")
public class EstoqueController {

    private List<Produto> listaProdutos = new ArrayList<>();
    private List<Produto> historico = new ArrayList<>();

    @PostMapping("/higiene")
    public ResponseEntity adicionarProdutos(@RequestBody Higiene higiene) {
        listaProdutos.add(higiene);
        return ResponseEntity.status(201).build();
    }

    @PostMapping("/alimento")
    public ResponseEntity adicionarProdutos(@RequestBody Alimento alimento) {
        listaProdutos.add(alimento);
        return ResponseEntity.status(201).build();
    }

    @GetMapping
    public ResponseEntity exibeProduto() {
        if (listaProdutos.isEmpty()){
            return ResponseEntity.status(204).build();
        } else {
            return ResponseEntity.status(200).body(listaProdutos);
        }
    }

    @PutMapping("/editar/higiene/{id}")
    public ResponseEntity editarProduto(@PathVariable Integer id, @RequestBody Higiene higiene) {
        if (listaProdutos.size() >= id){
            listaProdutos.remove(id - 1);
            listaProdutos.add(id - 1, higiene);
            return ResponseEntity.status(200).build();
        } else{
            return ResponseEntity.status(404).build();
        }
    }

    @PutMapping("/alimento/{id}")
    public ResponseEntity editarProduto(@PathVariable Integer id, @RequestBody Alimento alimento) {
        if (listaProdutos.size() >= id){
            listaProdutos.remove(id - 1);
            listaProdutos.add(id - 1, alimento);
            return ResponseEntity.status(200).build();
        } else{
            return ResponseEntity.status(404).build();
        }
    }

    @GetMapping("/gastogeral")
    public ResponseEntity gastoGeral() {

        if (listaProdutos.isEmpty()){
            return ResponseEntity.status(204).build();
        } else {
            Double gastoGeral = 0.0;

            for (Produto produto : listaProdutos) {
                gastoGeral += produto.getSubTotal();
            }

            return ResponseEntity.status(200).body(gastoGeral);

        }
    }

    //Adicionar Historico
    public void adicionarHistorico(Integer id) {
        for (int cont = 0; cont < listaProdutos.size(); cont++) {

            if (cont == (id - 1)) {
                historico.add(listaProdutos.get(id - 1));
            }
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletarProduto(@PathVariable Integer id) {
        if (listaProdutos.size() >= id){
            adicionarHistorico(id);
            listaProdutos.remove(id - 1);
            return ResponseEntity.status(200).build();
        } else {
            return ResponseEntity.status(404).build();
        }
    }

    @GetMapping("/historico")
    public ResponseEntity getHistorico() {
        if (historico.isEmpty()){
            return ResponseEntity.status(204).build();
        } else {
            return ResponseEntity.status(200).body(historico);
        }
    }



    @GetMapping("/{nome}")
    public ResponseEntity exibirProdutoIndividual(@PathVariable String nome) {

        if (!listaProdutos.isEmpty()){

            for (Produto produto : listaProdutos) {
                if (produto.getNome().equals(nome)) {
                    return ResponseEntity.ok(produto);
                }
            }
        }

        return ResponseEntity.status(404).build();
    }

}