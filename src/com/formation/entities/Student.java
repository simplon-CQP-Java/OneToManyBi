package com.formation.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Student implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private long studentId;
    private String studentName;

    @OneToMany(mappedBy = "student")
    private List<Phone> studentPhoneNumbers;


    public String getStudentName() {
	return studentName;
    }

    public void setStudentName(String studentName) {
	this.studentName = studentName;
    }

    public List<Phone> getStudentPhoneNumbers() {
	return studentPhoneNumbers;
    }

    public void setStudentPhoneNumbers(List<Phone> studentPhoneNumbers) {
	this.studentPhoneNumbers = studentPhoneNumbers;
    }

    @Override
    public String toString() {
	return "Student [studentId=" + studentId + ", studentName=" + studentName + ", studentPhoneNumbers="
		+ studentPhoneNumbers + "]";
    }

}
