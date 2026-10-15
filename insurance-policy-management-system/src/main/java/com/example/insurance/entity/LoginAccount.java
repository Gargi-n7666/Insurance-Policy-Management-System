package com.example.insurance.entity;
import jakarta.persistence.*; import jakarta.validation.constraints.*; import com.fasterxml.jackson.annotation.JsonProperty;
@Entity @Table(name="login_account") public class LoginAccount { @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long loginAccountId; @NotBlank @Column(nullable=false,unique=true) private String username; @NotBlank @JsonProperty(access = JsonProperty.Access.WRITE_ONLY) private String password; @NotBlank private String role; private Boolean active=true; @OneToOne @JoinColumn(name="customer_id",unique=true) private Customer customer; 
    public LoginAccount() {}
    public Long getLoginAccountId() { return this.loginAccountId; }
    public void setLoginAccountId(Long loginAccountId) { this.loginAccountId = loginAccountId; }
    public String getUsername() { return this.username; }
    public void setUsername(String username) { this.username = username; }
    public String getPassword() { return this.password; }
    public void setPassword(String password) { this.password = password; }
    public String getRole() { return this.role; }
    public void setRole(String role) { this.role = role; }
    public Boolean getActive() { return this.active; }
    public void setActive(Boolean active) { this.active = active; }
    public Customer getCustomer() { return this.customer; }
    public void setCustomer(Customer customer) { this.customer = customer; }
}