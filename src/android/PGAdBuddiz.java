package de.kijok.pgadbuddiz;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONObject;
import org.json.JSONArray;
import org.json.JSONException;

import android.app.Activity;
import com.purplebrain.adbuddiz.sdk.AdBuddiz;

public class PGAdBuddiz extends CordovaPlugin {
    public static final String ACTION_SHOW_AD = "show";
    
    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        try {
            if (ACTION_SHOW_AD.equals(action)) { 
               AdBuddiz.showAd(this.cordova.getActivity());
               callbackContext.success();
               return true;
            }
            callbackContext.error("Invalid action");
            return false;
        } catch(Exception e) {
            System.err.println("Exception: " + e.getMessage());
            callbackContext.error(e.getMessage());
            return false;
        } 
    }
}