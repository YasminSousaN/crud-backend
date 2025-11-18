//a controller apenas chama os métodos do service, e o service cuida da lógica.
package com.crud.service;

import com.crud.entity.Produto;
import com.crud.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service // Indica que essa classe é responsável pela lógica do sistema (regras de negócio)
public class ProdutoService {

    @Autowired  //cria um objeto dessa classe (ProdutoRepository) e coloca aqui dentro pra eu usar
    private ProdutoRepository repository;

    private List<Produto> produtos = new ArrayList<>();

    // GET - listar todos
    public List<Produto> listarTodos() {
        return repository.findAll();
    }

    // GET - buscar por ID
    public Produto buscarPorId(Integer id) {
        return repository.findById(id).orElse(null);
    }


    public Produto buscarPorNome(String nome) {
        List<Produto> produtos = repository.findByNome(nome);
        if (produtos.isEmpty()) {
            return null; // nenhum produto encontrado
        }
        return produtos.get(0); // retorna o primeiro produto da lista
    }




    // POST - adicionar novo
    public Produto adicionar(Produto produto) {
        return repository.save(produto);
    }


    // DELETE - remover
    public String deletar(Integer id) {
        Optional<Produto> produtoOpt = repository.findById(id);

        if (produtoOpt.isPresent()) {
            Produto produto = produtoOpt.get(); // pega o Produto do Optional
            repository.delete(produto);         // deleta
            return "DELETADO COM SUCESSO";
        } else {
            return "NÃO DELETADO";              // caso não exista
        }
    }
}




