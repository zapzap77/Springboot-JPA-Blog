<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp"%>

<div class="container">

	<form>
		<div class="form-group">
			<label for="userName">UserName</label> <input type="text" class="form-control" placeholder="Enter userName" id="userName">
		</div>

		<div class="form-group">
			<label for="email">Email</label> <input type="email" class="form-control" placeholder="Enter email" id="email">
		</div>

		<div class="form-group">
			<label for="password">Password</label> <input type="password" class="form-control" placeholder="Enter password" id="password">
		</div>
	</form>
	<button id="btn-save"  class="btn btn-primary">会員登録</button>
</div>

<script src="/blog/js/user.js"></script>
<%@ include file="../layout/footer.jsp"%>


