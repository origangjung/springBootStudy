const deleteButton = document.getElementById('delete-btn');

if (deleteButton) {
    deleteButton.addEventListener('click', event => {
        let id = document.getElementById('article-id').value;
        fetch(`/api/articles/{id}`, {
            method: 'DELETE'
        })
            .then(() => {
                alert('삭제가 완료되었습니다.');
                location.replace('/articles');
            });
    });
}

const modifyButton = document.getElementById('modify-btn');

if (modifyButton) {
    modifyButton.addEventListener('click', event => {
        let params = new URLSearchParams(location.search);
        let id = params.get('id');

        fetch(`api/articles/${id}`, {
            method: 'PUT',
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify({
                title: document.getElementById("title").value,
                content: document.getElementById('content').value
            })
        })
            .then(() => {
                alert('수정이 완료됨');
                location.replace(`articles/${id}`);
            })
    })
}

// 등록 버튼 기능
const createButton = document.getElementById("create-btn");

if (createButton) {
    createButton.addEventListener("click", (event) => {
        fetch("/api/articles", {
            method: "POST", // 👈 새로운 자원을 생성하므로 POST 방식을 사용합니다.
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify({
                title: document.getElementById("title").value,
                content: document.getElementById("content").value,
            }),
        }).then(() => {
            alert("등록이 완료되었습니다.");
            location.replace("/articles"); // 등록 후 목록 페이지로 이동합니다.
        });
    });
}