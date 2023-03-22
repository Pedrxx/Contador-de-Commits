const form = document.querySelector("form")
form.addEventListener('submit', function (event) {
    event.preventDefault();
    const repositorio = document.querySelector("#repositorio").value;
    const dataInicial = document.querySelector("#dataInicial").value;
    const dataFinal = document.querySelector("#dataFinal").value;
    console.log(repositorio + " " + dataInicial + " " + dataFinal)
    
    buscarCommits(repositorio, dataInicial, dataFinal);
});

function buscarCommits(repositorio, dataInicial, dataFinal) {
    const url = `https://api.github.com/repos/${repositorio}/commits?since=${dataInicial}&until=${dataFinal}`;
    console.log(url);
    fetch(url).
        then(response => response.json()).
        then(commits => {
            console.log(commits);
            contarCommits(commits);
        });
    console.log(new Date());
}
function buscaLogin() {
    const url = `https://api.github.com/repos/${repositorio}/commits?since=${dataInicial}&until=${dataFinal}`;
    console.log(url);
    fetch(url).
        then(response => response.json()).
        then(repoData => {
            const ownerLogin = repoData.owner.login;
            const commitMessages = commitsData.map(commit => commit.commit.message);
        });
}

function contarCommits(commits) {
    const commitsPorDia = {};
    commits.forEach(element => {
        const dataCommit = element.commit.author.date
        if (commitsPorDia[dataCommit]) {
            commitsPorDia[dataCommit].quantidade++;
        } else {
            commitsPorDia[dataCommit] = { quantidade: 1, data: dataCommit };
        }

    });
    
    console.log(commitsPorDia);
    
    const commitsPorDiaArray = Object.keys(commitsPorDia).map(dataCommit => {
        return { data: dataCommit, quantidade: commitsPorDia[dataCommit].quantidade };
    });
    //console.log(commitsPorDiaArray.length)
    document.getElementById("down").innerHTML = " ";
    const down = document.querySelector('#down');
    const h2 = document.createElement("h2");
    h2.innerHTML = commitsPorDiaArray.length;
    down.appendChild(h2);
    mostrarTelaCommits(commitsPorDiaArray);
}

function mostrarTelaCommits(commits) {
    document.getElementById("dados").innerHTML = " ";
    const dados = document.querySelector('#dados');
    commits.forEach(element => {
        const p = document.createElement("p");
        p.innerHTML = "Commit Feito em: " 
        + element.data.substring(8,10)+"/"
        + element.data.substring(5,7)+"/"
        + element.data.substring(0,4) + "<br> Horario: "
        + element.data.substring(11,16) +  
        "<br> Quantidade: " + element.quantidade + "<br></br>";
        dados.appendChild(p);
    });
   
}

