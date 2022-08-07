package prova.web2.fiscalizadores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FiscalizadorFacade {
    @Autowired
    private FiscalizadorRepository repository;

    public FiscalizadorDTO criar(FiscalizadorDTO fiscalizadorDTO) {
        Fiscalizador fiscalizador = new Fiscalizador();
        fiscalizador.setNome(fiscalizadorDTO.getNome());
        fiscalizador.setDescricao(fiscalizadorDTO.getDescricao());
        repository.save(fiscalizador);
        fiscalizadorDTO.setId(fiscalizador.getId());
        return  fiscalizadorDTO;
    }

    public FiscalizadorDTO atualizar (FiscalizadorDTO fiscalizadorDTO, Long fiscalizadorId) {
        Fiscalizador fiscalizadorDatabase = repository.getOne(fiscalizadorId);
        fiscalizadorDatabase.setNome(fiscalizadorDTO.getNome());
        fiscalizadorDatabase.setDescricao(fiscalizadorDTO.getDescricao());
        repository.save(fiscalizadorDatabase);
        return fiscalizadorDTO;
    }

    private FiscalizadorDTO converter (Fiscalizador fiscalizador) {
        FiscalizadorDTO result = new FiscalizadorDTO();
        result.setId(fiscalizador.getId());
        result.setNome(fiscalizador.getNome());
        result.setDescricao(fiscalizador.getDescricao());
        return result;
    }

    public List<FiscalizadorDTO> getAll () {
        return repository
                .findAll()
                .stream()
                .map(this::converter).collect(Collectors.toList());
    }

    public String delete (Long fiscalizadorId) {
        repository.deleteById(fiscalizadorId);
        return "DELETED";
    }

}
