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

    private List<Produto> produtos = new ArrayList<>();    // é um tipo de lista que guarda itens na ordem que você coloca.

    // GET - listar todos
    // Ele retorna uma lista de Produto → List<Produto>      // listarTodos- metodo do service que pegar todos os produtos do banco.
    public List<Produto> listarTodos() {
        return repository.findAll();
    }                      //Busca todos os registros da tabela produto no banco de dados.

    // GET - buscar por ID     recebe um valor id e vai procurar esse produto no banco.
    public Produto buscarPorId(Integer id) {
        return repository.findById(id).orElse(null);  // se nao achar volta null
    }


    public Produto buscarPorNome(String nome) {
        List<Produto> produtos = repository.findByNome(nome);
        if (produtos.isEmpty()) {
            return null; // nenhum produto encontrado
        }
        return produtos.get(0); // retorna o primeiro produto da lista
    }




    // POST - adicionar novo
    //        produto= aqui ele devolve um produti
    public Produto adicionar(Produto produto) { //  aqui estou passando um objeto produto para swr salvo no banco
        return repository.save(produto);
    }                     //o save ve q nao tem id, cria um novo registri no banco de dados, o banco de dados cria o id automaticamente e devolve o produto salvo



    public Produto atualizar(Integer id, Produto novoProduto) {

        // BUSCO PELO ID QUE O FRONT MANDOU PRA VE SE EXISTE NO BANCO UM PRODUTO COM ESSE ID
        Produto produtoExistente = buscarPorId(id);

        // CASO NAO TENHA NO BANCO RETORNA NULL
        if (produtoExistente == null) return null;

        // CASO RETORNE DO BANCO VAI SETAR OS NOVOS VALORES PRA ATUALIZAR NO BANCO
        produtoExistente.setNome(novoProduto.getNome());
        produtoExistente.setPreco(novoProduto.getPreco());
        produtoExistente.setBrand(novoProduto.getBrand());
        produtoExistente.setSupplier(novoProduto.getSupplier());

        // DEPOIS DE SETAR OS NOVOS VALORES EU SALVO NO BANCO DE DADOS
        return repository.save(produtoExistente);
    }


    // AQUI FICA A FUNÇÃO QUE VAI DELETAR O PRODUTO EU ESPERO UM ID QUE VEM DO FRONT
    public boolean deletar(Integer id) {
        // VERIFICA SE EXISTE NO BANCO DE DADOS O PRODUTO QUE O USUARIO PASOSU O ID
        if (repository.existsById(id)) {
            // CASO ACHE O PRODUTO ELE VAI DELETAR ELE POR ID
            repository.deleteById(id);
            return true;
        }
        // CASO NAO EXISTA O PRODUTO ELE VAI RETORNAR FALSO
        return false;
    }

}




