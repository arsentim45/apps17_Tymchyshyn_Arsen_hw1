package domain;

import json.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Andrii_Rodionov on 1/3/2017.
 */
public class Student extends BasicStudent {
    ArrayList<JsonObject> list_of_exams;

    public Student(String name, String surname, Integer year, Tuple<String, Integer>... exams) {
        super(name, surname, year);
        boolean pased = false;
        list_of_exams = new ArrayList<>();
        for (Tuple<String, Integer> exam :exams){
            if(exam.value > 2){
                pased = true;
            }
            else{
                pased = false;
            }
            JsonPair pased1 = new JsonPair("passed", new JsonBoolean(pased));
            JsonPair name1 = new JsonPair("course", new JsonString(exam.key));
            JsonPair mark1 = new JsonPair("mark", new JsonNumber(exam.value));
            JsonObject newsubject = new JsonObject(name1, mark1, pased1);
            this.list_of_exams.add(newsubject);
        }

    }

    public JsonObject toJsonObject() {
        JsonObject jsonObject = new JsonObject();
        JsonArray myarray = new JsonArray();
        for(Json items:this.list_of_exams) {
            myarray.add(items);
        }
        jsonObject.add(new JsonPair("exams", myarray));
        return jsonObject;
    }
}
