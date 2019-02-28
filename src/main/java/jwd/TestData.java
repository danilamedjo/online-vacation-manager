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

        Worker w8 = new Worker("MM001", "Marko Markovic", "marko.markovic@gmail.com", 5);
        w8.setDepartment(d1);
        w8.setFreeDays(15);
        workerService.save(w8);
        Worker w2 = new Worker("AA001", "Ana Anicic", "ana.anicic@gmail.com", 8);
        w2.setDepartment(d1);
        w2.setFreeDays(89);
        workerService.save(w2);
        Worker w7 = new Worker("BB001", "Bojana Bojanic", "bojana.bojanic@gmail.com", 5);
        w7.setDepartment(d1);
        w7.setFreeDays(5);
        workerService.save(w7);
        Worker w4 = new Worker("CC001", "Ceca Cvetic", "ceca.cvetic@gmail.com", 9);
        w4.setDepartment(d1);
        w4.setFreeDays(1);
        workerService.save(w4);
        Worker w5 = new Worker("VV001", "Vukan Vukasinovic", "vukan.vukasinovic@gmail.com", 25);
        w5.setDepartment(d1);
        w5.setFreeDays(18);
        workerService.save(w5);
        Worker w6 = new Worker("HH002", "Horvat je Nenad", "horvat.je.nenad@gmail.com", 105);
        w6.setDepartment(d1);
        w6.setFreeDays(189);
        workerService.save(w6);

        Date date = new Date();

        Vacation v1 = new Vacation(date, date,  7);
        v1.setWorker(w8);
        vacationService.save(v1);

    }

}
