package jwd.model;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tbl_vacation")
public class Vacation extends BaseEntity{

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date startDate;

    @Temporal(TemporalType.DATE)
    private Date endDate;

    private Integer workingDays;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "worker_id")
    private Worker worker;

    public Vacation(){
    }

    public Vacation(Date startDate, Date endDate, Integer workingDays) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.workingDays = workingDays;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
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
