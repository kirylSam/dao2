package org.DAO.ModelObjs;

import com.fasterxml.jackson.annotation.JsonGetter;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

import java.util.List;

@XmlRootElement(name = "nurses")
public class Nurses {
    private List<Nurse> nurses;

    @JsonGetter
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
