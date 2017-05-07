package ngocdaothanh.cordova.plugins;

import android.content.Intent;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;

public class IntentActionPlugin extends CordovaPlugin {
    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if (action.equals("startIntentAction")) {
            String intentAction = args.getString(0);

            Intent intent = new Intent(intentAction);
            if (args.length() == 2) {
                setExtras(intent, args.getString(1));
            }

            this.cordova.getActivity().startActivity(intent);

            callbackContext.success(intentAction);
            return true;
        }
        return false;
    }

    private void setExtras(Intent intent, String extras) throws JSONException {
        JSONObject jsonObject = new JSONObject(extras);
        JSONArray names = jsonObject.names();
        for (int i = 0; i < names.length(); i++) {
            String name = names.getString(i);
            Serializable value = (Serializable) jsonObject.get(name);
            intent.putExtra(name, value);
        }
    }
}
