if ('newHometown' in window.localStorage) {
    updateHometown(window.localStorage['newHometown']);
}

document.querySelector("#moveBtn").addEventListener('click', () => {
    let newHometown = document.querySelector("#newHomeTown").value;
    updateHometown(newHometown);
    window.localStorage['newHometown'] = newHometown;
});

function updateHometown(homeTown) {
    document.querySelector("#homeTownThomas").innerHTML = homeTown;
}