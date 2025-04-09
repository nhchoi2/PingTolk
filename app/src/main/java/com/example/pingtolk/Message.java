package com.example.pingtolk;

public class Message {
    private String sender;
    private String text;
    private long timestamp;
    private boolean isDateSeparator;

    // 기본 생성자 (Firestore에서 필요)
    public Message() {
    }

    // 일반 메시지 생성자
    public Message(String sender, String text, long timestamp) {
        this.sender = sender;
        this.text = text;
        this.timestamp = timestamp;
        this.isDateSeparator = false;
    }

    // 날짜 구분용 메시지 생성자
    public static Message createDateSeparator(long timestamp) {
        Message msg = new Message();
        msg.sender = "";
        msg.text = "";
        msg.timestamp = timestamp;
        msg.isDateSeparator = true;
        return msg;
    }

    // Getter & Setter
    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public boolean isDateSeparator() {
        return isDateSeparator;
    }

    public void setDateSeparator(boolean dateSeparator) {
        isDateSeparator = dateSeparator;
    }
}
