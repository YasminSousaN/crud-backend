package com.crud.controller;

import com.crud.model.Produto;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.CrossOrigin;//

@CrossOrigin(origins = "http://localhost:4200") // permite que o Angular acesse o backend

@RestController //diz que essa classe vai responder a requisições web.

@RequestMapping("/produtos") // todas as rotas dessa classe começam com /produtos
public class ProdutoController {

    // lista simulando um banco de dados
    private List<Produto> produtos = new ArrayList<>();

    // construtor: adiciona alguns produtos iniciais
    public ProdutoController() {
        produtos.add(new Produto(1, "Notebook", 3500.0));
        produtos.add(new Produto(2, "Mouse", 50.0));
        produtos.add(new Produto(3, "Teclado", 150.0));
    }

    // GET - lista todos os produtos
    // Exemplo: se acessar http://localhost:8080/produtos, vai mostrar todos os produtos no navegador.
    @GetMapping //busca produtos.
    public List<Produto> getProdutos() {
        return produtos;
    }

    // GET por ID
    @GetMapping("/{id}")
    public Produto getProdutoPorId(@PathVariable int id) {
        for (Produto p : produtos) {
            if (p.getId() == id) {  // Se achar → retorna o produto.
                return p;
            }
        }
        return null; // se não encontrar, retorna null (só pra simplificar agora)
    }

    // POST - //adiciona novo produto
    @PostMapping //cria um novo produto
    public Produto criarProduto(@RequestBody Produto novoProduto) {
        produtos.add(novoProduto);
        return novoProduto;
    }

    // PUT - atualiza um produto existente
    @PutMapping("/{id}")                                   //pega o produto enviado no corpo da requisição (JSON).
    public Produto atualizarProduto(@PathVariable int id, @RequestBody Produto produtoAtualizado) {
        for (Produto p : produtos) {
            if (p.getId() == id) {
                p.setNome(produtoAtualizado.getNome());
                p.setPreco(produtoAtualizado.getPreco());
                return p;
            }
        }
        return null;
    }

    // DELETE - remove um produto
    @DeleteMapping("/{id}")
    public String deletarProduto(@PathVariable int id) {  //@PathVariable → pega o id que vem na URL.
        produtos.removeIf(p -> p.getId() == id);
        return "Produto com ID " + id + " removido!";
    }
}
