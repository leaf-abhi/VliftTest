package com.example.toni.vlifttest.model;

public class NewLead {
    private String name;
    private String quotes;
    private String workTitle;
    private String workDescription;
    private String time;
    private String credits;
    private String address;
    private double distanceKm;

    private NewLead() {

    }

    public String getName() {
        return name;
    }

    public String getQuotes() {
        return quotes;
    }

    public String getWorkTitle() {
        return workTitle;
    }

    public String getWorkDescription() {
        return workDescription;
    }

    public String getTime() {
        return time;
    }

    public String getCredits() {
        return credits;
    }

    public String getAddress() {
        return address;
    }

    public double getDistanceKm() {
        return distanceKm;
    }

    public static class Builder {
        private String name;
        private String quotes;
        private String workTitle;
        private String workDescription;
        private String time;
        private String credits;
        private String address;
        private double distanceKm;

        public Builder() {

        }

        public NewLead build() {
            NewLead newLead = new NewLead();
            newLead.address = this.address;
            newLead.name = this.name;
            newLead.quotes = this.quotes;
            newLead.workTitle = this.workTitle;
            newLead.workDescription = this.workDescription;
            newLead.time = this.time;
            newLead.credits = this.credits;
            newLead.distanceKm = this.distanceKm;

            return newLead;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setQuotes(String quotes) {
            this.quotes = quotes;
            return this;
        }

        public Builder setWorkTitle(String workTitle) {
            this.workTitle = workTitle;
            return this;
        }

        public Builder setWorkDescription(String workDescription) {
            this.workDescription = workDescription;
            return this;
        }

        public Builder setTime(String time) {
            this.time = time;
            return this;
        }

        public Builder setCredits(String credits) {
            this.credits = credits;
            return this;
        }

        public Builder setAddress(String address) {
            this.address = address;
            return this;
        }

        public Builder setDistanceKm(double distanceKm) {
            this.distanceKm = distanceKm;
            return this;
        }
    }
}
