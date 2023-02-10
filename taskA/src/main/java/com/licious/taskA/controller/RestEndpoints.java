package com.licious.taskA.controller;

import com.licious.taskA.service.DeptEmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;


@RestController
public class RestEndpoints {
    @Autowired
    DeptEmpService deptEmpService;

    @Value("${file.upload-dir}")
    String FILE_DIRECTORY;

    @PostMapping("/uploadFile")
    public ResponseEntity<Object> fileUpload(@RequestParam("file") MultipartFile file) throws IOException {
        File myFile = new File(FILE_DIRECTORY + file.getOriginalFilename());
        myFile.createNewFile();
        FileOutputStream fos = new FileOutputStream(myFile);
        fos.write(file.getBytes());
        fos.close();

        return new ResponseEntity<Object>("The File Uploaded Successfully", HttpStatus.OK);
    }


    @GetMapping("/getFile")
    public ResponseEntity<Object> getFile(@RequestParam("fileName") String fileName) throws FileNotFoundException {

        File myFile = new File(FILE_DIRECTORY+fileName+".pdf");
        HttpHeaders headers = new HttpHeaders();
        headers.add("content-disposition", "inline;filename=" +fileName);

        InputStreamResource resource = new InputStreamResource(new FileInputStream(myFile));

        return ResponseEntity.ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_PDF)
                .contentLength(myFile.length())
                .body(resource);
    }


    @PutMapping("/renameFile")
    public ResponseEntity<Object> renameFile(@RequestParam("name") String name,@RequestParam("newName") String newName) {
        File myFile = new File(FILE_DIRECTORY + name+".pdf");
        String message;
        if(myFile.renameTo(new File(FILE_DIRECTORY+newName+".pdf"))){
            message="This file has been renamed successfully!!";
        }else{
            message="This file hasn't been renamed successfully!!";
        }
        return new ResponseEntity<Object>(message, HttpStatus.OK);
    }


    @DeleteMapping("/deleteFile")
    public ResponseEntity<Object> deleteFile(@RequestParam("name") String name){
        File myFile = new File(FILE_DIRECTORY+name+".pdf");
        String message;
        if (myFile.delete()) {
            message="File has been deleted successfully!!";
        }
        else {
            message="File hasn't been deleted successfully!!";
        }
        return new ResponseEntity<Object>(message, HttpStatus.OK);
    }

    @GetMapping("/getDepartments")
    public ResponseEntity<Object> getDepartments(){
        return new ResponseEntity<Object>(deptEmpService.getDeptList(), HttpStatus.OK);
    }

    @GetMapping("/getEmployees")
    public ResponseEntity<Object> getEmployees(@RequestParam("dept") String dept, @RequestParam(name = "offSet",defaultValue = "0") int offSet, @RequestParam(name = "pageSize",defaultValue = "100") int pageSize ){
        return new ResponseEntity<Object>(deptEmpService.getEmployeesFromDept(dept,offSet,pageSize), HttpStatus.OK);
    }

    @GetMapping("/check")
    public ResponseEntity<Object> Checking() {
        return new ResponseEntity<Object>("Checking...!", HttpStatus.OK);
    }
}