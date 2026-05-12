package com.example.demo;

public class Tenant {

    private String tenantName;
    private String roomNumber;

    private boolean isPaid;

    private double monthlyRent;

    private double totalDebt;

    private int missedMonths;

    private boolean isEvicted;

    private int paidStreak;

    public Tenant(String tenantName,
                  String roomNumber,
                  boolean isPaid,
                  double monthlyRent,
                  double totalDebt,
                  int missedMonths,
                  boolean isEvicted,
                  int paidStreak) {

        this.tenantName = tenantName;
        this.roomNumber = roomNumber;
        this.isPaid = isPaid;
        this.monthlyRent = monthlyRent;
        this.totalDebt = totalDebt;
        this.missedMonths = missedMonths;
        this.isEvicted = isEvicted;
        this.paidStreak = paidStreak;
    }

    public String getTenantName() {
        return tenantName;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public boolean getIsPaid() {
        return isPaid;
    }

    public double getMonthlyRent() {
        return monthlyRent;
    }

    public double getTotalDebt() {
        return totalDebt;
    }

    public int getMissedMonths() {
        return missedMonths;
    }

    public boolean getIsEvicted() {
        return isEvicted;
    }

    public int getPaidStreak() {
        return paidStreak;
    }

    public void setPaid(boolean paid) {
        isPaid = paid;
    }

    public void setTotalDebt(double totalDebt) {
        this.totalDebt = totalDebt;
    }

    public void setMissedMonths(int missedMonths) {
        this.missedMonths = missedMonths;
    }

    public void setEvicted(boolean evicted) {
        isEvicted = evicted;
    }

    public void setPaidStreak(int paidStreak) {
        this.paidStreak = paidStreak;
    }
}