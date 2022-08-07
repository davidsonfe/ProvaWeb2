package prova.web2.produtos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProdutoFacade {
    @Autowired
    private ProdutoRepository repository;

    public ProdutoDTO criar(ProdutoDTO produtoDTO) {
        Produto produto = new Produto();
        produto.setDescricao(produtoDTO.getDescricao());
        produto.setNome(produtoDTO.getNome());
        repository.save(produto);
        produtoDTO.setId(produto.getId());
        return  produtoDTO;
    }

    public ProdutoDTO atualizar (ProdutoDTO produtoDTO, Long produtoId) {
        Produto produtoDatabase = repository.getOne(produtoId);
        produtoDatabase.setNome(produtoDTO.getNome());
        produtoDatabase.setDescricao(produtoDTO.getDescricao());
        repository.save(produtoDatabase);
        return produtoDTO;
    }

    private ProdutoDTO converter (Produto produto) {
        ProdutoDTO result = new ProdutoDTO();
        result.setId(produto.getId());
        result.setNome(produto.getNome());
        result.setDescricao(produto.getDescricao());
        return result;
    }

    public List<ProdutoDTO> getAll () {
        return repository
                .findAll()
                .stream()
                .map(this::converter).collect(Collectors.toList());
    }

    public String delete (Long produtoId) {
        repository.deleteById(produtoId);
        return "DELETED";
    }

}
