package jwd.support;

import jwd.model.Department;
import jwd.model.Worker;
import jwd.service.DepartmentService;
import jwd.service.WorkerService;
import jwd.web.dto.WorkerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class WorkerDTOToWorker implements Converter<WorkerDTO, Worker> {

    @Autowired
    private WorkerService workerService;

    @Autowired
    private DepartmentService departmentService;

    @Override
    public Worker convert(WorkerDTO dto) {


        Department department = departmentService.findOne(dto.getDepartmentId());

        Worker worker;


        if(department != null) {

            if (dto.getId() == null) {

                worker = new Worker();

            } else {

                worker = workerService.findOne(dto.getId());

            }

            worker.setDepartment(department);
            worker.setIdentityNumber(dto.getIdentityNumber());
            worker.setEmail(dto.getEmail());
            worker.setYearsOfService(dto.getYearsOfService());
            worker.setFullName(dto.getFullName());

            return worker;

        }else{
            throw new IllegalStateException("Trying to attach a non-existent entities");
        }

    }


    public List<Worker> convert(List<WorkerDTO> dtos){

        List<Worker> workers = new ArrayList<>();

        for(WorkerDTO dto : dtos){
            workers.add(convert(dto));
        }

        return workers;
    }


}
