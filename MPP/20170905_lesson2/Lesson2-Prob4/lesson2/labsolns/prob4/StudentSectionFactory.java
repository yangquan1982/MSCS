package lesson2.labsolns.prob4;

import java.util.*;

public class StudentSectionFactory {
	private static List<Student> students = new ArrayList<>(); 
	private static List<Section> sections = new ArrayList<>();
	
	public static Section createSection(int secNum, String courseName) {
		Section section = new Section();
		section.sectionNumber = secNum;
		section.courseName = courseName;
		sections.add(section);
		return section;
	}
	
	public static Student createStudent(String id, String name) {
		Student st = new Student();
		st.id = id;
		st.name = name;
		students.add(st);
		return st;
	}
		
	public static void newTranscriptEntry(
			Student s, Section sect, String grade) {
		//if TranscriptEntry does not exist, create one
		TranscriptEntry te = null;
		if((te = findTranscriptEntry(s, sect)) == null) {
			te = new TranscriptEntry();
			te.setStudent(s);
			te.setSection(sect);
			s.getGrades().add(te);
			sect.getGradeSheet().add(te);
		}
		//else, update this TranscriptEntry with a grade
		te.setGrade(grade);
		
	}
	
	public static List<Student> getStudents() {
		return Collections.unmodifiableList(students);
	}
	public static List<Section> getSections() {
		return Collections.unmodifiableList(sections);
	}
	
	/**
	 * Returns true if the student with specified id can
	 * be found in the list of students maintained here
	 */
	public static boolean studentExists(String id) {
		return (findStudent(id) != null);
	}
	
	/**
	 * Returns true if the section with specified section number can
	 * be found in the list of sections maintained here
	 */
	public static boolean sectionExists(int sectionNum) {
		return (findSection(sectionNum) != null);
	}
	
	public static void addStudentToSection(Section section, Student s) {
		TranscriptEntry te = new TranscriptEntry();
		te.student = s;
		te.section = section;
		section.gradeSheet.add(te);
		s.grades.add(te);
	}
	public static void addSectionForStudent(Student student, Section s) {
		TranscriptEntry te = new TranscriptEntry();
		te.student = student;
		te.section = s;
		student.grades.add(te);
		s.gradeSheet.add(te);
		
	}
	public static TranscriptEntry findTranscriptEntry(Student st, Section sect) {
		for(TranscriptEntry te: st.getGrades()) {
			if(te.getSection().equals(sect)) {
				return te;
			}
		}
		return null;
	}
	public static Student findStudent(String id) {
		for(Student s: students) {
			if(s.id.equals(id)) {
				return s;
			}
		}
		return null;
	}
	public static Section findSection(int secNum) {
		for(Section s: sections) {
			if(s.sectionNumber == secNum) {
				return s;
			}
		}
		return null;
	}
	
}
