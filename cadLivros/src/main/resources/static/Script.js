document.getElementById('cadastroForm').addEventListener('submit', cadastrarJogo);
var result = 0;
function cadastrarJogo(event) {
    event.preventDefault();

    const name = document.getElementById('name').value;
    const plataform = document.getElementById('plataform').value;

    fetch('http://localhost:8080/Livros', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify({ name, plataform }),
    })
        .then(response => response.json())
        .then(data => {
            alert('Jogo cadastrado com sucesso!');
            document.getElementById('cadastroForm').reset();            
        })
        .catch(error => {
            console.error('Erro ao cadastrar livro:', error);
        });
}
function pesquisarJogo() {
    const searchId = document.getElementById('searchId').value;

    fetch(`http://localhost:8080/Livros/${searchId}`)
        .then(response => {
            if (response.status === 404) {
                return Promise.reject('Livro não encontrado');
                result = 0;
            }
            return response.json();
        })
        .then(data => {
            result = 1;
            document.getElementById('descricao').value = `${data.descricao}`;
            document.getElementById('ISBN').value = `${data.ISBN}`;
        })
        .catch(error => {
            console.error('Erro ao pesquisar Livro:', error);
            const resultadoPesquisa = document.getElementById('resultadoPesquisa');
            resultadoPesquisa.innerHTML = 'Livro não encontrado.';            

        });
}
function delete() {
	pesquisarJogo();
    if (result == 1) {
        const name = document.getElementById('descricao').value;
        const plataform = document.getElementById('ISBN').value;
        const searchId = document.getElementById('searchId').value;

        fetch(`http://localhost:8080/Livros/${searchId}`, {
            method: 'DELETE',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({ descricao, ISBN }),
        })
         .then(response => response.json())
         .then(data => {
			 alert('Livro Deletado!');
			 document.getElemetnById('cadastroform').reset();
		 }();
		 }else{
			 alert('descrição não encontrado na base de dados. Nenhum livro foi excluído. Favor pesquisar livro a ser alterado!!');
		 }
}