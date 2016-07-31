package model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table
@NamedQuery(name = "find emp by id", query = "select e from Emp e where e.empId=:id")
public class Emp {

@Id
@GeneratedValue(strategy= GenerationType.AUTO)
private int empId;
private String empName;
private double empSalary;

public int getEid() {
	return empId;
}
public void setEid(int eid) {
	this.empId = eid;
}
public String getEname() {
	return empName;
}
public void setEname(String ename) {
	this.empName = ename;
}
public double getSalary() {
	return empSalary;
}
public void setSalary(double salary) {
	this.empSalary = salary;
}
}
