package com.herbert.wanderbyway.dataprovider.flight.entity;

import java.util.List;

public class Flight {
    String id;
    String flyFrom;
    String flyTo;
    String cityFrom;
    String cityCodeFrom;
    String cityTo;
    String cityCodeTo;
    Country countryFrom;
    Country countryTo;
    String local_departure;
    String utc_departure;
    String local_arrival;
    String utc_arrival;
    Integer nightsInDest;
    Double quality;
    Double distance;
    Duration duration;
    Integer price;
    Conversion conversion;
    Fare fare;
    PriceDropdown price_dropdown;
    BagsPrice bags_price;
    BagLimit baglimit;
    Availability availability;
    List<String> airlines;
    List<Route> route;
    String booking_token;
    boolean facilitated_booking_available;
    Integer pnr_count;
    boolean has_airport_change;
    Integer technical_stops;
    boolean throw_away_ticketing;
    boolean hidden_city_ticketing;
    boolean virtual_interlining;

    public Flight() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public Country getCountryFrom() {
        return countryFrom;
    }

    public void setCountryFrom(Country countryFrom) {
        this.countryFrom = countryFrom;
    }

    public Country getCountryTo() {
        return countryTo;
    }

    public void setCountryTo(Country countryTo) {
        this.countryTo = countryTo;
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

    public Integer getNightsInDest() {
        return nightsInDest;
    }

    public void setNightsInDest(Integer nightsInDest) {
        this.nightsInDest = nightsInDest;
    }

    public Double getQuality() {
        return quality;
    }

    public void setQuality(Double quality) {
        this.quality = quality;
    }

    public Double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }

    public Duration getDuration() {
        return duration;
    }

    public void setDuration(Duration duration) {
        this.duration = duration;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Conversion getConversion() {
        return conversion;
    }

    public void setConversion(Conversion conversion) {
        this.conversion = conversion;
    }

    public Fare getFare() {
        return fare;
    }

    public void setFare(Fare fare) {
        this.fare = fare;
    }

    public PriceDropdown getPrice_dropdown() {
        return price_dropdown;
    }

    public void setPrice_dropdown(PriceDropdown price_dropdown) {
        this.price_dropdown = price_dropdown;
    }

    public BagsPrice getBags_price() {
        return bags_price;
    }

    public void setBags_price(BagsPrice bags_price) {
        this.bags_price = bags_price;
    }

    public BagLimit getBaglimit() {
        return baglimit;
    }

    public void setBaglimit(BagLimit baglimit) {
        this.baglimit = baglimit;
    }

    public Availability getAvailability() {
        return availability;
    }

    public void setAvailability(Availability availability) {
        this.availability = availability;
    }

    public List<String> getAirlines() {
        return airlines;
    }

    public void setAirlines(List<String> airlines) {
        this.airlines = airlines;
    }

    public List<Route> getRoute() {
        return route;
    }

    public void setRoute(List<Route> route) {
        this.route = route;
    }

    public String getBooking_token() {
        return booking_token;
    }

    public void setBooking_token(String booking_token) {
        this.booking_token = booking_token;
    }

    public boolean isFacilitated_booking_available() {
        return facilitated_booking_available;
    }

    public void setFacilitated_booking_available(boolean facilitated_booking_available) {
        this.facilitated_booking_available = facilitated_booking_available;
    }

    public Integer getPnr_count() {
        return pnr_count;
    }

    public void setPnr_count(Integer pnr_count) {
        this.pnr_count = pnr_count;
    }

    public boolean isHas_airport_change() {
        return has_airport_change;
    }

    public void setHas_airport_change(boolean has_airport_change) {
        this.has_airport_change = has_airport_change;
    }

    public Integer getTechnical_stops() {
        return technical_stops;
    }

    public void setTechnical_stops(Integer technical_stops) {
        this.technical_stops = technical_stops;
    }

    public boolean isThrow_away_ticketing() {
        return throw_away_ticketing;
    }

    public void setThrow_away_ticketing(boolean throw_away_ticketing) {
        this.throw_away_ticketing = throw_away_ticketing;
    }

    public boolean isHidden_city_ticketing() {
        return hidden_city_ticketing;
    }

    public void setHidden_city_ticketing(boolean hidden_city_ticketing) {
        this.hidden_city_ticketing = hidden_city_ticketing;
    }

    public boolean isVirtual_interlining() {
        return virtual_interlining;
    }

    public void setVirtual_interlining(boolean virtual_interlining) {
        this.virtual_interlining = virtual_interlining;
    }

}

