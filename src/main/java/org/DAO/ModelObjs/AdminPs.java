package org.DAO.ModelObjs;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.List;

@XmlRootElement(name = "admins")
public class AdminPs {
    private List<AdminP> admins;

    public List<AdminP> getAdminPs() {
        return admins;
    }

    @XmlElement(name = "admins")
    public void setAdminPs(List<AdminP> admins) {
        this.admins = admins;
    }

    @Override
    public String toString() {
        return admins.toString();
    }
}
