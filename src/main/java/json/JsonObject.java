package json;

/**
 * Created by Andrii_Rodionov on 1/3/2017.
 */
public class JsonObject extends Json {

    public JsonObject(JsonPair... jsonPairs) {
        private ArrayList<JsonPair> jsonArray = new ArrayList();
        jsonArray.addAll(Arrays.asList(jsonPairs));
    }

    @Override
    public String toJson() {
        StringBuffer jsonStringBuff = new StringBuffer("{");
        for (JsonPair pair : jsonArray){
            jsonStringBuff.append(pair.key.toJson()).append(":").append(pair.value.toJson()).append(", ");
        }
        jsonStringBuff.append("}");
        String jsonString = jsonStringBuff.toString();
        return jsonString;
    }


    public void add(JsonPair jsonPair) {
        jsonArray.add(jsonPair);
    }

    public Json find(String name) {
        for(JsonPair pair : jsonArray){
            if(name.equals(pair.key)){
                return pair.value;
            }


        }
        return null;
    }

    public JsonObject projection(String... names) {
        JsonObject obj = new JsonObject();
        for (String name : names){
            if (this.find(name) != null){
                obj.add(new JsonPair(name, this.find(name)));
            }
            else {
                return null;
            }
        }
        return obj;
    }
}
