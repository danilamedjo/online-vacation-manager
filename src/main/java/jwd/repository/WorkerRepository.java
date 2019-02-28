package jwd.repository;

import jwd.model.Worker;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkerRepository extends JpaRepository<Worker, Long> {

    @Query("SELECT w FROM Worker w ORDER BY w.identityNumber ASC")
    Page<Worker> findAll(Pageable pageRequest);


    @Query("SELECT w FROM Worker w WHERE "
            + "(:identityNumber IS NULL OR w.identityNumber like :identityNumber) AND "
            + "(:fullName IS NULL OR w.fullName like :fullName) AND "
            + "(:departmentId IS NULL OR w.department.id like :departmentId) "
            + "ORDER BY w.identityNumber ASC"
    )
    Page<Worker> search (@Param("identityNumber") String identityNumber,
                         @Param("fullName") String fullName,
                         @Param("departmentId") Long departmentId,
                         Pageable pageRequest);

}
