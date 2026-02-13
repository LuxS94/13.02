package org.example._302.contollers;

import org.example._302.DTO.DipendenteDTO;
import org.example._302.entities.Dipendente;
import org.example._302.excepitions.ValidationException;
import org.example._302.services.DipendenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dipendente")
public class DipendenteController {
    private final DipendenteService ds;

    @Autowired
    public DipendenteController(DipendenteService ds) {
        this.ds = ds;
    }

    @GetMapping
    public List<Dipendente> findAll() {
        return this.ds.findAll();
    }//http://localhost:3001/dipendente


    @GetMapping("/{username}")
    public Dipendente findById(@PathVariable String username) {
        return this.ds.findById(username);
    }//http://localhost:3001/dipendente/{username}


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Dipendente saveD(@RequestBody @Validated DipendenteDTO payload, BindingResult validationResult) {
        if (validationResult.hasErrors()) {
            List<String> errorsList = validationResult.getFieldErrors()
                    .stream()
                    .map(fieldError -> fieldError.getDefaultMessage())
                    .toList();
            throw new ValidationException(errorsList);
        } else {
            return this.ds.saveD(payload);
        }
    }//http://localhost:3001/dipendente

    @PutMapping("/{username}")
    public Dipendente findByUsernaAndUpdate(@PathVariable String username, @RequestBody @Validated DipendenteDTO payload) {
        return this.ds.findByIdAndUpdate(username, payload);
    }//http://localhost:3001/dipendente/{username}


    @DeleteMapping("/{username}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable String username) {
        this.ds.DeleteById(username);
    }//http://localhost:3001/dipendente/{username}
}
