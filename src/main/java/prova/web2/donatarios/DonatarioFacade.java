package prova.web2.donatarios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DonatarioFacade {
    @Autowired
    private DonatarioRepository repository;

    public DonatarioDTO criar(DonatarioDTO donatarioDTO) {
        Donatario donatario = new Donatario();
        donatario.setNome(donatarioDTO.getNome());
        donatario.setEndereco(donatarioDTO.getEndereco());
        donatario.setTelefone(donatarioDTO.getTelefone());
        donatario.setHorario(donatarioDTO.getHorario());
        donatario.setDescricao(donatarioDTO.getDescricao());
        repository.save(donatario);
        donatarioDTO.setId(donatario.getId());
        return  donatarioDTO;
    }

    public DonatarioDTO atualizar (DonatarioDTO donatarioDTO, Long donatarioId) {
        Donatario donatarioDatabase = repository.getOne(donatarioId);
        donatarioDatabase.setNome(donatarioDTO.getNome());
        donatarioDatabase.setEndereco(donatarioDTO.getEndereco());
        donatarioDatabase.setTelefone(donatarioDTO.getTelefone());
        donatarioDatabase.setHorario(donatarioDTO.getHorario());
        donatarioDatabase.setDescricao(donatarioDTO.getDescricao());
        repository.save(donatarioDatabase);
        return donatarioDTO;
    }

    private DonatarioDTO converter (Donatario donatario) {
        DonatarioDTO result = new DonatarioDTO();
        result.setId(donatario.getId());
        result.setNome(donatario.getNome());
        result.setEndereco(donatario.getEndereco());
        result.setTelefone(donatario.getTelefone());
        result.setHorario(donatario.getHorario());
        result.setDescricao(donatario.getDescricao());
        return result;
    }

    public List<DonatarioDTO> getAll () {
        return repository
                .findAll()
                .stream()
                .map(this::converter).collect(Collectors.toList());
    }

    public String delete (Long donatarioId) {
        repository.deleteById(donatarioId);
        return "DELETED";
    }

}
