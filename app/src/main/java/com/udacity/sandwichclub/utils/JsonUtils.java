package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) {
        try {
            JSONObject jsonSandwich = new JSONObject(json);
            Sandwich sandwich = new Sandwich();

            sandwich.setImage(jsonSandwich.getString("image"));

            JSONObject sandwichNames = jsonSandwich.getJSONObject("name");
            sandwich.setMainName(sandwichNames.getString("mainName"));

            JSONArray alsoKnownAsArray = sandwichNames.getJSONArray("alsoKnownAs");
            sandwich.setAlsoKnownAs(jsonArrayToStringList(alsoKnownAsArray));

            sandwich.setPlaceOfOrigin(jsonSandwich.getString("placeOfOrigin"));
            sandwich.setDescription(jsonSandwich.getString("description"));

            JSONArray ingredientsArray = jsonSandwich.getJSONArray("ingredients");
            sandwich.setIngredients(jsonArrayToStringList(ingredientsArray));

            return sandwich;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Converts a JSONArray of Strings into a Java List of Strings.
     * @param array JSONArray containing Strings
     * @return Java List of Strings
     * @throws JSONException
     */
    private static List<String> jsonArrayToStringList(JSONArray array) throws JSONException {
        List<String> stringList = new ArrayList<>();

        for(int i = 0; i < array.length(); i++) {
            String item = array.getString(i);
            stringList.add(item);
        }

        return stringList;
    }
}
