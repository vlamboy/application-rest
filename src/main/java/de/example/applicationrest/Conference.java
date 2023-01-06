package de.example.applicationrest;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class Conference {

    @Id
    @GeneratedValue
    private long id;
    private String conferenceName;
    private String conferenceDescription;
    private Date conferenceDate;
    private String location;

    public Conference(long id, String conferenceName, String conferenceDescription, Date conferenceDate, String location) {
        this.id = id;
        this.conferenceName = conferenceName;
        this.conferenceDescription = conferenceDescription;
        this.conferenceDate = conferenceDate;
        this.location = location;
    }

    public Conference() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getConferenceName() {
        return conferenceName;
    }

    public void setConferenceName(String conferenceName) {
        this.conferenceName = conferenceName;
    }

    public String getConferenceDescription() {
        return conferenceDescription;
    }

    public void setConferenceDescription(String conferenceDescription) {
        this.conferenceDescription = conferenceDescription;
    }

    public Date getConferenceDate() {
        return conferenceDate;
    }

    public void setConferenceDate(Date conferenceDate) {
        this.conferenceDate = conferenceDate;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Conference{" +
                "id=" + id +
                ", conferenceName='" + conferenceName + '\'' +
                ", conferenceDescription='" + conferenceDescription + '\'' +
                ", conferenceDate=" + conferenceDate +
                ", location='" + location + '\'' +
                '}';
    }
}
