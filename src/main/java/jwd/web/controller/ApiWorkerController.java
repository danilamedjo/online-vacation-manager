package jwd.web.controller;

import jwd.model.Worker;
import jwd.service.WorkerService;
import jwd.support.WorkerDTOToWorker;
import jwd.support.WorkerToWorkerDTO;
import jwd.web.dto.WorkerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping
    public ResponseEntity<List<WorkerDTO>> get(
            @RequestParam(required = false) String identityNumber,
            @RequestParam(required = false) String fullName,
            @RequestParam(required = false) Long departmentId,
            @RequestParam(defaultValue = "0") int pageNum,
            @RequestParam(defaultValue = "5") int pageSize){

        Page<Worker> workers;

        if(identityNumber != null || fullName != null || departmentId != null){
            workers = workerService.search(identityNumber, fullName, departmentId, pageNum, pageSize);
        }else {
            workers = workerService.findAll(pageNum, pageSize);
        }

        HttpHeaders headers = new HttpHeaders();

        headers.add("totalPages", Integer.toString(workers.getTotalPages()));

        return new ResponseEntity<>(toDTO.convert(workers.getContent()), headers, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<WorkerDTO> get(@PathVariable Long id){

        Worker worker = workerService.findOne(id);
        if(worker == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            return new ResponseEntity<>(toDTO.convert(worker), HttpStatus.OK);
        }
    }

    @PostMapping(consumes = "application/json")
    public ResponseEntity<WorkerDTO> add(
            @Validated @RequestBody WorkerDTO workerDTO){

        Worker workerToAdd = toWorker.convert(workerDTO);

        Worker persisted = workerService.save(workerToAdd);

        return new ResponseEntity<>(toDTO.convert(persisted), HttpStatus.OK);

    }

    @PutMapping(value = "/{id}", consumes = "application/json")
    public ResponseEntity<WorkerDTO> edit(
            @PathVariable Long id,
            @Validated @RequestBody WorkerDTO workerDTO){


            if (workerDTO.getId().equals(id)) {
                Worker worker = toWorker.convert(workerDTO);

                if(worker!=null) {
                    Worker changed = workerService.save(worker);
                    return new ResponseEntity<>(toDTO.convert(changed), HttpStatus.OK);
                }
            }

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<WorkerDTO> delete(@PathVariable Long id){

        Worker worker = workerService.remove(id);

        if(worker != null){
            return new ResponseEntity<>(toDTO.convert(worker), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }







}
