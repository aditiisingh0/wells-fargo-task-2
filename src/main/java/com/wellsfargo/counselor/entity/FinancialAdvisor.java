package com.wellsfargo.counselor.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "financial_advisor")
public class FinancialAdvisor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long advisorId;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String passwordHash;

    // One advisor can have many clients
    @OneToMany(mappedBy = "advisor", cascade = CascadeType.ALL)
    private List<Client> clients;

    // Required no-arg constructor for JPA
    public FinancialAdvisor() {}

    public FinancialAdvisor(String firstName, String lastName, String email, String passwordHash) {
        this.firstName    = firstName;
        this.lastName     = lastName;
        this.email        = email;
        this.passwordHash = passwordHash;
    }

    // ── Getters ───────────────────────────────────────────────────────────────

    public long getAdvisorId() {
        return advisorId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public List<Client> getClients() {
        return clients;
    }

    // ── Setters (no setter for id) ────────────────────────────────────────────

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }
}
