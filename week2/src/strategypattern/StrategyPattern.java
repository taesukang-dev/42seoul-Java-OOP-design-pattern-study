package strategypattern;

import java.util.ArrayList;

interface PointStrategy {
    public void showGradeInfo(Subject subject);
}

class MinorStrategy implements PointStrategy {
    @Override
    public void showGradeInfo(Subject subject) {
        int score = subject.getScorePoint();
        if (score >= 90)
            System.out.println(subject.getName() + "과목 성적은 " + score + "점 이고, 학점은 A입니다.");
        else if (score >= 80)
            System.out.println(subject.getName() + "과목 성적은 " + score + "점 이고, 학점은 B입니다.");
        else if (score >= 70)
            System.out.println(subject.getName() + "과목 성적은 " + score + "점 이고, 학점은 C입니다.");
        else if (score >= 55)
            System.out.println(subject.getName() + "과목 성적은 " + score + "점 이고, 학점은 D입니다.");
        else
            System.out.println(subject.getName() + "과목 성적은 " + score + "점 이고, 학점은 F입니다.");
    }
}

class MajorStrategy implements PointStrategy {

    @Override
    public void showGradeInfo(Subject subject) {
        int score = subject.getScorePoint();
        if (score >= 95)
            System.out.println(subject.getName() + "과목 성적은 " + score + "점 이고, 학점은 S입니다.");
        else if (score >= 90)
            System.out.println(subject.getName() + "과목 성적은 " + score + "점 이고, 학점은 A입니다.");
        else if (score >= 80)
            System.out.println(subject.getName() + "과목 성적은 " + score + "점 이고, 학점은 B입니다.");
        else if (score >= 70)
            System.out.println(subject.getName() + "과목 성적은 " + score + "점 이고, 학점은 C입니다.");
        else if (score >= 60)
            System.out.println(subject.getName() + "과목 성적은 " + score + "점 이고, 학점은 D입니다.");
        else
            System.out.println(subject.getName() + "과목 성적은 " + score + "점 이고, 학점은 F입니다.");
    }
}

class Subject {
    private String name;
    private int scorePoint;
    private boolean majorCode;
    private PointStrategy ps;

    public PointStrategy getPs() {
        return ps;
    }

    public void setPs(PointStrategy ps) {
        this.ps = ps;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScorePoint() {
        return scorePoint;
    }

    public void setScorePoint(int scorePoint) {
        this.scorePoint = scorePoint;
    }

    public boolean isMajorCode() {
        return majorCode;
    }

    public void setMajorCode(boolean majorCode) {
        this.majorCode = majorCode;
    }
}

class Student {
    int studentID;
    String studentName;
    ArrayList<Subject> subjectList;
    private MajorStrategy ms;
    private MinorStrategy bs;

    public static final int BASIC = 0;
    public static final int MAJOR = 1;

    public void setMs(MajorStrategy ms) {
        this.ms = ms;
    }

    public void setBs(MinorStrategy bs) {
        this.bs = bs;
    }

    public Student(int studentID, String studentName) {
        this.studentID = studentID;
        this.studentName = studentName;
        subjectList = new ArrayList<>();
    }

    public void addSubject(String name, int score, boolean majorCode) {
        Subject subject = new Subject();
        if (majorCode == true)
            subject.setPs(new MajorStrategy());
        else
            subject.setPs(new MinorStrategy());
        subject.setName(name);
        subject.setScorePoint(score);
        subject.setMajorCode(majorCode);
        subjectList.add(subject);
    }

    public void showGradeInfo() {
        for (Subject subject : subjectList) {
            subject.getPs().showGradeInfo(subject);
        }
    }
}

public class StrategyPattern {
    public static void main(String[] args) {
        Student studentLee = new Student(1001, "Lee");
        studentLee.setBs(new MinorStrategy());
        studentLee.setMs(new MajorStrategy());
        studentLee.addSubject("국어", 100, false);
        studentLee.addSubject("수학", 100, true);

        Student studentKim = new Student(1002, "Kim");
        studentKim.addSubject("국어", 55, true);
        studentKim.addSubject("수학", 55, false);
        studentKim.addSubject("영어", 100, false);
        studentKim.setBs(new MinorStrategy());
        studentKim.setMs(new MajorStrategy());

        studentLee.showGradeInfo();
        studentKim.showGradeInfo();
    }
}
