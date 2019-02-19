package jwd;

import jwd.model.Department;
import jwd.model.Vacation;
import jwd.model.Worker;
import jwd.service.DepartmentService;
import jwd.service.VacationService;
import jwd.service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.Instant;
import java.util.Date;

@Component
public class TestData {


    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private WorkerService workerService;

    @Autowired
    private VacationService vacationService;


    @PostConstruct
    public void init(){

        Department d1 = new Department("Department 1", 5);
        departmentService.save(d1);

        Worker w1 = new Worker("Worker 1", "Ime Prezime", "ime.prezime@gmail.com", 5);
        w1.setDepartment(d1);
        workerService.save(w1);

        Vacation v1 = new Vacation("10.11", "17.11", 7);
        v1.setWorker(w1);
        vacationService.save(v1);

    }

}
