let index = {
	init: function() {
		$("#btn-save").on("click", () => {
			this.save();

		});
	},

	save: function() {
		//alert('userのsaveメソッド呼び出す');

		let data = {
			userName: $("#userName").val(),
			email: $("#email").val(),
			password: $("#password").val()
		};

		//console.log(data);

		//ajax통신을 이용해서 3개의 데이터를 json으로 변경하여 insert 요청
		$.ajax({
			type:"POST",
			url:"/blog/api/user",
			data:JSON.stringify(data),
			contentType:"application/json; charset=utf-8",
			dataType: "json"
		}).done(function(resp) {
			alert("登録完了できました。");
			location.href = "/blog";
		}).fail(function(error) {
			alert(JSON.stringify(error));
		});
	}

};


index.init();