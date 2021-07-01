package com.ragp.programs.program1;

import com.ragp.programs.program1.transactions.Transaction;
import com.ragp.programs.program1.transactions.Transactions;

import java.util.List;

public class RewardsProgram {

    public static void main(String[] args) {
        Transactions transactions = new Transactions();
        transactions.addTransaction(120);
        transactions.addTransaction(150);
        transactions.addTransaction(200);

        List<Transaction> transactionList = transactions.getLastXMonthsList(3, 0);
        transactionList.forEach(transaction -> System.out.println(transaction.toString()));

        System.out.println("------------------------------------");
        System.out.println("Rewards by last 3 months");

        int[] rewards = transactions.getRewardsPerMonthLast3Months();
        for (int i : rewards) {
            System.out.println(i);
        }
    }

}
