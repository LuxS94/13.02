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
    public Dipendente findByUsername(String username) {
        return this.ds.findByUsername(username);
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
    public Dipendente findByUsernameAndUpdate(String username, DipendenteDTO payload) {
        return this.findByUsernameAndUpdate(username, payload);
    }//http://localhost:3001/dipendente/{username}


    @DeleteMapping("/{username}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteByUsername(String username) {
        this.ds.DeleteByUsername(username);
    }//http://localhost:3001/dipendente/{username}
}
