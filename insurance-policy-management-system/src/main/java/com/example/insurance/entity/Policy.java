package com.example.insurance.entity;
import jakarta.persistence.*; import jakarta.validation.constraints.*; import com.fasterxml.jackson.annotation.JsonIgnore; import java.math.BigDecimal; import java.time.LocalDate; import java.util.*;
@Entity @Table(name="policy") public class Policy {
@Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long policyId; @NotBlank @Column(nullable=false,unique=true) private String policyNumber; @NotBlank private String policyType; @NotNull @Positive @Column(precision=14,scale=2) private BigDecimal coverageAmount;
@NotNull private LocalDate startDate; @NotNull private LocalDate endDate; @NotBlank private String policyStatus="ACTIVE"; private Long agentId; private String agentName; private String agentBranch; private String agentContact;
@NotNull @OneToOne @JoinColumn(name="customer_id",nullable=false,unique=true) private Customer customer; @JsonIgnore @OneToMany(mappedBy="policy") private List<PremiumPayment> payments=new ArrayList<>(); @JsonIgnore @OneToMany(mappedBy="policy") private List<Claim> claims=new ArrayList<>(); 
    public Policy() {}
    public Long getPolicyId() { return this.policyId; }
    public void setPolicyId(Long policyId) { this.policyId = policyId; }
    public String getPolicyNumber() { return this.policyNumber; }
    public void setPolicyNumber(String policyNumber) { this.policyNumber = policyNumber; }
    public String getPolicyType() { return this.policyType; }
    public void setPolicyType(String policyType) { this.policyType = policyType; }
    public BigDecimal getCoverageAmount() { return this.coverageAmount; }
    public void setCoverageAmount(BigDecimal coverageAmount) { this.coverageAmount = coverageAmount; }
    public LocalDate getStartDate() { return this.startDate; }
    public void setStartDate(LocalDate startDate) { this.startDate = startDate; }
    public LocalDate getEndDate() { return this.endDate; }
    public void setEndDate(LocalDate endDate) { this.endDate = endDate; }
    public String getPolicyStatus() { return this.policyStatus; }
    public void setPolicyStatus(String policyStatus) { this.policyStatus = policyStatus; }
    public Long getAgentId() { return this.agentId; }
    public void setAgentId(Long agentId) { this.agentId = agentId; }
    public String getAgentName() { return this.agentName; }
    public void setAgentName(String agentName) { this.agentName = agentName; }
    public String getAgentBranch() { return this.agentBranch; }
    public void setAgentBranch(String agentBranch) { this.agentBranch = agentBranch; }
    public String getAgentContact() { return this.agentContact; }
    public void setAgentContact(String agentContact) { this.agentContact = agentContact; }
    public Customer getCustomer() { return this.customer; }
    public void setCustomer(Customer customer) { this.customer = customer; }
    public List<PremiumPayment> getPayments() { return this.payments; }
    public void setPayments(List<PremiumPayment> payments) { this.payments = payments; }
    public List<Claim> getClaims() { return this.claims; }
    public void setClaims(List<Claim> claims) { this.claims = claims; }
}