package org.example;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "employees_table")
public class Employees {

    @Id
    @Column(name = "employees_id")
    private int eId;

    @Column(name = "employee_name")
    private String eName;

    @Column(name = "employee_department")
    private String department;

    public int geteId() {
        return eId;
    }

    public void seteId(int eId) {
        this.eId = eId;
    }

    public String geteName() {
        return eName;
    }

    public void seteName(String eName) {
        this.eName = eName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Employees{" +
                "eId=" + eId +
                ", eName='" + eName + '\'' +
                ", department='" + department + '\'' +
                '}';
    }
}
