package com.wellsfargo.counselor.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "portfolio")
public class Portfolio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long portfolioId;

    // One portfolio belongs to one client (1:1)
    @OneToOne
    @JoinColumn(name = "client_id", nullable = false, unique = true)
    private Client client;

    @Column(nullable = false)
    private String portfolioName;

    // One portfolio can hold many securities (via join table)
    @OneToMany(mappedBy = "portfolio", cascade = CascadeType.ALL)
    private List<PortfolioSecurity> portfolioSecurities;

    // Required no-arg constructor for JPA
    public Portfolio() {}

    public Portfolio(Client client, String portfolioName) {
        this.client        = client;
        this.portfolioName = portfolioName;
    }

    // ── Getters ───────────────────────────────────────────────────────────────

    public long getPortfolioId() {
        return portfolioId;
    }

    public Client getClient() {
        return client;
    }

    public String getPortfolioName() {
        return portfolioName;
    }

    public List<PortfolioSecurity> getPortfolioSecurities() {
        return portfolioSecurities;
    }

    // ── Setters (no setter for id) ────────────────────────────────────────────

    public void setClient(Client client) {
        this.client = client;
    }

    public void setPortfolioName(String portfolioName) {
        this.portfolioName = portfolioName;
    }

    public void setPortfolioSecurities(List<PortfolioSecurity> portfolioSecurities) {
        this.portfolioSecurities = portfolioSecurities;
    }
}
