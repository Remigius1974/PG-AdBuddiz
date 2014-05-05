var PGAdBuddiz = {
    showAd: function(successCallback, errorCallback) {
        cordova.exec(
            successCallback, // success callback function
            errorCallback, // error callback function
            'PGAdBuddiz', // mapped to our native Java class called "CalendarPlugin"
            'show', // with this action name
            []
        ); 
    }
}
module.exports = PGAdBuddiz;