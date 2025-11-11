//porta de entrada. recebe os dados e manda pra service fazer a logicaa
// recebe oq o usuario esta pedindo
// Recebe os pedidos (requisições) e responde
package com.crud.controller;

import com.crud.model.Produto;
import com.crud.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
    }

    // GET - buscar por ID
    @GetMapping("/id/{id}")
    public Produto getProdutoPorId(@PathVariable int id) {
        return produtoService.buscarPorId(id);
    }

    // POST - criar novo
    @PostMapping
    public Produto criarProduto(@RequestBody Produto novoProduto) {
        return produtoService.adicionar(novoProduto);
    }

    // PUT - atualizar
    @PutMapping("/{id}")
    public Produto atualizarProduto(@PathVariable int id, @RequestBody Produto produtoAtualizado) {
        return produtoService.atualizar(id, produtoAtualizado);
    }

    //  DELETE - remover
    @DeleteMapping("/{id}")
    public String deletarProduto(@PathVariable int id) {
        return produtoService.deletar(id);
    }

    // fazer um endepoint get que vai receber um parametor chamado nome que ele vai
    // buscar na lista de produtos aquele q tem o nome
    @GetMapping("/nome/{nome}")
    public Produto getProdutoPorNome(@PathVariable String nome) {
        return produtoService.buscarPorNome(nome);
    }


}
