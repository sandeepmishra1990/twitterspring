<%@ taglib  uri="http://www.springframework.org/tags/form" prefix="form"%> 

<html>
<body>
<h2>Welcome to Twitter World!!</h2>

<form action="twitterprofile/usertweetpdf1" method="GET" >
<label >Twitter USERNAME for Tweets report:</label>
<input type="text" name="user" value="" >
<input type="submit" value="Get PDF Report"/>

</form>
<br>

<form action="twitterprofile/followerslist" method="GET" >
<label >Twitter USERNAME for followers list:</label>
<input type="text" name="user" value="" >
<input type="submit" value="Get followers list"/>


</form>
</body>
</html>
