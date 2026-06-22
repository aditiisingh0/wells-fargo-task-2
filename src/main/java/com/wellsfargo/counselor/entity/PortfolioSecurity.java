package com.wellsfargo.counselor.entity;

import javax.persistence.*;

@Entity
@Table(name = "portfolio_security")
public class PortfolioSecurity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long portfolioSecurityId;

    // Many portfolio_security rows belong to one portfolio
    @ManyToOne
    @JoinColumn(name = "portfolio_id", nullable = false)
    private Portfolio portfolio;

    // Many portfolio_security rows reference one security
    @ManyToOne
    @JoinColumn(name = "security_id", nullable = false)
    private Security security;

    @Column(nullable = false)
    private int quantity;

    // Required no-arg constructor for JPA
    public PortfolioSecurity() {}

    public PortfolioSecurity(Portfolio portfolio, Security security, int quantity) {
        this.portfolio = portfolio;
        this.security  = security;
        this.quantity  = quantity;
    }

    // ── Getters ───────────────────────────────────────────────────────────────

    public long getPortfolioSecurityId() {
        return portfolioSecurityId;
    }

    public Portfolio getPortfolio() {
        return portfolio;
    }

    public Security getSecurity() {
        return security;
    }

    public int getQuantity() {
        return quantity;
    }

    // ── Setters (no setter for id) ────────────────────────────────────────────

    public void setPortfolio(Portfolio portfolio) {
        this.portfolio = portfolio;
    }

    public void setSecurity(Security security) {
        this.security = security;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
