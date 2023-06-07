package kz.bitlab.springboot.springdatademo.techboot.controller;

import kz.bitlab.springboot.springdatademo.techboot.models.ApplicationRequest;
import kz.bitlab.springboot.springdatademo.techboot.models.Course;
import kz.bitlab.springboot.springdatademo.techboot.services.CourseService;
import kz.bitlab.springboot.springdatademo.techboot.services.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private RequestService requestService;
    @Autowired
    private CourseService courseService;

    @GetMapping (value="/")
    public  String homePage(Model model){
        List <ApplicationRequest> applications =requestService.getAllApps();
        List<Course> courses =courseService.getAll();
        model.addAttribute("apps",applications);
        model.addAttribute("courses",courses);
        return "index";
    }

    @GetMapping("/appdetails/{id}")
    public String detailsPage(@PathVariable Long id, Model model) {
        ApplicationRequest applicationRequest = requestService.getAppById(id);
        if (applicationRequest != null) {
            model.addAttribute("app", applicationRequest);
            return "appdetails";
        }
        return "index";
    }

    @GetMapping("/newapp")
    public String newApp(Model model) {
        List<Course> courses = courseService.getAll();
        model.addAttribute("courses",courses);
        return "newapp";
    }

    @PostMapping("/addapp")
    public String addApp(ApplicationRequest applicationRequest) {
        requestService.createNewApp(applicationRequest);
        return "redirect:/";
    }

    @PostMapping("/sethandle")
    public String setHandle(@RequestParam Long id, Model model) {
        ApplicationRequest applicationRequest = requestService.getAppById(id);
        requestService.setAppHandled(id);
        model.addAttribute("app", applicationRequest);
        return "appdetails";
    }

    @PostMapping("/deleteapp")
    public String deleteApp(@RequestParam Long id) {
        requestService.deleteAppById(id);
        return "redirect:/";
    }

    @GetMapping("/onlynewapp")
    public String onlyNewApp(Model model) {
        List<ApplicationRequest> apps =requestService.getAllNewApps();
        if (apps != null) {
            model.addAttribute("apps", apps);
            return "onlynewapp";
        } else return "index";
    }

    @GetMapping("/onlyoldapp")
    public String onlyOldApp(Model model) {
        List<ApplicationRequest> apps = requestService.getAllOldApps();
        if (apps != null) {
            model.addAttribute("apps", apps);
            return "onlyoldapp";
        } else return "index";
    }

}
