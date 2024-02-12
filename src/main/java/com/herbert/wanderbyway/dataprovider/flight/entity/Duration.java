package com.herbert.wanderbyway.dataprovider.flight.entity;

public class Duration {
    Integer departure;
    Integer return_;
    Integer total;

    public Duration() {

    }

    public Integer getDeparture() {
        return departure;
    }

    public void setDeparture(Integer departure) {
        this.departure = departure;
    }

    public Integer getReturn_() {
        return return_;
    }

    public void setReturn_(Integer return_) {
        this.return_ = return_;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }
}
