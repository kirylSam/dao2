package org.DAO.ModelObjs;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.List;

@XmlRootElement(name = "doctors")
public class Doctors {
    private List<Doctor> doctors;

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
