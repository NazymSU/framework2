package kz.bitlab.springboot.springdatademo.techboot.repositories;

import kz.bitlab.springboot.springdatademo.techboot.models.ApplicationRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RequestRepository extends JpaRepository<ApplicationRequest,Long> {

    @Query ("SELECT a FROM ApplicationRequest a WHERE a.handled = false")
    List<ApplicationRequest> getAllNewApps();

    @Query ("SELECT r FROM ApplicationRequest r WHERE r.handled = true")
    List<ApplicationRequest> getAllOldApps();
}
