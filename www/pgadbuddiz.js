var PGAdBuddiz = {
    showAd: function(successCallback, errorCallback) {
        cordova.exec(
            successCallback, // success callback function
            errorCallback, // error callback function
            'PGAdBuddiz', // mapped to our native Java class called "PGAdBuddiz"
            'show', // with this action name
            []
        ); 
    },

    createDelegate: function(delegateCallback, errorCallback) {
        cordova.exec(
            delegateCallback, // delegate callback function
            errorCallback,
            'PGAdBuddiz', // mapped to our native Java class called "PGAdBuddiz"
            'delegate', // with this action name
            []
        ); 
    }
}

module.exports = PGAdBuddiz;