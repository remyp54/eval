package eval.remypaquin.eval.controllers;

import eval.remypaquin.eval.dao.ConsommableDao;
import eval.remypaquin.eval.models.Consommable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/consommables")
public class ConsommableController {

    @Autowired
    private ConsommableDao consommableDao;

    @GetMapping
    public ResponseEntity<List<Consommable>> getAllConsommables() {
        List<Consommable> consommables = consommableDao.findAll();
        return new ResponseEntity<>(consommables, HttpStatus.OK);
    }
}
