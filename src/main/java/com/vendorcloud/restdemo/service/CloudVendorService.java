package com.vendorcloud.restdemo.service;

import com.vendorcloud.restdemo.model.CloudVendor;

import java.util.List;

public interface CloudVendorService {
    public String createCloudVendor(CloudVendor cloudeVendor);
    public String updateCloudVendor(CloudVendor cloudeVendor);
    public String delteCloudVendor(String cloudVendorId);
    public CloudVendor getCloudVendor(String cloudVendorId);
    public List<CloudVendor> getAllCloudVendor();
}
