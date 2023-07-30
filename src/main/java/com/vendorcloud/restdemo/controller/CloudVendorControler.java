package com.vendorcloud.restdemo.controller;

import com.vendorcloud.restdemo.model.CloudVendor;
import com.vendorcloud.restdemo.service.CloudVendorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cloudevendor")
@Validated
public class CloudVendorControler {
    @Autowired
    CloudVendorService cloudVendorService;

//    public CloudVendorControler(CloudVendorService cloudVendorService) {
//        this.cloudVendorService = cloudVendorService;
//    }
//read specific cloud vendor details
    @GetMapping("{vendorId}")
    public CloudVendor getCloudeVendor(@PathVariable("vendorId") String vendorId){
      //  return new CloudeVendor("C1","vendor 1","Address 1","xxxxx");
       return cloudVendorService.getCloudVendor(vendorId);
    }
    // read all cloud vendor details
    @GetMapping()
    public List<CloudVendor> getAllCloudeVendor(String vendorId){
        //  return new CloudeVendor("C1","vendor 1","Address 1","xxxxx");
        return cloudVendorService.getAllCloudVendor();
    }

    @PostMapping
    public String createCloudVendor(@Valid @RequestBody CloudVendor cloudVendor){
        cloudVendorService.createCloudVendor(cloudVendor);
        return "cloud vendor is sucessfully created";

    }
    @PutMapping
    public String updateCloudVendor(@RequestBody CloudVendor cloudVendor){
        cloudVendorService.updateCloudVendor(cloudVendor);
        return "cloud vendor is sucessfully updated";
    }
    @DeleteMapping("{vendorId}")
    public String deleteCloudVendor(@PathVariable("vendorId") String vendorId){
        cloudVendorService.delteCloudVendor(vendorId);
        return "cloud vendor is sucessfully deleted";
    }
}
