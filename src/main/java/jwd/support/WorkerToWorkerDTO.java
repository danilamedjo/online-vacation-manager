package jwd.support;

import jwd.model.Worker;
import jwd.web.dto.WorkerDTO;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class WorkerToWorkerDTO implements Converter<Worker, WorkerDTO> {

    @Override
    public WorkerDTO convert(Worker worker) {

        WorkerDTO dto = new WorkerDTO();

        dto.setId(worker.getId());
        dto.setIdentityNumber(dto.getIdentityNumber());
        dto.setEmail(worker.getEmail());
        dto.setFullName(worker.getEmail());
        dto.setYearsOfService(worker.getYearsOfService());
        dto.setDepartmentId(worker.getDepartment().getId());
        dto.setDepartmentName(worker.getDepartment().getName());

        return dto;
    }

    public List<WorkerDTO> convert(List<Worker> workers){

        List<WorkerDTO> dtos = new ArrayList<>();

        for(Worker worker : workers){

            dtos.add(convert(worker));
        }

        return dtos;
    }

}
