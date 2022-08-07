package prova.web2.lotes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LoteFacade {
    @Autowired
    private LoteRepository repository;

    public LoteDTO criar(LoteDTO loteDTO) {
        Lote lote = new Lote();
        lote.setData(loteDTO.getData());
        lote.setObservacao(loteDTO.getObservacao());
        repository.save(lote);
        loteDTO.setId(lote.getId());
        return  loteDTO;
    }

    public LoteDTO atualizar (LoteDTO loteDTO, Long loteId) {
        Lote loteDatabase = repository.getOne(loteId);
        loteDatabase.setData(loteDTO.getData());
        loteDatabase.setObservacao(loteDTO.getObservacao());
        repository.save(loteDatabase);
        return loteDTO;
    }

    private LoteDTO converter (Lote produto) {
        LoteDTO result = new LoteDTO();
        result.setId(produto.getId());
        result.setData(produto.getData());
        result.setObservacao(produto.getObservacao());
        return result;
    }

    public List<LoteDTO> getAll () {
        return repository
                .findAll()
                .stream()
                .map(this::converter).collect(Collectors.toList());
    }

    public String delete (Long loteId) {
        repository.deleteById(loteId);
        return "DELETED";
    }

}
