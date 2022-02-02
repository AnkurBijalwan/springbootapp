package home.example.demo.business;

import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

@Service
public class ReadFileData {
    public String getDataFromFile(){
        return "file read";
    }

    public long getStringCount(){
        long length=0;
        try {
             String data = Files.readString(Paths.get("src/main/resources/sample.txt"));
             length= Arrays.stream(data.split(" ")).filter(data1 -> data1.startsWith("a")).count();
        }catch (IOException exception){
            System.out.println(exception.getCause());
        }
       return length;
    }
}
