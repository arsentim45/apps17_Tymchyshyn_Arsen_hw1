import domain.BasicStudent;
import domain.Student;
import json.*;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Andrii_Rodionov on 1/3/2017.
 */
public class JSONApp {
    public static void main(String[] args) {
        Json jYear = new JsonNumber(2);
        print(jYear); // 2

        Json jMarks = new JsonArray(new JsonNumber(3), new JsonNumber(4));
        print(jMarks); // [3, 4]

        JsonPair name = new JsonPair("name", new JsonString("Andrii"));
        JsonPair surname = new JsonPair("surname", new JsonString("Rodionov"));
        JsonPair marks = new JsonPair("marks", jMarks);
        JsonPair year = new JsonPair("year", jYear);
        JsonObject jsonObj = new JsonObject(name, surname, year, marks);
        print(jsonObj); // {'name': 'Andrii', 'surname': 'Rodionov', 'year': 2, 'marks': [3, 4]}

        print(jsonObj.projection("surname", "age", "year", "marks")); // {'surname': 'Rodionov', 'year': 2, 'marks': [3, 4]}

        BasicStudent basicStudent = new BasicStudent("Andrii", "Rodionov", 2);
        print(basicStudent.toJsonObject()); // {'name': 'Andrii', 'surname': 'Rodionov', 'year': 2}

    }

    private static void print(Json json) {
        System.out.println(json.toJson());
    }


    public static JsonObject sessionResult() {
        JsonObject jsonObject = (JsonPair name,JsonPair surname,JsonPair year,JsonPair exams2);

        name = new JsonPair("name", new JsonString("Andrii"));
        surname = new JsonPair("surname", new JsonString("Rodionov"));;
        year = new JsonPair("year", new JsonNumber(3));

        JsonPair oop = new JsonPair("course", new JsonString("OOP"));
        JsonPair english = new JsonPair("course", new JsonString("English"));
        JsonPair math = new JsonPair("course", new JsonString("Math"));
        JsonPair mark3 = new JsonPair("mark", new JsonNumber(3));
        JsonPair mark2 = new JsonPair("mark", new JsonNumber(2));
        JsonPair mark5 = new JsonPair("mark", new JsonNumber(5));
        JsonPair pased = new JsonPair("passed", new JsonBoolean(true));
        JsonPair notpased = new JsonPair("passed", new JsonBoolean(false));

        JsonObject oopexam = new JsonObject(oop, mark3, pased);
        JsonObject englishexam = new JsonObject(english, mark5, pased);
        JsonObject mathexam = new JsonObject(math, mark2, notpased);

        JsonArray exams = new JsonArray(oopexam, englishexam, mathexam);
        exams2 = new JsonPair("exams", exams);

        return jsonObject;
    }
}
