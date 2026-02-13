package org.example._302.contollers;

import org.example._302.DTO.PrenotazioniDTO;
import org.example._302.entities.Prenotazioni;
import org.example._302.excepitions.ValidationException;
import org.example._302.services.PrenotazioniService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/prenotazione")
public class PrenotazioniController {
    private final PrenotazioniService ps;

    @Autowired
    public PrenotazioniController(PrenotazioniService ps) {
        this.ps = ps;
    }

    @GetMapping
    public List<Prenotazioni> findAll() {
        return this.ps.findAll();
    }//http://localhost:3001/prenotazione


    @GetMapping("/{id}")
    public Prenotazioni findById(@PathVariable String id) {
        return this.ps.findById(id);
    }//http://localhost:3001/prenotazione/{id}


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Prenotazioni saveP(@RequestBody @Validated PrenotazioniDTO payload, BindingResult validationResult) {
        if (validationResult.hasErrors()) {
            List<String> errorsList = validationResult.getFieldErrors()
                    .stream()
                    .map(fieldError -> fieldError.getDefaultMessage())
                    .toList();
            throw new ValidationException(errorsList);
        } else {
            return this.ps.saveP(payload);
        }
    }//http://localhost:3001/prenotazione

    @PutMapping("/{id}")
    public Prenotazioni findByIdAndUpload(@PathVariable String id, PrenotazioniDTO payload) {
        return this.ps.findByIdandUpdate(id, payload);
    }//http://localhost:3001/prenotazione/{id}

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable String id) {
        this.ps.deleteById(id);
    }//http://localhost:3001/prenotazione/{id}
}
