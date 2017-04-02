package domain;

import json.*;

/**
 * Created by Andrii_Rodionov on 1/5/2017.
 */
public class BasicStudent implements Jsonable {

    protected String name;
    protected String surname;
    protected Integer year;

    public BasicStudent() {
    }

    public BasicStudent(String name, String surname, Integer year) {
        this.name = name;
        this.surname = surname;
        this.year = year;
    }

    @Override
    public JsonObject toJsonObject() {
        JsonString name = new JsonString(this.name);
        JsonPair namePair = new JsonPair("name", name);

        JsonString surname = new JsonString(this.surname);
        JsonPair surnamePair = new JsonPair("surname", surname);

        JsonNumber year = new JsonNumber(this.year);
        JsonPair yearPair = new JsonPair("year", year);

        JsonObject resultObject = new JsonObject(namePair, surnamePair, yearPair);
        return resultObject;
    }
}
