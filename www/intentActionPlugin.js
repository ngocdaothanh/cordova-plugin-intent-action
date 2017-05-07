var exec = require('cordova/exec');

function IntentActionPlugin() {
}

IntentActionPlugin.prototype.startIntentAction = function (intentAction, extras) {
  var args = extras ? [intentAction, JSON.stringify(extras)] : [intentAction];
  exec(
    function(res) {},
    function (err) {},
    'IntentActionPlugin', 'startIntentAction', args
  );
}

module.exports = new IntentActionPlugin();
