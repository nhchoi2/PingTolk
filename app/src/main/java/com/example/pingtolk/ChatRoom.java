package com.example.pingtolk;

public class ChatRoom {
    private String code;
    private String createdBy;

    // 기본 생성자 (Firestore 등에서 필요)
    public ChatRoom() {
    }

    public ChatRoom(String code, String createdBy) {
        this.code = code;
        this.createdBy = createdBy;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }
}
