package com.chatclient.client;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Message {
    @SerializedName("id")
    @Expose
    public Long id;
    @SerializedName("text")
    @Expose
    public String text;
    @SerializedName("srcId")
    @Expose
    public Long srcId;
    @SerializedName("dstId")
    @Expose
    public Long dstId;

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

