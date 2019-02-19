package jwd.model;


import javax.persistence.*;

@Entity
@Table(name = "tbl_vacation")
public class Vacation extends BaseEntity{

    @Column(nullable = false)
    private String startDate;

    private String endDate;

    private Integer workingDays;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "worker_id")
    private Worker worker;

    public Vacation(){
    }

    public Vacation(String startDate, String endDate, Integer workingDays) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.workingDays = workingDays;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public Integer getWorkingDays() {
        return workingDays;
    }

    public void setWorkingDays(Integer workingDays) {
        this.workingDays = workingDays;
    }

    public Worker getWorker() {
        return worker;
    }
    public void setWorker(Worker worker) {
        this.worker = worker;
        if(worker!=null && !worker.getVacations().contains(this)){
            worker.getVacations().add(this);
        }
    }


}
