package ngocdaothanh.cordova.plugins;

import android.content.Intent;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;

public class IntentActionPlugin extends CordovaPlugin {
    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) {
        if (action.equals("startIntentAction")) {
            String intentAction;
            try {
                intentAction = args.getString(0);
            } catch (JSONException e) {
                callbackContext.error("Please call like this: startIntentAction(intentAction)");
                return false;
            }

            Intent intent = new Intent(intentAction);
            this.cordova.getActivity().startActivity(intent);

            callbackContext.success(intentAction);
            return true;
        }
        return false;
    }
}
