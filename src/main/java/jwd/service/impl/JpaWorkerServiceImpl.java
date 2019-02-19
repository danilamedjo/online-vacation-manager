package jwd.service.impl;

import jwd.model.Worker;
import jwd.repository.WorkerRepository;
import jwd.service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class JpaWorkerServiceImpl implements WorkerService  {

    @Autowired
    private WorkerRepository workerRepository;

    @Override
    public Worker findOne(Long id) {
        return workerRepository.findOne(id);
    }

    @Override
    public List<Worker> findAll() {
        return workerRepository.findAll();
    }

    @Override
    public Worker save(Worker worker) {
        return workerRepository.save(worker);
    }

    @Override
    public Worker remove(Long id) {

        Worker worker = workerRepository.findOne(id);

        if(worker != null){
            workerRepository.delete(worker);
        }
        return worker;
    }
}
