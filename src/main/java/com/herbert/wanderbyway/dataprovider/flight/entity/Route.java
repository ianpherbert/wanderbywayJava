package com.herbert.wanderbyway.dataprovider.flight.entity;

class Route {
    String id;
    String combination_id;
    String flyFrom;
    String flyTo;
    String cityFrom;
    String cityCodeFrom;
    String cityTo;
    String cityCodeTo;
    String local_departure;
    String utc_departure;
    String local_arrival;
    String utc_arrival;
    String airline;
    Integer flight_no;
    String operating_carrier;
    String operating_flight_no;
    String fare_basis;
    String fare_category;
    String fare_classes;
    Integer return_;
    boolean bags_recheck_required;
    boolean vi_connection;
    boolean guarantee;
    String equipment;
    String vehicle_type;

    public Route() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCombination_id() {
        return combination_id;
    }

    public void setCombination_id(String combination_id) {
        this.combination_id = combination_id;
    }

    public String getFlyFrom() {
        return flyFrom;
    }

    public void setFlyFrom(String flyFrom) {
        this.flyFrom = flyFrom;
    }

    public String getFlyTo() {
        return flyTo;
    }

    public void setFlyTo(String flyTo) {
        this.flyTo = flyTo;
    }

    public String getCityFrom() {
        return cityFrom;
    }

    public void setCityFrom(String cityFrom) {
        this.cityFrom = cityFrom;
    }

    public String getCityCodeFrom() {
        return cityCodeFrom;
    }

    public void setCityCodeFrom(String cityCodeFrom) {
        this.cityCodeFrom = cityCodeFrom;
    }

    public String getCityTo() {
        return cityTo;
    }

    public void setCityTo(String cityTo) {
        this.cityTo = cityTo;
    }

    public String getCityCodeTo() {
        return cityCodeTo;
    }

    public void setCityCodeTo(String cityCodeTo) {
        this.cityCodeTo = cityCodeTo;
    }

    public String getLocal_departure() {
        return local_departure;
    }

    public void setLocal_departure(String local_departure) {
        this.local_departure = local_departure;
    }

    public String getUtc_departure() {
        return utc_departure;
    }

    public void setUtc_departure(String utc_departure) {
        this.utc_departure = utc_departure;
    }

    public String getLocal_arrival() {
        return local_arrival;
    }

    public void setLocal_arrival(String local_arrival) {
        this.local_arrival = local_arrival;
    }

    public String getUtc_arrival() {
        return utc_arrival;
    }

    public void setUtc_arrival(String utc_arrival) {
        this.utc_arrival = utc_arrival;
    }

    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

    public Integer getFlight_no() {
        return flight_no;
    }

    public void setFlight_no(Integer flight_no) {
        this.flight_no = flight_no;
    }

    public String getOperating_carrier() {
        return operating_carrier;
    }

    public void setOperating_carrier(String operating_carrier) {
        this.operating_carrier = operating_carrier;
    }

    public String getOperating_flight_no() {
        return operating_flight_no;
    }

    public void setOperating_flight_no(String operating_flight_no) {
        this.operating_flight_no = operating_flight_no;
    }

    public String getFare_basis() {
        return fare_basis;
    }

    public void setFare_basis(String fare_basis) {
        this.fare_basis = fare_basis;
    }

    public String getFare_category() {
        return fare_category;
    }

    public void setFare_category(String fare_category) {
        this.fare_category = fare_category;
    }

    public String getFare_classes() {
        return fare_classes;
    }

    public void setFare_classes(String fare_classes) {
        this.fare_classes = fare_classes;
    }

    public Integer getReturn_() {
        return return_;
    }

    public void setReturn_(Integer return_) {
        this.return_ = return_;
    }

    public boolean isBags_recheck_required() {
        return bags_recheck_required;
    }

    public void setBags_recheck_required(boolean bags_recheck_required) {
        this.bags_recheck_required = bags_recheck_required;
    }

    public boolean isVi_connection() {
        return vi_connection;
    }

    public void setVi_connection(boolean vi_connection) {
        this.vi_connection = vi_connection;
    }

    public boolean isGuarantee() {
        return guarantee;
    }

    public void setGuarantee(boolean guarantee) {
        this.guarantee = guarantee;
    }

    public String getEquipment() {
        return equipment;
    }

    public void setEquipment(String equipment) {
        this.equipment = equipment;
    }

    public String getVehicle_type() {
        return vehicle_type;
    }

    public void setVehicle_type(String vehicle_type) {
        this.vehicle_type = vehicle_type;
    }
}
