package jwd.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tbl_department")
public class Department extends BaseEntity{

    private String name;

    private Integer bonusFreeDays;

    @OneToMany(mappedBy = "department", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Worker> workers = new ArrayList<>();

    public Department() {
    }

    public Department(String name, Integer bonusFreeDays) {
        this.name = name;
        this.bonusFreeDays = bonusFreeDays;
    }

    public Integer getBonusFreeDays() {
        return bonusFreeDays;
    }

    public void setBonusFreeDays(Integer bonusFreeDays) {
        this.bonusFreeDays = bonusFreeDays;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Worker> getWorkers() {
        return workers;
    }
    public void setWorkers(List<Worker> workers) {
        this.workers = workers;
    }
    public void addWorker(Worker worker){
        this.workers.add(worker);

        if(!this.equals(worker.getDepartment())){
            worker.setDepartment(this);
        }
    }
}
