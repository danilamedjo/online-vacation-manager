package jwd.support;

import jwd.model.Department;
import jwd.web.dto.DepartmentDTO;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DepartmentToDepartmentDTO implements Converter<Department, DepartmentDTO> {

    @Override
    public DepartmentDTO convert(Department department) {
        DepartmentDTO departmentDTO = new DepartmentDTO();

        departmentDTO.setId(department.getId());
        departmentDTO.setName(department.getName());


        return departmentDTO;
    }


    public List<DepartmentDTO> convert(List<Department> departments){

        List<DepartmentDTO> ret = new ArrayList<>();

        for(Department d : departments) {

            ret.add(convert(d));
        }
        return ret;
    }

}
