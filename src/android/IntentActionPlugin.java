package ngocdaothanh.cordova.plugins;

import android.content.Intent;
import android.net.Uri;

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
                setOptions(intent, args.getString(1));
            }

            this.cordova.getActivity().startActivity(intent);

            callbackContext.success(intentAction);
            return true;
        }
        return false;
    }

    private void setOptions(Intent intent, String options) throws JSONException {
        JSONObject jsonObject = new JSONObject(options);

        if (jsonObject.has("extras")) {
            JSONObject extras = jsonObject.getJSONObject("extras");
            setExtras(intent, extras);
        }

        if (jsonObject.has("data")) {
            String uriString = jsonObject.getString("data");
            Uri data = Uri.parse(uriString);

            if (jsonObject.has("type")) {
                String type = jsonObject.getString("type");
                intent.setDataAndType(data, type);
            } else {
                intent.setData(data);
            }
        }
    }

    private void setExtras(Intent intent, JSONObject extras) throws JSONException {
        JSONArray names = extras.names();
        for (int i = 0; i < names.length(); i++) {
            String name = names.getString(i);
            Serializable value = (Serializable) extras.get(name);
            intent.putExtra(name, value);
        }
    }
}
