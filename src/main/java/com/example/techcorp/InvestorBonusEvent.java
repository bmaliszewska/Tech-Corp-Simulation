package com.example.techcorp;

public class InvestorBonusEvent implements GameEvent {

    @Override
    public void apply(Company company) {
        company.increaseBudget(7000);
    }

    @Override
    public String getDescription() {
        return "Investor bonus. Company received 7000.";
    }
}