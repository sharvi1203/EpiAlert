package com.example.epialert;

import java.io.Serializable;

public class EpilepsySample implements Serializable {
    public String day;
    public String dateMonth;
    public String year;
    public String startTime;
    public String endTime;
    public String duration;
    public String bpSys;
    public String bpDys;
    public String bodyTemp;
    public String typeOfSeizure;
    public String oxygenLevel;
    public String muscleContraction;

    public EpilepsySample() {

    }

    public EpilepsySample(String day, String dateMonth, String year, String startTime, String endTime, String duration, String bpSys, String bpDys, String bodyTemp, String typeOfSeizure, String oxygenLevel, String muscleContraction) {
        this.day = day;
        this.dateMonth = dateMonth;
        this.year = year;
        this.startTime = startTime;
        this.endTime = endTime;
        this.duration = duration;
        this.bpSys = bpSys;
        this.bpDys = bpDys;
        this.bodyTemp = bodyTemp;
        this.typeOfSeizure = typeOfSeizure;
        this.oxygenLevel = oxygenLevel;
        this.muscleContraction = muscleContraction;
    }

    @Override
    public String toString() {
        return "EpilepsySample{" +
                "day='" + day + '\'' +
                ", dateMonth='" + dateMonth + '\'' +
                ", year='" + year + '\'' +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", duration='" + duration + '\'' +
                ", bpSys='" + bpSys + '\'' +
                ", bpDys='" + bpDys + '\'' +
                ", bodyTemp='" + bodyTemp + '\'' +
                ", typeOfSeizure='" + typeOfSeizure + '\'' +
                ", oxygenLevel='" + oxygenLevel + '\'' +
                ", muscleContraction='" + muscleContraction + '\'' +
                '}';
    }
}
