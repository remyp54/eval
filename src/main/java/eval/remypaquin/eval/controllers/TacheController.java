package eval.remypaquin.eval.controllers;

import eval.remypaquin.eval.dao.TacheDao;
import eval.remypaquin.eval.models.Tache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/taches")
public class TacheController {

    @Autowired
    private TacheDao tacheDao;

    @GetMapping
    public ResponseEntity<List<Tache>> getAllTaches() {
        List<Tache> taches = tacheDao.findAll();
        return new ResponseEntity<>(taches, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tache> getTacheById(@PathVariable("id") Integer id) {
        Tache tache = tacheDao.findById(id).orElse(null);
        if (tache != null) {
            return new ResponseEntity<>(tache, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
