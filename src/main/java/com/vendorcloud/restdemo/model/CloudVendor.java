package com.vendorcloud.restdemo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
@Table(name = "cloud_vendor_info")
public class CloudVendor {
    @Id
    private String vendorId;
    @Column(name = "vendor_name")
    @NotNull(message = "name sholudn't be null")
    private String vendorName;
    private String vendorAddress;
    private String vendorContact;
 //parameterized constructor
//    public CloudVendor(String vendorId, String vendorName, String vendorAddress, String vendorContact) {
//        this.vendorId = vendorId;
//        this.vendorName = vendorName;
//        this.vendorAddress = vendorAddress;
//        this.vendorContact = vendorContact;
//    }
////default constructor
//    public CloudVendor() {
//    }
////getter and setter
//    public String getVendorId() {
//        return vendorId;
//    }
//
//    public void setVendorId(String vendorId) {
//        this.vendorId = vendorId;
//    }
//
//    public String getVendorName() {
//        return vendorName;
//    }
//
//    public void setVendorName(String vendorName) {
//        this.vendorName = vendorName;
//    }
//
//    public String getVendorAddress() {
//        return vendorAddress;
//    }
//
//    public void setVendorAddress(String vendorAddress) {
//        this.vendorAddress = vendorAddress;
//    }
//
//    public String getVendorContact() {
//        return vendorContact;
//    }
//
//    public void setVendorContact(String vendorContact) {
//        this.vendorContact = vendorContact;
//    }
}
