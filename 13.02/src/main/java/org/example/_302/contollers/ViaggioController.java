package org.example._302.contollers;

import org.example._302.DTO.ViaggioDTO;
import org.example._302.entities.Stato;
import org.example._302.entities.Viaggio;
import org.example._302.excepitions.ValidationException;
import org.example._302.services.ViaggioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/viaggio")
public class ViaggioController {
    private final ViaggioService vs;

    @Autowired
    public ViaggioController(ViaggioService vs) {
        this.vs = vs;
    }

    @GetMapping
    public List<Viaggio> findAll() {
        return this.vs.findAll();
    }//http://localhost:3001/viaggio

    @GetMapping("/{id}")
    public Viaggio findById(@PathVariable String id) {
        return this.vs.findById(id);
    }//http://localhost:3001/viaggio/{id}

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Viaggio saveV(@RequestBody @Validated ViaggioDTO payload, BindingResult validationResult) {
        if (validationResult.hasErrors()) {
            List<String> errorsList = validationResult.getFieldErrors()
                    .stream()
                    .map(fieldError -> fieldError.getDefaultMessage())
                    .toList();
            throw new ValidationException(errorsList);
        } else {
            return this.vs.saveV(payload);
        }
    }//http://localhost:3001/viaggio


    @PutMapping("/{id}")
    public Viaggio getByIdAndUpdate(@PathVariable String id, @RequestBody @Validated ViaggioDTO payload) {
        return this.vs.findByIdAndUpdate(id, payload);
    }//http://localhost:3001/viaggio/{id}

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable String id) {
        this.vs.deleteById(id);
    }//http://localhost:3001/viaggio/{id}

    @PutMapping("/{id}/stato")
    public Viaggio setStatoById(@PathVariable String id, Stato stato) {
        return this.vs.setStato(id, stato);
    }//http://localhost:3001/viaggio/{id}/stato
}
