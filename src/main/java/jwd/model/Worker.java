package jwd.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tbl_worker")
public class Worker extends BaseEntity{

    @Column(nullable = false, unique = true)
    private String identityNumber;

    @Column(nullable = false)
    private String fullName;

    private String email;

    private Integer yearsOfService;

    private Integer freeDays = 20;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "department_id")
    private Department department;

    @OneToMany(mappedBy = "worker", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Vacation> vacations = new ArrayList<>();

    public Worker() {
    }

    public Worker(String identityNumber, String fullName, String email, Integer yearsOfService) {
        this.identityNumber = identityNumber;
        this.fullName = fullName;
        this.email = email;
        this.yearsOfService = yearsOfService;
    }

    public String getIdentityNumber() {
        return identityNumber;
    }

    public void setIdentityNumber(String identityNumber) {
        this.identityNumber = identityNumber;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getYearsOfService() {
        return yearsOfService;
    }

    public void setYearsOfService(Integer yearsOfService) {


        this.yearsOfService = yearsOfService;
    }

    public Integer getFreeDays() {
        return freeDays;
    }

    public void setFreeDays(Integer freeDays) {
        this.freeDays = freeDays;
    }

    public Department getDepartment() {
        return department;
    }
    public void setDepartment(Department department) {
        this.department = department;
        if(department!=null && !department.getWorkers().contains(this)){
            department.getWorkers().add(this);
        }
    }

    public List<Vacation> getVacations() {
        return vacations;
    }
    public void setVacations(List<Vacation> vacations) {
        this.vacations = vacations;
    }
    public void addVacation(Vacation vacation){
        this.vacations.add(vacation);

        if(!this.equals(vacation.getWorker())){
            vacation.setWorker(this);
        }
    }


}
