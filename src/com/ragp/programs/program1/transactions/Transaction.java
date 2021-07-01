package com.ragp.programs.program1.transactions;

import java.util.Date;

public class Transaction {

    private int amount;
    private int reward;
    private Date date;

    public Transaction(int amount) {
        this.amount = amount;
        this.date = new Date();
        this.reward = calculateRewards(this.amount);
    }

    private int calculateRewards(int amount) {
        if (amount >=50 && amount < 100) {
            return amount-50;
        } else if (amount >100){
            return (2*(amount-100) + 50);
        }
        return 0;
    }

    public int getAmount() {
        return amount;
    }

    public int getReward() {
        return reward;
    }

    public Date getDate() {
        return date;
    }

    public String toString() {
        return "Date transaction: " + getDate() + "\nAmount: " + getAmount() + "\nReward: " + getReward() + "\n";

    }
}
