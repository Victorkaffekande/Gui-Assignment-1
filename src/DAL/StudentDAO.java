package DAL;

import BE.Student;
import BE.Lesson;
import BE.Teacher;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

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

        ArrayList<Lesson> allStudentLessons = student.getLessonList();
        Map<String, Integer> map = new HashMap<>();
        for(Lesson l : allStudentLessons){
            if (l.getAttended() && today.isAfter(l.getDate())){
                attended++;
            }
            if(!l.getAttended()){
                switch (l.getSubjectName()){
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

    public ObservableList<Lesson> getRecentLessons(Student student){
        ArrayList<Lesson> allLessons = student.getLessonList();
        ObservableList<Lesson> recentLessons = FXCollections.observableArrayList();
        LocalDateTime aWeekAgo = today.minus(1, ChronoUnit.WEEKS);
        for (Lesson s : allLessons){
            if (s.getDate().isAfter(aWeekAgo) && s.getDate().isBefore(today)){
                recentLessons.add(s);
            }
        }
        return recentLessons;
    }

    public ObservableList<Lesson> getTodaysLessons(){
        ///TODO
        return null;
    }

    /**
     * Henter alle lektioner for 3 uger.
     * uge 1 som er overstået.
     * uge 2 som vi befinder os i nu.
     * uge 3 er i fremtiden.
     * @return en liste af alle planlagte lektioner for eleverne
     */
    private ArrayList<Lesson> get1stYear(){
        ArrayList<Lesson> lessonsInSemester = new ArrayList<>();
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
    private ArrayList<Lesson> monday(int dayOfMonth){
        Teacher teacher1 = new Teacher("Jørgen Holm");
        Teacher teacher2 = new Teacher("Simon Nielsen");
        Teacher teacher3 = new Teacher("Kirstine Petersen");
        String sde = "SDE";
        ArrayList<int[]> timeList = getLessonStartTimes();

        ArrayList<Lesson> monday = new ArrayList<>();
        monday.add(new Lesson(sde,teacher1,LocalDateTime.of(2022,Month.FEBRUARY,dayOfMonth,timeList.get(1)[0],timeList.get(1)[1])));
        monday.add(new Lesson(sde,teacher1,LocalDateTime.of(2022,Month.FEBRUARY,dayOfMonth,timeList.get(2)[0],timeList.get(2)[1])));
        monday.add(new Lesson(sde,teacher1,LocalDateTime.of(2022,Month.FEBRUARY,dayOfMonth,timeList.get(3)[0],timeList.get(3)[1])));
        //kom ikke i skole hele mandag
        for (Lesson lesson : monday) {
            lesson.setAttended(false);
        }
        return monday;
    }
    private ArrayList<Lesson> tuesday(int dayOfMonth){
        Teacher teacher3 = new Teacher("Kirstine Petersen");
        Teacher teacher2 = new Teacher("Simon Nielsen");
        ArrayList<int[]> timeList = getLessonStartTimes();
        String dbo = "dbo";
        String sco = "SCO";

        ArrayList<Lesson> tuesday = new ArrayList<>();
        //dbo
        tuesday.add(new Lesson(dbo,teacher3,LocalDateTime.of(2022,Month.FEBRUARY,dayOfMonth,timeList.get(0)[0],timeList.get(0)[1])));
        tuesday.add(new Lesson(dbo,teacher3,LocalDateTime.of(2022,Month.FEBRUARY,dayOfMonth,timeList.get(1)[0],timeList.get(1)[1])));
        tuesday.add(new Lesson(dbo,teacher3,LocalDateTime.of(2022,Month.FEBRUARY,dayOfMonth,timeList.get(2)[0],timeList.get(2)[1])));
        tuesday.add(new Lesson(dbo,teacher3,LocalDateTime.of(2022,Month.FEBRUARY,dayOfMonth,timeList.get(3)[0],timeList.get(3)[1])));
        //sco
        tuesday.add(new Lesson(sco,teacher2,LocalDateTime.of(2022,Month.FEBRUARY,dayOfMonth,timeList.get(4)[0],timeList.get(4)[1])));
        tuesday.add(new Lesson(sco,teacher2,LocalDateTime.of(2022,Month.FEBRUARY,dayOfMonth,timeList.get(5)[0],timeList.get(5)[1])));
        tuesday.add(new Lesson(sco,teacher2,LocalDateTime.of(2022,Month.FEBRUARY,dayOfMonth,timeList.get(6)[0],timeList.get(6)[1])));
        return tuesday;
    }
    private ArrayList<Lesson> wednesday(int dayOfMonth){
        Teacher teacher1 = new Teacher("Jørgen Holm");
        Teacher teacher2 = new Teacher("Simon Nielsen");
        Teacher teacher3 = new Teacher("Kirstine Petersen");
        String sco = "SCO";
        String sde = "SDE";
        ArrayList<int[]> timeList = getLessonStartTimes();
        ArrayList<Lesson> wednesday = new ArrayList<>();
        wednesday.add(new Lesson(sco,teacher2,LocalDateTime.of(2022,Month.FEBRUARY,dayOfMonth,timeList.get(1)[0],timeList.get(1)[1])));
        wednesday.add(new Lesson(sco,teacher2,LocalDateTime.of(2022,Month.FEBRUARY,dayOfMonth,timeList.get(2)[0],timeList.get(2)[1])));
        wednesday.add(new Lesson(sco,teacher2,LocalDateTime.of(2022,Month.FEBRUARY,dayOfMonth,timeList.get(3)[0],timeList.get(3)[1])));

        wednesday.add(new Lesson(sde,teacher1,LocalDateTime.of(2022,Month.FEBRUARY,dayOfMonth,timeList.get(4)[0],timeList.get(4)[1])));
        wednesday.add(new Lesson(sde,teacher1,LocalDateTime.of(2022,Month.FEBRUARY,dayOfMonth,timeList.get(5)[0],timeList.get(5)[1])));
        wednesday.add(new Lesson(sde,teacher1,LocalDateTime.of(2022,Month.FEBRUARY,dayOfMonth,timeList.get(6)[0],timeList.get(6)[1])));
        return wednesday;
    }
    private ArrayList<Lesson> thursday(int dayOfMonth){
        Teacher teacher4 = new Teacher("Bjarne Olesen");
        String ito = "ITO";
        
        ArrayList<int[]> timeList = getLessonStartTimes();
        ArrayList<Lesson> thursday = new ArrayList<>();
        thursday.add(new Lesson(ito,teacher4,LocalDateTime.of(2022,Month.FEBRUARY,dayOfMonth,timeList.get(1)[0],timeList.get(1)[1])));
        thursday.add(new Lesson(ito,teacher4,LocalDateTime.of(2022,Month.FEBRUARY,dayOfMonth,timeList.get(2)[0],timeList.get(2)[1])));
        thursday.add(new Lesson(ito,teacher4,LocalDateTime.of(2022,Month.FEBRUARY,dayOfMonth,timeList.get(3)[0],timeList.get(3)[1])));
        thursday.add(new Lesson(ito,teacher4,LocalDateTime.of(2022,Month.FEBRUARY,dayOfMonth,timeList.get(4)[0],timeList.get(4)[1])));
        
        return thursday;
    }
    private ArrayList<Lesson> friday(int dayOfMonth){
        Teacher teacher4 = new Teacher("Bjarne Olesen");
        String sco = "SCO";
        
        ArrayList<int[]> timeList = getLessonStartTimes();
        ArrayList<Lesson> friday = new ArrayList<>();
        friday.add(new Lesson(sco,teacher4,LocalDateTime.of(2022,Month.FEBRUARY,dayOfMonth,timeList.get(1)[0],timeList.get(1)[1])));
        friday.add(new Lesson(sco,teacher4,LocalDateTime.of(2022,Month.FEBRUARY,dayOfMonth,timeList.get(2)[0],timeList.get(2)[1])));
        friday.add(new Lesson(sco,teacher4,LocalDateTime.of(2022,Month.FEBRUARY,dayOfMonth,timeList.get(3)[0],timeList.get(3)[1])));
        
        return friday;
    }
    private ArrayList<int[]> getLessonStartTimes(){
        int[] time0 = {8,15};
        int[] time1 = {9,0};
        int[] time2 = {10,0};
        int[] time3 = {10,45};
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
