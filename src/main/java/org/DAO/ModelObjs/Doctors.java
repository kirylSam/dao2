package org.DAO.ModelObjs;

import com.fasterxml.jackson.annotation.JsonGetter;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

import java.util.List;

@XmlRootElement(name = "doctors")
public class Doctors {
    private List<Doctor> doctors;

    @JsonGetter
    public List<Doctor> getDoctors() {
        return doctors;
    }

    @XmlElement(name = "doctor")
    public void setDoctors(List<Doctor> doctors) {
        this.doctors = doctors;
    }

    @Override
    public String toString() {
        return doctors.toString();
    }
}
