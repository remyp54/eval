package eval.remypaquin.eval.controllers;

import eval.remypaquin.eval.dao.ChantierDao;
import eval.remypaquin.eval.models.Chantier;
import eval.remypaquin.eval.models.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/chantiers")
public class ChantierController {

    @Autowired
    private ChantierDao chantierDao;

    @GetMapping
    public ResponseEntity<List<Chantier>> getAllChantiers() {
        List<Chantier> chantiers = chantierDao.findAll();
        return new ResponseEntity<>(chantiers, HttpStatus.OK);
    }

    @GetMapping("/{id}/temps-total")
    public ResponseEntity<Integer> getTempsTotalForChantier(@PathVariable("id") Integer id) {
        Chantier chantier = chantierDao.findById(id).orElse(null);
        if (chantier != null) {
            int tempsTotal = calculateTotalTime(chantier);
            return new ResponseEntity<>(tempsTotal, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(0, HttpStatus.NOT_FOUND);
        }
    }

    private int calculateTotalTime(Chantier chantier) {
        int totalTime = 0;
        List<Operation> operations = chantier.getOperations();
        for (Operation operation : operations) {
            totalTime += operation.getTemps();
        }
        return totalTime;
    }
}

