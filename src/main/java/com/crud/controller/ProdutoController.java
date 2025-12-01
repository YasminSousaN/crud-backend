//porta de entrada. recebe os dados e manda pra service fazer a logicaa
// recebe oq o usuario esta pedindo
// Recebe os pedidos (requisições) e responde
package com.crud.controller;

import com.crud.service.ProdutoService;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.crud.entity.Produto;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import org.springframework.web.bind.annotation.CrossOrigin;//

@CrossOrigin(origins = "http://localhost:4200") // permite que o Angular acesse o backend
@RestController //diz que essa classe vai responder a requisições web.
@RequestMapping("/produtos") // todas as rotas dessa classe começam com /produtos
public class ProdutoController {

    @Autowired // Injeta automaticamente a classe ProdutoService
    private ProdutoService produtoService;

    // GET - listar todos
    @GetMapping //executa este codigo quando alguem consultar esta url
         // LIST<PRODUTO>: deve retornar uma lista de objetos do tipo produto
    public List<Produto> getProdutos() {
        return produtoService.listarTodos();

        //Ele busca todos os produtos no banco de dados, e devolve a lista para o angular
    }

    // GET - buscar por ID
    @GetMapping("/id/{id}")  //{id} = valor que vem pela URL e será enviado para o método
    public Produto getProdutoPorId(@PathVariable Integer id) { //pega o número da URL e coloca na variável id
        return produtoService.buscarPorId(id);
    }

    // POST - criar novo
    @PostMapping // responde a requisicao post do frontend
    public Produto criarProduto(@RequestBody Produto novoProduto) {  //pega o json eviado e transforma em objeto produto e coloca dentro da variavel novo produti
        return produtoService.adicionar(novoProduto);
    }

    //atualizar
    @PutMapping("/{id}") //
    public ResponseEntity<Produto> atualizarProduto(@PathVariable Integer id,   //É o ID DO PRODUTO que o cliente quer atualizar
                                                    @RequestBody Produto produtoAtualizado) { //São os novos dados que o cliente quer colocar no produto

        // AQUI ESTOU PEGANDO OS DADOS QUE O USUARIO MANDOU E ESTOOU OASSANDO PRA SERVICE
        Produto atualizado = produtoService.atualizar(id, produtoAtualizado);

        // VERIFICO SE REALMENTE ATUALIZOU SE NAO ATUALIZOU FALO QUE NAO ENCONTROU O PRODUTO
        if (atualizado == null) {
            return ResponseEntity.notFound().build();
        }

        // SE ATUALIZOU O PRODUTO EU RETORNO QUE ESTA OK
        return ResponseEntity.ok(atualizado);
    }

    //  DELETE - remover
    @DeleteMapping("/{id}")                                    //()pegar o valor {id} da URL e colocá-lo na variável id.
    public ResponseEntity<String> deletarProduto(@PathVariable Long id) {//
        boolean deletado = produtoService.deletar(Math.toIntExact(id)); // esta chamndo a service para tentar deletar o produti com o id

        if (deletado) {
            return ResponseEntity.ok("DELETADO COM SUCESSO");
        } else {
            return ResponseEntity.status(404).body("NÃO DELETADO");
        }
    }


    // fazer um endepoint get que vai receber um parametor chamado nome que ele vai
    // buscar na lista de produtos aquele q tem o nome
    @GetMapping("/nome/{nome}")
    public Produto getProdutoPorNome(@PathVariable String nome) {
        return produtoService.buscarPorNome(nome);
    }


}
