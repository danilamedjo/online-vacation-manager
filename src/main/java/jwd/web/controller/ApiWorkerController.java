package jwd.web.controller;

import jwd.model.Worker;
import jwd.service.WorkerService;
import jwd.support.WorkerDTOToWorker;
import jwd.support.WorkerToWorkerDTO;
import jwd.web.dto.WorkerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/workers")
public class ApiWorkerController {

    @Autowired
    private WorkerService workerService;

    @Autowired
    private WorkerDTOToWorker toWorker;

    @Autowired
    private WorkerToWorkerDTO toDTO;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<WorkerDTO>> get(){

        List<Worker> workers = workerService.findAll();

        return new ResponseEntity<>(toDTO.convert(workers), HttpStatus.OK);

    }


}
