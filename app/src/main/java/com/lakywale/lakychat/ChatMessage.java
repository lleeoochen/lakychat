package com.lakywale.lakychat;

public class ChatMessage {

    public String sender;
    public String message;
    public long timestamp;

    public ChatMessage() {
        this.sender = "";
        this.message = "";
        this.timestamp = 0;
    }

    public ChatMessage(String sender, String message, long timestamp) {
        this.sender = sender;
        this.message = message;
        this.timestamp = timestamp;
    }
}
