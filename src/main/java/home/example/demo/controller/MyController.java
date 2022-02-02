package home.example.demo.controller;

import home.example.demo.business.ReadFileData;
import home.example.demo.request.Student;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class MyController {
    @Autowired
     private ReadFileData readFileData;
     private List<Student> myList = new ArrayList();
    @GetMapping
    public List<String> getListItem(){
        return myList.stream().map(student -> student.getName()).collect(Collectors.toList());
    }

    @GetMapping("/fileData")
    public long getStringCount(){
       return readFileData.getStringCount();
    }

    @PostMapping("/save")
    public void saveDataInList(@RequestBody Student student){
        myList.add(student);
    }
}
