package ru.job4j.professionals;

public class Doctor extends Professional {
    public Doctor (String name, String prof){
        super(name, prof);
    }
    public Diagnose heal(Patient patient){
        return new Diagnose();
    }
}
