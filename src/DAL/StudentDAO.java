package DAL;

import BE.Student;
import BE.Subject;
import BE.Teacher;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class StudentDAO {
    private final LocalDateTime today = LocalDateTime.of(2022,Month.FEBRUARY,21,16,20); //"i dag" En falsk dato

    public Map<String,Integer> getStudentAttendance(Student student){
        int scoNotAttended = 0;
        int sdeNotAttended = 0;
        int itoNotAttended = 0;
        int dboNotAttended = 0;
        int attended = 0;

        ArrayList<Subject> allStudentSubjects = student.getSubjectList();
        Map<String, Integer> map = new HashMap<>();
        for(Subject s : allStudentSubjects){
            if (s.getAttended() && today.isAfter(s.getDate())){
                attended++;
            }
            if(!s.getAttended()){
                switch (s.getSubjectName()){
                    case "SCO" -> scoNotAttended++;
                    case "DBO" -> dboNotAttended++;
                    case "ITO" -> itoNotAttended++;
                    case "SDE" -> sdeNotAttended++;
                }
            }
        }
        map.put("SCO", scoNotAttended);
        map.put("SDE", sdeNotAttended);
        map.put("DBO", dboNotAttended);
        map.put("ITO", itoNotAttended);
        map.put("ATTENDED", attended);

        return map;
    }

    public ArrayList<Student> getAllStudents(){
    ArrayList<Student> allStudents = new ArrayList<>();
        allStudents.add(new Student("karsten","images/flemming.jpeg",get1stYear()));
        return allStudents;
    }

    public ObservableList<Subject> getRecentLessons(Student student){
        ArrayList<Subject> allLessons = student.getSubjectList();
        ObservableList<Subject> recentLessons = FXCollections.observableArrayList();
        LocalDateTime aWeekAgo = today.minus(1, ChronoUnit.WEEKS);
        for (Subject s : allLessons){
            if (s.getDate().isAfter(aWeekAgo) && s.getDate().isBefore(today)){
                recentLessons.add(s);
            }
        }
        return recentLessons;
    }

    /**
     * Henter alle lektioner for 3 uger.
     * uge 1 som er overstået.
     * uge 2 som vi befinder os i nu.
     * uge 3 er i fremtiden.
     * @return en liste af alle planlagte lektioner for eleverne
     */
    private ArrayList<Subject> get1stYear(){
        ArrayList<Subject> lessonsInSemester = new ArrayList<>();
        //Uge 1
        lessonsInSemester.addAll(monday(7));
        lessonsInSemester.addAll(tuesday(8));
        lessonsInSemester.addAll(wednesday(9));
        lessonsInSemester.addAll(thursday(10));
        lessonsInSemester.addAll(friday(11));
        //Uge 2
        lessonsInSemester.addAll(monday(14));
        lessonsInSemester.addAll(tuesday(15));
        lessonsInSemester.addAll(wednesday(16));
        lessonsInSemester.addAll(thursday(17));
        lessonsInSemester.addAll(friday(18));
        //Uge 3
        lessonsInSemester.addAll(monday(21));
        lessonsInSemester.addAll(tuesday(22));
        lessonsInSemester.addAll(wednesday(23));
        lessonsInSemester.addAll(thursday(24));
        lessonsInSemester.addAll(friday(25));
        return lessonsInSemester;
    }
    private ArrayList<Subject> monday(int dayOfMonth){
        Teacher teacher1 = new Teacher("Jørgen Holm");
        Teacher teacher2 = new Teacher("Simon Nielsen");
        Teacher teacher3 = new Teacher("Kirstine Petersen");
        String sde = "SDE";
        ArrayList<int[]> timeList = getLessonStartTimes();

        ArrayList<Subject> monday = new ArrayList<>();
        monday.add(new Subject(sde,teacher1,LocalDateTime.of(2022,Month.FEBRUARY,dayOfMonth,timeList.get(1)[0],timeList.get(1)[1])));
        monday.add(new Subject(sde,teacher1,LocalDateTime.of(2022,Month.FEBRUARY,dayOfMonth,timeList.get(2)[0],timeList.get(2)[1])));
        monday.add(new Subject(sde,teacher1,LocalDateTime.of(2022,Month.FEBRUARY,dayOfMonth,timeList.get(3)[0],timeList.get(3)[1])));
        //kom ikke i skole hele mandag
        for (Subject subject : monday) {
            subject.setAttended(false);
        }
        return monday;
    }
    private ArrayList<Subject> tuesday(int dayOfMonth){
        Teacher teacher3 = new Teacher("Kirstine Petersen");
        Teacher teacher2 = new Teacher("Simon Nielsen");
        ArrayList<int[]> timeList = getLessonStartTimes();
        String dbo = "dbo";
        String sco = "SCO";

        ArrayList<Subject> tuesday = new ArrayList<>();
        //dbo
        tuesday.add(new Subject(dbo,teacher3,LocalDateTime.of(2022,Month.FEBRUARY,dayOfMonth,timeList.get(0)[0],timeList.get(0)[1])));
        tuesday.add(new Subject(dbo,teacher3,LocalDateTime.of(2022,Month.FEBRUARY,dayOfMonth,timeList.get(1)[0],timeList.get(1)[1])));
        tuesday.add(new Subject(dbo,teacher3,LocalDateTime.of(2022,Month.FEBRUARY,dayOfMonth,timeList.get(2)[0],timeList.get(2)[1])));
        tuesday.add(new Subject(dbo,teacher3,LocalDateTime.of(2022,Month.FEBRUARY,dayOfMonth,timeList.get(3)[0],timeList.get(3)[1])));
        //sco
        tuesday.add(new Subject(sco,teacher2,LocalDateTime.of(2022,Month.FEBRUARY,dayOfMonth,timeList.get(4)[0],timeList.get(4)[1])));
        tuesday.add(new Subject(sco,teacher2,LocalDateTime.of(2022,Month.FEBRUARY,dayOfMonth,timeList.get(5)[0],timeList.get(5)[1])));
        tuesday.add(new Subject(sco,teacher2,LocalDateTime.of(2022,Month.FEBRUARY,dayOfMonth,timeList.get(6)[0],timeList.get(6)[1])));
        return tuesday;
    }
    private ArrayList<Subject> wednesday(int dayOfMonth){
        Teacher teacher1 = new Teacher("Jørgen Holm");
        Teacher teacher2 = new Teacher("Simon Nielsen");
        Teacher teacher3 = new Teacher("Kirstine Petersen");
        String sco = "SCO";
        String sde = "SDE";
        ArrayList<int[]> timeList = getLessonStartTimes();
        ArrayList<Subject> wednesday = new ArrayList<>();
        wednesday.add(new Subject(sco,teacher2,LocalDateTime.of(2022,Month.FEBRUARY,dayOfMonth,timeList.get(1)[0],timeList.get(1)[1])));
        wednesday.add(new Subject(sco,teacher2,LocalDateTime.of(2022,Month.FEBRUARY,dayOfMonth,timeList.get(2)[0],timeList.get(2)[1])));
        wednesday.add(new Subject(sco,teacher2,LocalDateTime.of(2022,Month.FEBRUARY,dayOfMonth,timeList.get(3)[0],timeList.get(3)[1])));

        wednesday.add(new Subject(sde,teacher1,LocalDateTime.of(2022,Month.FEBRUARY,dayOfMonth,timeList.get(4)[0],timeList.get(4)[1])));
        wednesday.add(new Subject(sde,teacher1,LocalDateTime.of(2022,Month.FEBRUARY,dayOfMonth,timeList.get(5)[0],timeList.get(5)[1])));
        wednesday.add(new Subject(sde,teacher1,LocalDateTime.of(2022,Month.FEBRUARY,dayOfMonth,timeList.get(6)[0],timeList.get(6)[1])));
        return wednesday;
    }
    private ArrayList<Subject> thursday(int dayOfMonth){
        Teacher teacher4 = new Teacher("Bjarne Olesen");
        String ito = "ITO";
        
        ArrayList<int[]> timeList = getLessonStartTimes();
        ArrayList<Subject> thursday = new ArrayList<>();
        thursday.add(new Subject(ito,teacher4,LocalDateTime.of(2022,Month.FEBRUARY,dayOfMonth,timeList.get(1)[0],timeList.get(1)[1])));
        thursday.add(new Subject(ito,teacher4,LocalDateTime.of(2022,Month.FEBRUARY,dayOfMonth,timeList.get(2)[0],timeList.get(2)[1])));
        thursday.add(new Subject(ito,teacher4,LocalDateTime.of(2022,Month.FEBRUARY,dayOfMonth,timeList.get(3)[0],timeList.get(3)[1])));
        thursday.add(new Subject(ito,teacher4,LocalDateTime.of(2022,Month.FEBRUARY,dayOfMonth,timeList.get(4)[0],timeList.get(4)[1])));
        
        return thursday;
    }
    private ArrayList<Subject> friday(int dayOfMonth){
        Teacher teacher4 = new Teacher("Bjarne Olesen");
        String sco = "SCO";
        
        ArrayList<int[]> timeList = getLessonStartTimes();
        ArrayList<Subject> friday = new ArrayList<>();
        friday.add(new Subject(sco,teacher4,LocalDateTime.of(2022,Month.FEBRUARY,dayOfMonth,timeList.get(1)[0],timeList.get(1)[1])));
        friday.add(new Subject(sco,teacher4,LocalDateTime.of(2022,Month.FEBRUARY,dayOfMonth,timeList.get(2)[0],timeList.get(2)[1])));
        friday.add(new Subject(sco,teacher4,LocalDateTime.of(2022,Month.FEBRUARY,dayOfMonth,timeList.get(3)[0],timeList.get(3)[1])));
        
        return friday;
    }
    private ArrayList<int[]> getLessonStartTimes(){
        int[] time0 = {8,15};
        int[] time1 = {9,0};
        int[] time2 = {9,45};
        int[] time3 = {10,30};
        int[] time4 = {12,0};
        int[] time5 = {12,45};
        int[] time6 = {13,30};
        ArrayList<int[]> timelist = new ArrayList<>();
        timelist.add(time0);
        timelist.add(time1);
        timelist.add(time2);
        timelist.add(time3);
        timelist.add(time4);
        timelist.add(time5);
        timelist.add(time6);

        return timelist;
    }


}
