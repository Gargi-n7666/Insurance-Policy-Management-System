package com.example.insurance.entity;
import jakarta.persistence.*; import jakarta.validation.constraints.*; import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity @Table(name="customer") public class Customer {
@Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long customerId;
@NotBlank @Size(max=100) @Column(nullable=false) private String name;
@NotBlank private String address; @NotBlank @Email @Column(nullable=false,unique=true) private String email;
@NotBlank private String phoneNumber; @NotNull @Positive private Integer age; @NotBlank private String gender;
@JsonIgnore @OneToOne(mappedBy="customer") private Policy policy; 
    public Customer() {}
    public Long getCustomerId() { return this.customerId; }
    public void setCustomerId(Long customerId) { this.customerId = customerId; }
    public String getName() { return this.name; }
    public void setName(String name) { this.name = name; }
    public String getAddress() { return this.address; }
    public void setAddress(String address) { this.address = address; }
    public String getEmail() { return this.email; }
    public void setEmail(String email) { this.email = email; }
    public String getPhoneNumber() { return this.phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
    public Integer getAge() { return this.age; }
    public void setAge(Integer age) { this.age = age; }
    public String getGender() { return this.gender; }
    public void setGender(String gender) { this.gender = gender; }
    public Policy getPolicy() { return this.policy; }
    public void setPolicy(Policy policy) { this.policy = policy; }
}