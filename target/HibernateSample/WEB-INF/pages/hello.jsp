<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>

	<script src="http:////code.jquery.com/jquery-1.10.2.js"></script>
	<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.5.1/jquery.min.js"></script>
	<script type="text/javascript">

		function postFunc(){
			var name = $('#name').val();
			var age = $('#age').val();
			var myjson = { "name" : name, "age" : age };
			console.log(myjson)
			//POST
			$.post("student",myjson, function( status){
				alert("Object Created");
			});
			return false;
		};

		function deleteFunc(){
			var id= $('#id').val();
			$.ajax({
				type: 'DELETE' ,
				url: 'del'+ '?' + $.param({"id": id}) ,
				success: function(response) {
					$('#result_DELETE').text(response);
					alert("Deleted")
				}
			});
			return false;
		};

		function patchFunc(){
			var id= $('#id_PATCH').val();
			var name= $('#name_PATCH').val();
			$.ajax({
				type: 'PATCH' ,
				url: 'patch'+ '?' + $.param({"name": name})+'&'+$.param({"id": id}),
				success: function(response) {
					$('#result_PATCH').text(JSON.stringify( response));
				}
			});
			return false;
		};

		function putFunc(){
			var id= $('#id_PUT').val();
			var name= $('#name_PUT').val();
			var age= $('#age_PUT').val();
			$.ajax({
				type: 'PUT' ,
				url: 'put'+ '?' + $.param({"id": id})+'&'+ $.param({"name": name})+'&'+$.param({"age": age}),
				success: function(response) {
					$('#result_PUT').text(JSON.stringify( response));
				}
			});
			return false;
		};

		function getFunc() {
			var id= $('#id_GET').val();
			$.get("get",{ "id": id }, function (result) {
				console.log(result);
				$('#result_GET').text(JSON.stringify( result));
			});
			return false;
		};

	</script>

</head>
<body>
<h1>${message}</h1>

<h3>POST/CREATE record</h3>
<form action="" id="postForm"  method="post" >

		<label>Enter your name:</label>
		<input id="name" />

		<label>Enter your age:</label>
		<input id="age" />

		<button name="submit" id="submit_POST" type="submit" form="postForm" onclick="return postFunc();">Submit</button>

</form>

<h3>Get record</h3>
<form action="" method="get" id="getForm">
	<label>Enter id :</label>
	<input id="id_GET" />
	<button name="submit" id="submit_GET" type="submit" form="getForm" onclick="return getFunc();">Submit</button>
	<label id="result_GET">Result</label>
</form>

<h3>PUT Request- update record</h3>
<form action="" id="putForm" >
	<label>Enter id :</label>
	<input id="id_PUT" />
	<label>Enter name :</label>
	<input id="name_PUT" />
	<label>Enter age :</label>
	<input id="age_PUT" />
	<button name="submit" id="submit_PUT" type="submit" form="patchForm" onclick="return putFunc();">Submit</button>
	<label id="result_PUT">Result</label>
</form>

<h3>Delete Request</h3>
<form action="" id="deleteForm" >
	<label>Enter id :</label>
	<input id="id" />
	<button name="submit" id="submit_DELETE" type="submit" form="deleteForm" onclick="return deleteFunc();">Submit</button>
	<label id="result_DELETE">Result</label>
</form>

<h3>Patch Request- update name</h3>
<form action="" id="patchForm" >
	<label>Enter id :</label>
	<input id="id_PATCH" />
	<label>Enter name :</label>
	<input id="name_PATCH" />
	<button name="submit" id="submit_PATCH" type="submit" form="patchForm" onclick="return patchFunc();">Submit</button>
	<label id="result_PATCH">Result</label>
</form>
</body>
</html>