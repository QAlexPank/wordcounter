package ru.gb.at.wordcounter.controller;

import java.io.Serializable;

public class WordCountRequest implements Serializable {

    private Long idRequest;
    private String text;

    public WordCountRequest(Long idRequest, String text) {
        this.idRequest = idRequest;
        this.text = text;
    }

    public Long getIdRequest() {
        return idRequest;
    }

    public void setIdRequest(Long idRequest) {
        this.idRequest = idRequest;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

}
