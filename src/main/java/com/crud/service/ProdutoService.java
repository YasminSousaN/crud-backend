//a controller apenas chama os métodos do service, e o service cuida da lógica.
package com.crud.service;

import com.crud.model.Produto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service // Indica que essa classe é responsável pela lógica do sistema (regras de negócio)
public class ProdutoService {

    private List<Produto> produtos = new ArrayList<>();

    // Construtor: cria produtos iniciais
    public ProdutoService() {
        produtos.add(new Produto(1, "Notebook", 3500.0));
        produtos.add(new Produto(2, "Mouse", 50.0));
        produtos.add(new Produto(3, "Teclado", 150.0));
    }

    // GET - listar todos
    public List<Produto> listarTodos() {
        return produtos;
    }

    // GET - buscar por ID
    public Produto buscarPorId(int id) {
        return produtos.stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElse(null);
    }


    public Produto buscarPorNome(String nome) {
        return produtos.stream()
                .filter(p -> p.getNome() == nome)
                .findFirst()
                .orElse(null);
    }


    // POST - adicionar novo
    public Produto adicionar(Produto produto) {
        produtos.add(produto);
        return produto;
    }

    // PUT - atualizar
    public Produto atualizar(int id, Produto novoProduto) {
        for (Produto p : produtos) {
            if (p.getId() == id) {
                p.setNome(novoProduto.getNome());
                p.setPreco(novoProduto.getPreco());
                return p;
            }
        }
        return null;
    }

    // DELETE - remover
    public String deletar(int id) {
        boolean removido = produtos.removeIf(p -> p.getId() == id);
        if (removido) {
            return "Produto com ID " + id + " removido!";
        } else {
            return "Produto com ID " + id + " não encontrado.";
        }
    }


}

