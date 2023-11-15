document.querySelector("#moveBtn").addEventListener('click', () => {
    document.querySelector("#homeTownThomas").innerHTML = document.querySelector("#newHomeTown").value;
});

function makeThomasMove() {
    document.querySelector("#homeTownThomas").innerHTML = 
        document.querySelector("#newHomeTown").value;
}
