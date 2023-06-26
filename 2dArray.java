class Student{
    public String studentId;
    public String firstName;
    public String lastName;
    public int gradeLevel;

    public Student(String studentId, String firstName, String lastName, int gradeLevel){
        this.studentId = studentId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gradeLevel = gradeLevel;
    }

    public String getStudentInfo(){
        return this.studentId + ": " + this.firstName + " " + this.lastName + "(" + this.gradeLevel + "gr)";
    }
}

class Classroom{
    Student[] students;
    public String courseName;
    public String teacher;

    public Classroom(Student[] students, String courseName, String teacher){
        this.students = students;
        this.courseName = courseName;
        this.teacher = teacher;
    }

    public String getClassIdentity(){
        return this.courseName + " managed by " + this.teacher;
    }

    public int getNumberOfStudents(){
        return this.students.length;
    }
}

class Main{
    public static void printHonorsStudents(Classroom[] school){
        for (int i = 0; i < school.length; i++){
            Classroom currClass = school[i];
            Student[] currStudentArr = currClass.students;
            String message = " from " + currClass.teacher + "'s class";

            for (int j = 0; j < currStudentArr.length; j++){
                Student currStudent = currStudentArr[j];
                if (currStudent.gradeLevel >= 10) System.out.println(currStudent.getStudentInfo() + message);
            }
        }
    }

    public static void main(String[] args){
        Student[] student1 = {new Student("AC-343424", "James", "Smith", 6), new Student("AC-343428", "Maria", "Garcia", 5),new Student("AC-343434", "Robert", "Johnson", 3),new Student("AC-343454","Danny", "Robertson",10)};
        Student[] student2 = {new Student("AC-340014","Kent", "Carter",9), new Student("AC-340024","Isaiah", "Chambers",10),new Student("AC-340018","Leta", "Ferguson",7)};
        Classroom classroom1 = new Classroom(student1, "Algebra II", "Emily Theodore");
        Classroom classroom2 = new Classroom(student2, "English", "Daniel Pherb");
        // school is 2dArray
        Classroom[] school = {classroom1, classroom2};

        printHonorsStudents(school);
    }
}
