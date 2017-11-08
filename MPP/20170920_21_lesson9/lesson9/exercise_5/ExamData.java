package lesson9.exercise_5;

public class ExamData {
	private String studentName;
	private double testScore;
	public ExamData(String name, double score) {
		studentName = name;
		testScore = score;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public double getTestScore() {
		return testScore;
	}
	public void setTestScore(double testScore) {
		this.testScore = testScore;
	}
}
