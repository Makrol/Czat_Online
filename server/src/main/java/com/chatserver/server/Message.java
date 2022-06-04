package com.chatserver.server;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Message {
    private @Id @GeneratedValue Long id;
    private String text;
    private Long srcId;
    private Long dstId;

    public Message() {
    }

    public Message(String text, Long srcId, Long dstId) {
        this.text = text;
        this.srcId = srcId;
        this.dstId = dstId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Long getSrcId() {
        return srcId;
    }

    public void setSrcId(Long srcId) {
        this.srcId = srcId;
    }

    public Long getDstId() {
        return dstId;
    }

    public void setDstId(Long dstId) {
        this.dstId = dstId;
    }
}
