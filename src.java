package model;

import java.time.LocalDate;

public class Streak {
    private int count;
    private LocalDate lastDate;

    public Streak(int count, LocalDate lastDate) {
        this.count = count;
        this.lastDate = lastDate;
    }

    public int getCount() {
        return count;
    }

    public void increment() {
        this.count++;
        this.lastDate = LocalDate.now();
    }

    public void reset() {
        this.count = 1;
        this.lastDate = LocalDate.now();
    }

    public LocalDate getLastDate() {
        return lastDate;
    }

    public void setLastDate(LocalDate date) {
        this.lastDate = date;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
