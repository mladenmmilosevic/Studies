package com.mladen.studies.controller;

import com.mladen.studies.dto.*;
import com.mladen.studies.entities.Predmet;
import com.mladen.studies.services.PredmetService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping(value = "/predmet")
public class PredemtController {

    private  final PredmetService predmetService;
    private  final PredmetToPredmetDTOOut predmetToPredmetDTOOut = new PredmetToPredmetDTOOut() ;
    private  final PredmetToPredmetDTO predmetToPredmetDTO= new PredmetToPredmetDTO();
    private  final StudentToStudentDTOPredmetOut studentToStudentDTOPredmetOut= new StudentToStudentDTOPredmetOut();



    public PredemtController(PredmetService predmetService) {
        this.predmetService = predmetService;
    }

    @GetMapping
    public ResponseEntity<List<PredmetDTOOut>> getAllClasses() {
        return ResponseEntity.ok(predmetToPredmetDTOOut.convert(predmetService.dajSvePredmete()));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<PredmetDTOOut> findClassByID(@PathVariable Long id){
        return ResponseEntity.ok(predmetToPredmetDTOOut.convert(predmetService.dajPredmetZaID(id)));
    }
    @GetMapping(value = "/{id}/students")
    public ResponseEntity<List<StudentDTOPredmetOut>> getStudentsByCLass(@PathVariable Long id){

        return ResponseEntity.ok(studentToStudentDTOPredmetOut.convert(predmetService.getStudentsByCLass(id)));

    }
    @GetMapping(value = "name/{name}")
    public ResponseEntity<List<PredmetDTOOut>> findClassByNameContaining(@PathVariable String name){
        return ResponseEntity.ok( predmetToPredmetDTOOut.convert(predmetService.dajPredmetePoImenu(name)));
    }

    @GetMapping(value = "fullname/{name}")
    public ResponseEntity<PredmetDTOOut> findClassByNameEquals(@PathVariable String name){
        return ResponseEntity.ok(predmetToPredmetDTOOut.convert(predmetService.dajPredmetPoImenu(name)));
    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        predmetService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PostMapping
    public ResponseEntity<PredmetDTO> saveClass(@RequestBody Predmet predmet){

        Predmet savedPredmet = predmetService.savePredmet(predmet);
        return ResponseEntity.status(HttpStatus.CREATED).body(predmetToPredmetDTO.convert(savedPredmet));

    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<PredmetDTO> editUser( @RequestBody Predmet predmet, @PathVariable Long id){

        Predmet editedpredemt = predmetService.savePredmet(predmet);
        return ResponseEntity.ok(predmetToPredmetDTO.convert(editedpredemt));
    }
}
