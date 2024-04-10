package gki2;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

interface IEmployee {
    void showInfo();
}

class Employee implements IEmployee {
    private static int employeeCount;
    private String id;
    private String fullName;
    private String birthDay;
    private String phone;
    private String email;
    private String employeeType;

    public Employee(String id, String fullName, String birthDay, String phone, String email, String employeeType) {
        this.setId(id);
        this.fullName = fullName;
        this.birthDay = birthDay;
        this.phone = phone;
        this.email = email;
        this.employeeType = employeeType;
        employeeCount++;
    }

    public void showInfo() {
        System.out.println("ID: " + getId());
        System.out.println("Full Name: " + fullName);
        System.out.println("Birth Day: " + birthDay);
        System.out.println("Phone: " + phone);
        System.out.println("Email: " + email);
        System.out.println("Employee Type: " + employeeType);
    }

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}

class Experience extends Employee {
    private int expInYear;
    private String proSkill;

    public Experience(String id, String fullName, String birthDay, String phone, String email, int expInYear, String proSkill) {
        super(id, fullName, birthDay, phone, email, "Experience");
        this.setExpInYear(expInYear);
        this.setProSkill(proSkill);
    }

	public int getExpInYear() {
		return expInYear;
	}

	public void setExpInYear(int expInYear) {
		this.expInYear = expInYear;
	}

	public String getProSkill() {
		return proSkill;
	}

	public void setProSkill(String proSkill) {
		this.proSkill = proSkill;
	}
}

class Fresher extends Employee {
    private String graduationDate;
    private String graduationRank;
    private String education;

    public Fresher(String id, String fullName, String birthDay, String phone, String email, String graduationDate, String graduationRank, String education) {
        super(id, fullName, birthDay, phone, email, "Fresher");
        this.setGraduationDate(graduationDate);
        this.setGraduationRank(graduationRank);
        this.setEducation(education);
    }

	public String getGraduationDate() {
		return graduationDate;
	}

	void setGraduationDate(String graduationDate) {
		this.graduationDate = graduationDate;
	}

	public String getGraduationRank() {
		return graduationRank;
	}

	public void setGraduationRank(String graduationRank) {
		this.graduationRank = graduationRank;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}
}

class Intern extends Employee {
    private String majors;
    private int semester;
    private String universityName;

    public Intern(String id, String fullName, String birthDay, String phone, String email, String majors, int semester, String universityName) {
        super(id, fullName, birthDay, phone, email, "Intern");
        this.setMajors(majors);
        this.setSemester(semester);
        this.setUniversityName(universityName);
    }

	public String getMajors() {
		return majors;
	}

	public void setMajors(String majors) {
		this.majors = majors;
	}

	public int getSemester() {
		return semester;
	}

	public void setSemester(int semester) {
		this.semester = semester;
	}

	public String getUniversityName() {
		return universityName;
	}

	public void setUniversityName(String universityName) {
		this.universityName = universityName;
	}
}

                