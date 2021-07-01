package com.ragp.programs.program1.transactions;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Transactions {

    private List<Transaction> transactions;

    public Transactions() {
        this.transactions = new ArrayList<>();
    }

    public List<Transaction> getLastXMonthsList(int begin, int end) {
        if (end >= begin) {
            begin = 3;
            end = 0;
        }

        Date dateBegin = Date.from(LocalDate.now().minusMonths(begin).atStartOfDay(ZoneId.systemDefault()).toInstant());
        Date dateEnd = Date.from(LocalDate.now().minusMonths(end).plusDays(1).atStartOfDay(ZoneId.systemDefault()).toInstant());

        List<Transaction> transactionsFiltered = new ArrayList<>();
        transactions.stream().filter(transaction -> transaction.getDate().compareTo(dateBegin) > 0 &&
                                     transaction.getDate().compareTo(dateEnd) <= 0).
                                     forEach(transaction -> transactionsFiltered.add(transaction));
        return transactionsFiltered;
    }

    public void addTransaction(int amount) {
        this.transactions.add(new Transaction(amount));
    }

    public int[] getRewardsPerMonthLast3Months() {
        int[] rewards = new int[3];
        for (int i=0; i<3; i++) {
            List<Transaction> transactions = getLastXMonthsList(i+1, i);
            rewards[i] = transactions.stream().mapToInt(transaction -> transaction.getReward()).sum();
        }
        return rewards;
    }
}
