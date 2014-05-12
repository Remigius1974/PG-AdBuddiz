package de.kijok.pgadbuddiz;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONObject;
import org.json.JSONArray;
import org.json.JSONException;

import android.app.Activity;
import com.purplebrain.adbuddiz.sdk.AdBuddiz;
import com.purplebrain.adbuddiz.sdk.AdBuddizDelegate;
import com.purplebrain.adbuddiz.sdk.AdBuddizError;

class PGAdBuddizDelegate implements AdBuddizDelegate {

    public CallbackContext jsContext = null;

    public PGAdBuddizDelegate(CallbackContext callbackContext) {
        jsContext = callbackContext;
    }

    public void didCacheAd() {  // an Ad was cached
        if (jsContext != null) {
            jsContext.success("ad_cached");
        }
    }

    public void didShowAd() {   // an Ad was displayed
        if (jsContext != null) {
            jsContext.success("ad_displayed");
        }
    }

    public void didFailToShowAd(AdBuddizError error) { // no Ad was displayed 
        if (jsContext != null) {
            jsContext.success("no_ad_displayed");
        }
    }

    public void didClick() {   // the Ad was clicked
        if (jsContext != null) {
            jsContext.success("ad_clicked");
        }
    }

    public void didHideAd() {   // the Ad was hidden 
        if (jsContext != null) {
            jsContext.success("ad_hide");
        }
    }
}

public class PGAdBuddiz extends CordovaPlugin {
    public static final String ACTION_SHOW_AD = "show";
    public static final String ACTION_CREATE_DELEGATE = "delegate";
    public PGAdBuddizDelegate delegateInstance = null;
    
    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        try {
            if (ACTION_SHOW_AD.equals(action)) {
                if (AdBuddiz.isReadyToShowAd(this.cordova.getActivity())) { // this = current Activity
                    AdBuddiz.showAd(this.cordova.getActivity());
                    callbackContext.success();
                    return true;
                }
                else {
                    callbackContext.error("AdBuddiz not ready to show");
                    return false;
                }
            }
            else if (ACTION_CREATE_DELEGATE.equals(action)) {
                delegateInstance = new PGAdBuddizDelegate(callbackContext);
                AdBuddiz.setDelegate(delegateInstance);
                return true;
            }

            callbackContext.error("Invalid action: " + action);
            return false;
        } catch(Exception e) {
            System.err.println("Exception: " + e.getMessage());
            callbackContext.error(e.getMessage());
            return false;
        } 
    }
}