package com.example.insurance.entity;
import jakarta.persistence.*; import jakarta.validation.constraints.*; import com.fasterxml.jackson.annotation.JsonIgnore; import java.math.BigDecimal; import java.time.LocalDate;
@Entity @Table(name="claim") public class Claim { @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long claimId; @NotNull @Positive @Column(precision=14,scale=2) private BigDecimal claimAmount; @NotNull private LocalDate claimDate; @NotBlank private String claimStatus="PENDING"; @NotBlank private String accidentLocation; @NotBlank @Column(length=2000) private String description; @JsonIgnore @NotNull @ManyToOne @JoinColumn(name="policy_id",nullable=false) private Policy policy; 
    public Claim() {}
    public Long getClaimId() { return this.claimId; }
    public void setClaimId(Long claimId) { this.claimId = claimId; }
    public BigDecimal getClaimAmount() { return this.claimAmount; }
    public void setClaimAmount(BigDecimal claimAmount) { this.claimAmount = claimAmount; }
    public LocalDate getClaimDate() { return this.claimDate; }
    public void setClaimDate(LocalDate claimDate) { this.claimDate = claimDate; }
    public String getClaimStatus() { return this.claimStatus; }
    public void setClaimStatus(String claimStatus) { this.claimStatus = claimStatus; }
    public String getAccidentLocation() { return this.accidentLocation; }
    public void setAccidentLocation(String accidentLocation) { this.accidentLocation = accidentLocation; }
    public String getDescription() { return this.description; }
    public void setDescription(String description) { this.description = description; }
    public Policy getPolicy() { return this.policy; }
    public void setPolicy(Policy policy) { this.policy = policy; }
}