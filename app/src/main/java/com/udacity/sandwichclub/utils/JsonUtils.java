package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONException;
import org.json.JSONObject;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) {
        try {
            JSONObject jsonSandwich = new JSONObject(json);
            Sandwich sandwich = new Sandwich();

            sandwich.setMainName(jsonSandwich.getString("name.mainName"));
            sandwich.setImage(jsonSandwich.getString("image"));
            //sandwich.setAlsoKnownAs();
            sandwich.setPlaceOfOrigin(jsonSandwich.getString("placeOfOrigin"));
            sandwich.setDescription(jsonSandwich.getString("description"));
            //sandwich.setIngredients();

            return sandwich;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
