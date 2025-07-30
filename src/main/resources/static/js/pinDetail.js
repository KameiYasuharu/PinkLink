window.onload = function () {
    // URLパラメータを取得
    const params = new URLSearchParams(window.location.search);
    const sekkeishobangou = params.get('sekkeishobangou');
    const username = params.get('username');

    const errorMsg = document.getElementById('errorMsg');
    const detailTable = document.getElementById('detailTable');

    if (!sekkeishobangou) {
        errorMsg.textContent = 'パラメータが不足しています';
        errorMsg.style.display = 'block';
        detailTable.classList.add('hidden');
        return;
    }
    const basePath = window.location.pathname.substring(0, window.location.pathname.indexOf('/', 1)) || '';
    // バックエンドの /design エンドポイントを呼び出す
     fetch(`${basePath}/design?sekkeishobangou=${encodeURIComponent(sekkeishobangou)}&username=${encodeURIComponent(username)}`)
        .then(response => {
            if (!response.ok) {
                throw new Error('サーバーエラー');
            }
            return response.json();
        })
        .then(data => {

            if (data.state === "OK") {
                // 入力欄にデータをセット
                document.querySelector('input[name="sekkeishoNo"]').value = data.designDocId;
                document.querySelector('input[name="koujiKaisha"]').value = data.constCompany;
                document.querySelector('input[name="sekkeishoStatus"]').value = data.designDocSts;
                document.querySelector('input[name="kingaku"]').value = data.amountItem;
                errorMsg.style.display = 'none';
                detailTable.classList.remove('hidden');
            } else {
                // 権限認証失敗時の処理
                errorMsg.textContent = '権限認証失敗';
                errorMsg.style.display = 'block';
                detailTable.classList.add('hidden');
            }
        })
        .catch(error => {
            errorMsg.textContent = error.message;
            errorMsg.style.display = 'block';
            detailTable.classList.add('hidden');
        });
};