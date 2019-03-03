package ru.job4j.professionals;

public class Professional {
    public String name;
    public String prof;

    public Professional(){}

    public Professional(String name, String prof) {
        this.name = name;
        this.prof = prof;
    }

    public String getName() {
        return name;
    }

    public String getProf() {
        return prof;
    }
}

class Doctor extends Professional{
    public Diagnose heal(Patient patient) {
    }
}

class Engineer extends Professional{
    public Build building (House house)
}

class Teacher extends Professional{
    public Learn learn (Student student)
}

class Patient {
    String name;

    public Patient(){}

    public Patient(String name){
        this.name = name;
    }
}

class Student {
    String name;

    public Student(){}

    public Student (String name){
        this.name = name;
    }
}

class House {
    String name;

    public House(){}

    public House(String name){
        this.name = name;
    }
}

class Diagnose {}

class Learn {}

class Build {}
