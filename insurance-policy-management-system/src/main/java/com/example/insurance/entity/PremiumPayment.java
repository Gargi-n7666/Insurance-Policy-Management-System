package com.example.insurance.entity;
import jakarta.persistence.*; import jakarta.validation.constraints.*; import com.fasterxml.jackson.annotation.JsonIgnore; import java.math.BigDecimal; import java.time.LocalDate;
@Entity @Table(name="premium_payment") public class PremiumPayment { @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long paymentId; @NotNull @Positive @Column(precision=14,scale=2) private BigDecimal amount; @NotNull private LocalDate paymentDate; @NotBlank private String paymentMode; @NotBlank @Column(unique=true) private String transactionId; @NotBlank private String paymentStatus="PENDING"; @JsonIgnore @NotNull @ManyToOne @JoinColumn(name="policy_id",nullable=false) private Policy policy; 
    public PremiumPayment() {}
    public Long getPaymentId() { return this.paymentId; }
    public void setPaymentId(Long paymentId) { this.paymentId = paymentId; }
    public BigDecimal getAmount() { return this.amount; }
    public void setAmount(BigDecimal amount) { this.amount = amount; }
    public LocalDate getPaymentDate() { return this.paymentDate; }
    public void setPaymentDate(LocalDate paymentDate) { this.paymentDate = paymentDate; }
    public String getPaymentMode() { return this.paymentMode; }
    public void setPaymentMode(String paymentMode) { this.paymentMode = paymentMode; }
    public String getTransactionId() { return this.transactionId; }
    public void setTransactionId(String transactionId) { this.transactionId = transactionId; }
    public String getPaymentStatus() { return this.paymentStatus; }
    public void setPaymentStatus(String paymentStatus) { this.paymentStatus = paymentStatus; }
    public Policy getPolicy() { return this.policy; }
    public void setPolicy(Policy policy) { this.policy = policy; }
}