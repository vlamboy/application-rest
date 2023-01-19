package de.example.applicationrest;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.Date;

@Entity
public class Conference {

    @Id
    @GeneratedValue
    private long id;
    private String conferenceName;
    private String conferenceDescription;
    private String conferenceLocation;

    public Conference(long id, String conferenceName, String conferenceDescription, String conferenceLocation) {
        this.id = id;
        this.conferenceName = conferenceName;
        this.conferenceDescription = conferenceDescription;
        this.conferenceLocation = conferenceLocation;
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

    public String getConferenceLocation() {
        return conferenceLocation;
    }

    public void setConferenceLocation(String conferenceLocation) {
        this.conferenceLocation = conferenceLocation;
    }

    @Override
    public String toString() {
        return "Conference{" +
                "id=" + id +
                ", conferenceName='" + conferenceName + '\'' +
                ", conferenceDescription='" + conferenceDescription + '\'' +
                ", location='" + conferenceLocation + '\'' +
                '}';
    }
}
