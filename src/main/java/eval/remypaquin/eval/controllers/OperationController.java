package eval.remypaquin.eval.controllers;

import eval.remypaquin.eval.dao.OperationDao;
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
@RequestMapping("/operations")
public class OperationController {

    @Autowired
    private OperationDao operationDao;

    @GetMapping
    public ResponseEntity<List<Operation>> getAllOperations() {
        List<Operation> operations = operationDao.findAll();
        return new ResponseEntity<>(operations, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Operation> getOperationById(@PathVariable("id") Integer id) {
        Operation operation = operationDao.findById(id).orElse(null);
        if (operation != null) {
            return new ResponseEntity<>(operation, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

