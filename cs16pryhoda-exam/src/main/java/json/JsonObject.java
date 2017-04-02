package json;

import java.util.ArrayList;

/**
 * Created by Andrii_Rodionov on 1/3/2017.
 */
public class JsonObject extends Json {
    private ArrayList<JsonPair> json = new ArrayList<>();

    public JsonObject(JsonPair... jsonPairs) {
        for(JsonPair pair: jsonPairs){
            this.add(pair);
        }
    }

    @Override
    public String toJson() {
        String result = "";
        if(this.json.size() == 0){
            result = "{}";
            return result;
        }
        result += "{";
        for (int i = 0; i < this.json.size(); i++) {
            if(i == this.json.size() - 1){
                result += "'" + this.json.get(i).key + "': " + this.json.get(i).value.toJson();
            } else{
            result += "'" + this.json.get(i).key + "': " + this.json.get(i).value.toJson() + ", ";
            }
        }
        result += "}";
        return result;
    }

    public void add(JsonPair jsonPair) {
        boolean isElement = true;
        for(JsonPair pair: this.json){
            if(jsonPair.key.equals(pair.key)){
                this.json.remove(pair);
                this.json.add(jsonPair);
                isElement = false;
                break;
            }
        }
        if(isElement){
            this.json.add(jsonPair);
        }
    }

    boolean contains(String name){
        for(JsonPair pair: this.json){
            if(pair.key.equals(name)){
                return true;
            }
        }
        return false;
    }

    public Json find(String name) {
        for(JsonPair pair: this.json){
            if(pair.key.equals(name)){
                return pair.value;
            }
        }
        return null;
    }

    public JsonObject projection(String... names) {
        JsonObject result = new JsonObject();
        for(JsonPair pair: this.json){
            for(String name: names){
                if(pair.key.equals(name)){
                    result.json.add(pair);
                }
            }
        }
        return result;
    }

}
