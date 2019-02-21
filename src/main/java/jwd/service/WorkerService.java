package jwd.service;

import jwd.model.Worker;
import org.springframework.data.domain.Page;

import java.util.List;

public interface WorkerService {

    Worker findOne(Long id);

    Page<Worker> findAll(int pageNum, int pageSize);

    List<Worker> findAll();

    Worker save(Worker worker);

    Worker remove(Long id);

    Page<Worker> search (String idNum, String fullName, Long departmentId, int pageNum, int pageSize);

}
