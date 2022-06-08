package com.example.texo.dto;

public class WinnerProducersDTO {
    private String name;
    private Integer minimo;
    private Integer maximo;
    private Integer interval;

    public WinnerProducersDTO(String name, Integer minimo, Integer maximo, Integer interval) {
        this.name = name;
        this.minimo = minimo;
        this.maximo = maximo;
        this.interval = interval;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getMinimo() {
        return minimo;
    }

    public void setMinimo(Integer minimo) {
        this.minimo = minimo;
    }

    public Integer getMaximo() {
        return maximo;
    }

    public void setMaximo(Integer maximo) {
        this.maximo = maximo;
    }

    public Integer getInterval() {
        return interval;
    }

    public void setInterval(Integer interval) {
        this.interval = interval;
    }
}
