package prova.web2.fiscalizadores;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(value = "/fiscalizadores", produces = MediaType.APPLICATION_JSON_VALUE)
public class FiscalizadorAPI {
    @Autowired
    private FiscalizadorFacade fiscalizadorFacade;

    @PostMapping
    @ResponseBody
    public FiscalizadorDTO criar(@RequestBody FiscalizadorDTO fiscalizadoDTO) {
        return fiscalizadorFacade.criar(fiscalizadoDTO);
    }

    @PutMapping("/{fiscalizadorId}")
    @ResponseBody
    public FiscalizadorDTO atualizar(@PathVariable("fiscalizadorId") Long fiscalizadorId,
                                @RequestBody FiscalizadorDTO fiscalizadorDTO) {
        return fiscalizadorFacade.atualizar(fiscalizadorDTO, fiscalizadorId);
    }

    @GetMapping
    @ResponseBody
    public List<FiscalizadorDTO> getAll() {
        return fiscalizadorFacade.getAll();
    }

    @DeleteMapping("/{fiscalizadorId}")
    @ResponseBody
    public String deletar(@PathVariable("fiscalizadorId") Long fiscalizadorId) {
        return fiscalizadorFacade.delete(fiscalizadorId);
    }
}
