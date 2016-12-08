package com.example.remya.petplanet.data;

import org.json.JSONObject;

/**
 * Created by remya on 12/7/2016.
 */
public class Item implements JSONPopulator {
    public Condition getCondition() {
        return condition;
    }

    private Condition condition;
    @Override
    public void populate(JSONObject data) {
        condition =new Condition();
        condition.populate(data.optJSONObject("condition"));

    }
}
