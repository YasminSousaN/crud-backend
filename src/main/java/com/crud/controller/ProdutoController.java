//porta de entrada. recebe os dados e manda pra service fazer a logicaa
// recebe oq o usuario esta pedindo
// Recebe os pedidos (requisições) e responde
package com.crud.controller;

import com.crud.entity.Produto;
import com.crud.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.web.bind.annotation.CrossOrigin;//

@CrossOrigin(origins = "http://localhost:4200") // permite que o Angular acesse o backend
@RestController //diz que essa classe vai responder a requisições web.
@RequestMapping("/produtos") // todas as rotas dessa classe começam com /produtos
public class ProdutoController {

    @Autowired // Injeta automaticamente a classe ProdutoService
    private ProdutoService produtoService;

    // GET - listar todos
    @GetMapping
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
    @PostMapping
    public Produto criarProduto(@RequestBody Produto novoProduto) {  //pega o json eviado e transforma em produto e coloca dentro da varivel novo produto
        return produtoService.adicionar(novoProduto);
    }



    //  DELETE - remover
    @DeleteMapping("/{id}")
    public String deletarProduto(@PathVariable Integer id) {
        return produtoService.deletar(id);
    }

    // fazer um endepoint get que vai receber um parametor chamado nome que ele vai
    // buscar na lista de produtos aquele q tem o nome
    @GetMapping("/nome/{nome}")
    public Produto getProdutoPorNome(@PathVariable String nome) {
        return produtoService.buscarPorNome(nome);
    }


}
