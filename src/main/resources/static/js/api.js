document.getElementById('loginForm').addEventListener('submit', async function(e) {
	e.preventDefault();

	var selectedUser = document.querySelector('input[name="user_code"]:checked').value;
	var password = '';
	switch (selectedUser) {
		case 'X0071920':
			password = 'X0071920';
			break;
		case 'KDKEJ150':
			password = 'KDKEJ150';
			break;
	}
	var queryParams = "username=" + encodeURIComponent(selectedUser)
		+ "&password=" + encodeURIComponent(password);

	const basePath = window.location.pathname.substring(0, window.location.pathname.indexOf('/', 1)) || '';

	fetch(`${basePath}/login?${queryParams}`, {
		method: 'GET',
		headers: {
			'Content-Type': 'application/json',
		}
	}).then(response => {
		if (!response.ok) {
			throw new Error('API呼び出しに失敗しました');
		}
		return response.json();
	}).then(data => {

		if (data.state == "OK") {
			window.location.href = 'approved_storage.html?username=' + encodeURIComponent(selectedUser) + '&password=' + encodeURIComponent(password);
		} else {
			alert(data.errMsg);
		}
	}).catch(error => {
		alert(error.message);
	});

});