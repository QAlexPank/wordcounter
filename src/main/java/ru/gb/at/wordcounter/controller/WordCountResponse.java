package ru.gb.at.wordcounter.controller;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class WordCountResponse implements Serializable {

    private Long idRequest;
    private Map<String, Long> mapCounts = new HashMap<>();

    public Long getIdRequest() {
        return idRequest;
    }

    public void setIdRequest(Long idRequest) {
        this.idRequest = idRequest;
    }

    public Map<String, Long> getMapCounts(Map<String, Long> stringLongMap) {
        return mapCounts;
    }

    public void setMapCounts(Map<String, Long> mapCounts) {
        this.mapCounts = mapCounts;
    }

    @Override
    public String toString() {
        return "WordCountResponse{" +
                "idRequest=" + idRequest +
                ", mapCounts=" + mapCounts +
                '}';
    }
}
