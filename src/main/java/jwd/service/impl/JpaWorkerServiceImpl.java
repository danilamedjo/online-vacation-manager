package jwd.service.impl;

import jwd.model.Worker;
import jwd.repository.WorkerRepository;
import jwd.service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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

    @Override
    public Page<Worker> findAll(int pageNum, int pageSize) {
        return workerRepository.findAll(new PageRequest(pageNum, pageSize));
    }

    @Override
    public Page<Worker> search(String idNum, String fullName, Long departmentId, int pageNum, int pageSize) {

        if(idNum != null){
            idNum = "%" + idNum + "%";
        }

        if(fullName != null){
            fullName = "%" + fullName + "%";
        }

        return workerRepository.search(idNum, fullName, departmentId, new PageRequest(pageNum, pageSize));
    }
}
