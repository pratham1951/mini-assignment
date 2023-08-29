<html>
<style>

.mydiv{
text-align:center;
margin:auto;
padding:150px;
}
</style>

<script>

window.addEventListener( "pageshow", function ( event ) {
	  var historyTraversal = event.persisted || 
	                         ( typeof window.performance != "undefined" && 
	                              window.performance.navigation.type === 2 );
	  if ( historyTraversal ) {
	    // Handle page restore.
	    window.location.reload();
	  }
	});
</script>
<body>

<div style="text-align:center">
<h1>This is Production Code </h1>
</div>

<div class="mydiv">
<form action="add">

<input type="text" name="t1">
<input type="text" name="t2">
<input type="submit" name="add" value="add">

</form>
<form action="sub">

<input type="text" name="t1">
<input type="text" name="t2">
<input type="submit" name="add" value="sub">

</form>
<form action="mul">

<input type="text" name="t1">
<input type="text" name="t2">
<input type="submit" name="add" value="mul">

</form>
<form action="divi">

<input type="text" name="t1">
<input type="text" name="t2">
<input type="submit" name="add" value="div">

</form>

</div>


</body>
</html>
