package prova.web2.lotes;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(value = "/lotes", produces = MediaType.APPLICATION_JSON_VALUE)
public class LoteAPI {
    @Autowired
    private LoteFacade loteFacade;

    @PostMapping
    @ResponseBody
    public LoteDTO criar(@RequestBody LoteDTO loteDTO) {
        return loteFacade.criar(loteDTO);
    }

    @PutMapping("/{loteId}")
    @ResponseBody
    public LoteDTO atualizar(@PathVariable("loteId") Long loteId,
                                @RequestBody LoteDTO loteDTO) {
        return loteFacade.atualizar(loteDTO, loteId);
    }

    @GetMapping
    @ResponseBody
    public List<LoteDTO> getAll() {
        return loteFacade.getAll();
    }

    @DeleteMapping("/{loteId}")
    @ResponseBody
    public String deletar(@PathVariable("loteId") Long loteId) {
        return loteFacade.delete(loteId);
    }
}
