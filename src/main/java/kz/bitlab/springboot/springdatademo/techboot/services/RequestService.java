package kz.bitlab.springboot.springdatademo.techboot.services;

import kz.bitlab.springboot.springdatademo.techboot.models.ApplicationRequest;

import java.util.List;

public interface RequestService {
    List<ApplicationRequest> getAllApps();
    List<ApplicationRequest> getAllNewApps();
    List<ApplicationRequest> getAllOldApps();
    ApplicationRequest getAppById(Long id);
    void deleteAppById(Long id);
    void createNewApp(ApplicationRequest applicationRequest);
    void setAppHandled(Long id);
}
