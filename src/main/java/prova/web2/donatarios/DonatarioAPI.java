package prova.web2.donatarios;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(value = "/donatarios", produces = MediaType.APPLICATION_JSON_VALUE)
public class DonatarioAPI {
    @Autowired
    private DonatarioFacade donatarioFacade;

    @PostMapping
    @ResponseBody
    public DonatarioDTO criar(@RequestBody DonatarioDTO donatarioDTO) {
        return donatarioFacade.criar(donatarioDTO);
    }

    @PutMapping("/{produtoId}")
    @ResponseBody
    public DonatarioDTO atualizar(@PathVariable("donatarioId") Long donatarioId,
                                @RequestBody DonatarioDTO donatarioDTO) {
        return donatarioFacade.atualizar(donatarioDTO, donatarioId);
    }

    @GetMapping
    @ResponseBody
    public List<DonatarioDTO> getAll() {
        return donatarioFacade.getAll();
    }

    @DeleteMapping("/{donatarioId}")
    @ResponseBody
    public String deletar(@PathVariable("donatarioId") Long donatarioId) {
        return donatarioFacade.delete(donatarioId);
    }
}
