package org.DAO.ModelObjs;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.List;

@XmlRootElement(name = "nurses")
public class Nurses {
    private List<Nurse> nurses;

    public List<Nurse> getNurses() {
        return nurses;
    }

    @XmlElement(name = "nurse")
    public void setNurses(List<Nurse> nurses) {
        this.nurses = nurses;
    }

    @Override
    public String toString() {
        return nurses.toString();
    }
}
