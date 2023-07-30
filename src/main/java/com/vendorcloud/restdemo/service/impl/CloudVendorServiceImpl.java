package com.vendorcloud.restdemo.service.impl;

import com.vendorcloud.restdemo.exception.CloudVendorNotFoundException;
import com.vendorcloud.restdemo.model.CloudVendor;
import com.vendorcloud.restdemo.repository.CloudVendorRepository;
import com.vendorcloud.restdemo.service.CloudVendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CloudVendorServiceImpl implements CloudVendorService {
    @Autowired
    CloudVendorRepository cloudVendorRepository;

//    public CloudVendorServiceImpl(CloudVendorRepository cloudVendorRepository) {
//        this.cloudVendorRepository = cloudVendorRepository;
//    }

    @Override
    public String createCloudVendor(CloudVendor cloudeVendor) {
        cloudVendorRepository.save(cloudeVendor);
        return "Success";
    }

    @Override
    public String updateCloudVendor(CloudVendor cloudeVendor) {
        cloudVendorRepository.save(cloudeVendor);
        return "Success";
    }

    @Override
    public String delteCloudVendor(String cloudVendorId) {
        cloudVendorRepository.deleteById(cloudVendorId);
        return "success";
    }

    @Override
    public CloudVendor getCloudVendor(String cloudVendorId) {
        // more business logic
        if(cloudVendorRepository.findById(cloudVendorId).isEmpty())
            throw new CloudVendorNotFoundException(cloudVendorId);
       return cloudVendorRepository.findById(cloudVendorId).get();

    }

    @Override
    public List<CloudVendor> getAllCloudVendor() {
        return cloudVendorRepository.findAll();
    }
}
