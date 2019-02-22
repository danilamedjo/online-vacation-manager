package jwd.support;

import jwd.model.Department;
import jwd.model.Worker;
import jwd.service.DepartmentService;
import jwd.service.WorkerService;
import jwd.web.dto.EditWorkerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

public class EditWorkerDTOToWorker implements Converter<EditWorkerDTO, Worker> {

    @Autowired
    private WorkerService workerService;

    @Autowired
    private DepartmentService departmentService;

    @Override
    public Worker convert(EditWorkerDTO editWorkerDTO) {

        Worker worker = workerService.findOne(editWorkerDTO.getId());
        Department department = departmentService.findOne(editWorkerDTO.getDepartmentId());

        if(worker != null && department != null) {

            worker.setDepartment(department);
            worker.setFullName(editWorkerDTO.getFullName());
            worker.setYearsOfService(editWorkerDTO.getYearsOfService());
            worker.setEmail(editWorkerDTO.getEmail());
            worker.setIdentityNumber(editWorkerDTO.getIdentityNumber());


        }else{
            throw new IllegalStateException("Trying to edit non-existent entity");
        }


        return worker;
    }
}
