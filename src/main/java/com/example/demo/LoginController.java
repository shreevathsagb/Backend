
package com.example.demo;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@CrossOrigin("*")
public class LoginController {
	
	
	
    @Autowired
    private AdminRepository adminrepo;

    @Autowired
    private CollegeRepository collegerepo;

    @Autowired
    private PassportstaffRepository passportstaffrepo;

    @Autowired
    private PoliceRepository policerepo;



    @PostMapping("/LoginVerify")
    public ResponseEntity<?> LoginVerify(@RequestBody LoginDTO obj) {
        if (obj.getUsertype().equals("Admin")) {
            var user = adminrepo.findById(obj.getId()).orElseThrow(() -> new RuntimeException("Not Found"));
            if (user.getPassword().equals(obj.getPassword())) {
                return new ResponseEntity<>("Success", HttpStatus.OK);

            } else {
                throw new RuntimeException("Invalid Password");
            }
        }
        else if (obj.getUsertype().equals("Passport")) {
            var user = passportstaffrepo.findById(obj.getId()).orElseThrow(() -> new RuntimeException("Not Found"));
            if (user.getPassword().equals(obj.getPassword())) {
                return new ResponseEntity<>("Success", HttpStatus.OK);

            } else {
                throw new RuntimeException("Invalid Password");
            }
        }
        else if (obj.getUsertype().equals("College")) {
            var user = collegerepo.findById(obj.getId()).orElseThrow(() -> new RuntimeException("Not Found"));
            if (user.getPassword().equals(obj.getPassword())) {
                return new ResponseEntity<>("Success", HttpStatus.OK);

            } else {
                throw new RuntimeException("Invalid Password");
            }
        }
        else if (obj.getUsertype().equals("Police")) {
            var user = policerepo.findById(obj.getId()).orElseThrow(() -> new RuntimeException("Not Found"));
            if (user.getPassword().equals(obj.getPassword())) {
                return new ResponseEntity<>("Success", HttpStatus.OK);

            } else {
                throw new RuntimeException("Invalid Password");
            }
        }
        else {

            throw new RuntimeException("Invalid Password");

        }
    }
    
    @PostMapping("/Signup/Police")
    public ResponseEntity<?> signUp(@RequestBody PoliceEntity obj){
    	policerepo.save(obj);
    	return new ResponseEntity<>("Added Succesfully" ,HttpStatus.OK);
    	
    }
    @PostMapping("/Signup/Passport")
    public ResponseEntity<?> signUp(@RequestBody PassportstaffEntity obj){
    	passportstaffrepo.save(obj);
    	return new ResponseEntity<>("Added Succesfully" ,HttpStatus.OK);
    	
    }
    @PostMapping("/Signup/College")
    public ResponseEntity<?> signUp(@RequestBody CollegeEntity obj){
    	collegerepo.save(obj);
    	return new ResponseEntity<>("Added Succesfully" ,HttpStatus.OK);
    }
    
    @GetMapping("/GetCollege")
    public ResponseEntity<?> getCollege(){
        List<CollegeEntity> colleges = collegerepo.findAll();
        return ResponseEntity.ok().body(colleges);


    	
    }
    		
    @GetMapping("/GetPolice")
    public ResponseEntity<?> getPolice(){
        List<PoliceEntity> police = policerepo.findAll();
        return ResponseEntity.ok().body(police);


    	
    }
    @GetMapping("/GetPassportstaff")
    public ResponseEntity<?> getPassportstaff(){
        List<PassportstaffEntity> police = passportstaffrepo.findAll();
        return ResponseEntity.ok().body(police);
    	
    }
    
    @PutMapping("/Edit/Passportstaff/{id}")
    public ResponseEntity<?> editPassport(@RequestBody PassportstaffEntity obj,@PathVariable String id){
      	PassportstaffEntity pass = passportstaffrepo.findById(id).orElse(null);
      	if (pass == null) {
      		return new ResponseEntity<>("No data" , HttpStatus.OK);
      	}
      	else {
      		pass.setPassword(obj.getPassword());
      		passportstaffrepo.save(pass);
      		return new ResponseEntity<>("Updated Succesfully" ,HttpStatus.OK);
      	}
    	
    }
    
    @DeleteMapping("/Delete/Passportstaff/{id}")
    public ResponseEntity<?> deletePassport(@PathVariable String id){
      	PassportstaffEntity pass = passportstaffrepo.findById(id).orElse(null);
      	if (pass == null) {
      		return new ResponseEntity<>("No data" , HttpStatus.OK);
      	}
      	else {
      		passportstaffrepo.delete(pass);
      		return new ResponseEntity<>("Deleted Succesfully" ,HttpStatus.OK);
      	}
    	
    }
    @PutMapping("/Edit/College/{id}")
    public ResponseEntity<?> editCollege(@RequestBody CollegeEntity obj,@PathVariable String id){
      	CollegeEntity pass = collegerepo.findById(id).orElse(null);
      	if (pass == null) {
      		return new ResponseEntity<>("No data" , HttpStatus.OK);
      	}
      	else {
      		pass.setPassword(obj.getPassword());
      		collegerepo.save(pass);
      		return new ResponseEntity<>("Updated Succesfully" ,HttpStatus.OK);
      	}
    	
    }
    
    @DeleteMapping("/Delete/College/{id}")
    public ResponseEntity<?> deletecollege(@PathVariable String id){
      CollegeEntity pass = collegerepo.findById(id).orElse(null);
      	if (pass == null) {
      		return new ResponseEntity<>("No data" , HttpStatus.OK);
      	}
      	else {
      		collegerepo.delete(pass);
      		return new ResponseEntity<>("Deleted Succesfully" ,HttpStatus.OK);
      	}
    	
    }
    
    @PutMapping("/Edit/Police/{id}")
    public ResponseEntity<?> editPolice(@RequestBody PoliceEntity obj,@PathVariable String id){
      	PoliceEntity pass = policerepo.findById(id).orElse(null);
      	if (pass == null) {
      		return new ResponseEntity<>("No data" , HttpStatus.OK);
      	}
      	else {
      		pass.setPassword(obj.getPassword());
      		policerepo.save(pass);
      		return new ResponseEntity<>("Updated Succesfully" ,HttpStatus.OK);
      	}
    	
    }
    
    @DeleteMapping("/Delete/Police/{id}")
    public ResponseEntity<?> deletePolice(@PathVariable String id){
      	PoliceEntity pass = policerepo.findById(id).orElse(null);
      	if (pass == null) {
      		return new ResponseEntity<>("No data" , HttpStatus.OK);
      	}
      	else {
      		policerepo.delete(pass);
      		return new ResponseEntity<>("Deleted Succesfully" ,HttpStatus.OK);
      	}
    	
    }
    
    
   
}