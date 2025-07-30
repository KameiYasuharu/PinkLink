window.onload = function() {
    // URLからユーザーとパスワードのパラメータを取得
    var queryParams = window.location.search.substring(1);
    var params = new URLSearchParams(queryParams);

    var username = params.get('username'); 
    var password = params.get('password');
    
    // ユーザーとパスワードを隠し入力フィールドに設定
    document.getElementById('username').value = username;
    document.getElementById('password').value = password;

    // ユーザー情報を動的に表示
    document.getElementById('dynamicUser').textContent = username;
}

// 地図表示ボタンのクリックイベント
function showMap() {
    // 隠し入力フィールドからユーザーとパスワードを取得
    var username = document.getElementById('username').value;
    var password = document.getElementById('password').value;

    // 次のページのURLを構築して遷移
    var queryParams = "username=" + encodeURIComponent(username) 
                    + "&password=" + encodeURIComponent(password);
    //window.location.href = "http://localhost:8080/proj/login2.html?" + queryParams;
    window.location.href = "http://localhost:8080/proj/login2.html?" + queryParams;
}