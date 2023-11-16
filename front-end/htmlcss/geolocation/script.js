navigator.geolocation.getCurrentPosition(
    geolocationSuccess, 
    geolocationError, 
    { enableHighAccuracy: true, maximumAge: 5000 }
);

function geolocationSuccess(position) {
    let latitude = position.coords.latitude;
    let longitude = position.coords.longitude;
    let altitude = position.coords.altitude;
    let accuracy = position.coords.accuracy;

    console.log('lat: ' + latitude);
    console.log('long: ' + longitude);
    console.log('alt: ' + altitude);
    console.log('acc: ' + accuracy);
}

function geolocationError(err) {
    switch (err.code) {
        case err.TIMEOUT: console.log("Timeout"); break;
        case err.UNKNOWN_ERROR: console.log("Unknown"); break;
        case err.POSITION_UNAVAILABLE: console.log("Position unavailable"); break;
        case err.PERMISSION_DENIED: console.log("Permission denied"); break;
    };
}