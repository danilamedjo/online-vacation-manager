package jwd.service;

import jwd.model.Worker;

import java.util.List;

public interface WorkerService {

    Worker findOne(Long id);

    List<Worker> findAll();

    Worker save(Worker worker);

    Worker remove(Long id);

}
