package domain;

import json.*;

import java.util.ArrayList;

/**
 * Created by Andrii_Rodionov on 1/3/2017.
 */
public class Student extends BasicStudent {

    final ArrayList<Tuple<String, Integer>> listOfTuples = new ArrayList<>();
    final int number = 3;

    public Student(String name, String surname, Integer year, Tuple<String, Integer>... exams) {
        this.name = name;
        this.surname = surname;
        this.year = year;
        for(Tuple<String, Integer> tuple: exams){
            this.listOfTuples.add(tuple);
        }

    }

    @Override
    public JsonObject toJsonObject() {
        JsonString studentName = new JsonString(this.name);
        JsonPair studentNamePair = new JsonPair("name" , studentName);

        JsonString studentSurname = new JsonString(this.surname);
        JsonPair studentSurnamePair = new JsonPair("surname", studentSurname);

        JsonNumber studentYear = new JsonNumber(this.year);
        JsonPair studentYearPair = new JsonPair("year", studentYear);

        JsonNumber oopNote = new JsonNumber(this.listOfTuples.get(0).value);
        JsonPair oopExam = new JsonPair("OOP", oopNote);

        JsonNumber englishNote = new JsonNumber(this.listOfTuples.get(0).value);
        JsonPair englishExam = new JsonPair("English", englishNote);

        JsonNumber mathNote = new JsonNumber(this.listOfTuples.get(2).value);
        JsonPair mathExam = new JsonPair("Math", mathNote);

        JsonObject exams = new JsonObject();
        JsonObject resultObject = new JsonObject(studentNamePair, studentSurnamePair, studentYearPair, oopExam, englishExam, mathExam);

        return resultObject;
    }
}