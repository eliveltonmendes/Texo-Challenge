package com.example.texo.dto;

public class AwardIntervalDTO {
    private String producer;
    private Integer interval;
    private Integer previousWin;
    private Integer followinWin;

    public AwardIntervalDTO(String producer, Integer interval, Integer previousWin, Integer followinWin) {
        this.producer = producer;
        this.interval = interval;
        this.previousWin = previousWin;
        this.followinWin = followinWin;
    }
    public AwardIntervalDTO() {}
    public String getProducer() {
        return producer;
    }
    public void setProducer(String producer) {
        this.producer = producer;
    }
    public Integer getInterval() {
        return interval;
    }
    public void setInterval(Integer interval) {
        this.interval = interval;
    }
    public Integer getPreviousWin() {
        return previousWin;
    }
    public void setPreviousWin(Integer previousWin) {
        this.previousWin = previousWin;
    }
    public Integer getFollowinWin() {
        return followinWin;
    }
    public void setFollowinWin(Integer followinWin) {
        this.followinWin = followinWin;
    }
    
    

    
}
