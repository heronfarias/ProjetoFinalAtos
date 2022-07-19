
function confirm(tipo) {
    var nome = document.getElementById("inputNome").value;
    var valor = document.getElementById("inputValor").value;

    var data = {
        nome: nome,
        valor: valor
    }

    if (tipo == 'passivo') {
        fetch("http://localhost:8080/api/financeiro", {
            method: 'POST',
            body: JSON.stringify(data),
            headers: {
              'Content-Type': 'application/json'
            }
          }).then(res => res.json())
            .then(function (response) {
              console.log(response);
            })
    }
    else if (tipo == 'ativo') {
      fetch("http://localhost:8080/api/financeiro", {
        method: 'POST',
        body: JSON.stringify(data),
        headers: {
          'Content-Type': 'application/json'
        }
      }).then(res => res.json())
        .then(function (response) {
          console.log(response);
        })
    }
}

function updateList(tipo) {
  fetch(`http://localhost:8080/api/financeiro/${tipo}`, {
      method: 'GET'      
    })
  .then(res => res.json())
  .then(data => {
    let htmlCode = '';
    console.log(data);
    for(p of data) {
        htmlCode += '<tr>';
        htmlCode += '<td>' + p.nome + '</td>';
        htmlCode += '<td>' + p.valor + '</td>';
        htmlCode += '</tr>';
    }

    document.getElementById("tableBody").innerHTML = htmlCode;
})
}

function updateListNew() {
  fetch('http://localhost:8080/api/financeiro/', {
      method: 'GET'
  })
      .then(res => res.json())
      .then(data => {
        let htmlCode = '';
        console.log(data);
        for(p of data) {
            htmlCode += '<tr>';
            htmlCode += '<td>' + p.nome + '</td>';
            htmlCode += '<td>' + p.valor + '</td>';
            htmlCode += '</tr>';
        }
          document.getElementById("tableBody").innerHTML = htmlCode;
          const ValorRecebido = document.getElementById("InputID");
          console.log(ValorRecebido.value);
      })
}

function updateListPassivo() {
  fetch('http://localhost:8080/api/passivo/', {
      method: 'GET'
  })
      .then(res => res.json())
      .then(data => {
        let htmlCode = '';
        console.log(data);
        for(p of data) {
            htmlCode += '<tr>';
            htmlCode += '<td>' + p.nome + '</td>';
            htmlCode += '<td>' + p.valor + '</td>';
            htmlCode += '</tr>';
        }
          document.getElementById("tableBody").innerHTML = htmlCode;
          const ValorRecebido = document.getElementById("InputID");
          console.log(ValorRecebido.value);
      })
}

function updatePassivo() {
  fetch('http://localhost:8080/api/Comparacao/', {
      method: 'GET'
  })
      .then(res => res.json())
      .then(data => {
        let htmlCode = '';
        console.log(data);
        for(p of data) {
            htmlCode +=  p.valor;
        }
          document.getElementById("tableBody").innerHTML = htmlCode;
          const ValorRecebido = document.getElementById("InputID");
          console.log(ValorRecebido.value);
      })
}


function insertpassivo() {
  return obj = {
    nome: document.getElementById("inputNome").value,
    valor: document.getElementById("inputValor").value,
  }
}
function inserir() {
  fetch('http://localhost:8080/api/passivo/', {
      method: 'POST',
      mode: 'cors',
      body: JSON.stringify(insertpassivo()),
      headers: {
          'Content-Type': 'application/json'
      }
  }).then(res => res.json())
      .then(function (response) {
          console.log(response);
      })
}