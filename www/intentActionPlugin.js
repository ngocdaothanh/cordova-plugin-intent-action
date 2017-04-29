var exec = require('cordova/exec');

function IntentActionPlugin() {
}

IntentActionPlugin.prototype.startIntentAction = function (intentAction) {
    exec(function (res) { }, function (err) { }, "IntentActionPlugin", "startIntentAction", [intentAction]);
}

module.exports = new IntentActionPlugin();
