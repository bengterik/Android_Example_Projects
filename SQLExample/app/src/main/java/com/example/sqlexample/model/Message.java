package com.example.sqlexample.model;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Message {
    private long id;
    private LocalDateTime timestamp;
    private String message;

    public Message(String text) {

    }

    public Message(long id, long timestamp, String text) {
        this.id=id;
        this.timestamp= Instant.ofEpochMilli(timestamp).atZone(ZoneId.systemDefault()).toLocalDateTime();
        this.message=text;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd:MM:yyyy HH:mm:ss z", Locale.ENGLISH);

        return "Message{" +
                "timestamp=" + timestamp.format(formatter) +
                ", message='" + message + '\'' +
                '}';
    }
}
