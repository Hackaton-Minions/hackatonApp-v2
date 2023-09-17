package com.example.edusphere.domain.model.events;

public class Sign {
    private String day;
    private String time;
    private String name_teacher;
    private String subject;

    public Sign(String day, String time, String nameTeacher, String subject) {
        this.day = day;
        this.time = time;
        name_teacher = nameTeacher;
        this.subject = subject;
    }

    public String getDay() {
        return day;
    }

    public String getTime() {
        return time;
    }

    public String getSubject() {
        return subject;
    }

    public String getName_teacher() {
        return name_teacher;
    }
}
