<?php



$con=mysqli_connect("localhost","root","","bid");
    $username=$_POST['username'];
	$password=$_POST['password'];

	
	$sql="select * from `user` where `username`='$username' and `password`='$password';" ;
	$rs=mysqli_query($con,$sql);
if(mysqli_num_rows($rs)>0)
		echo "Login successfully";
	else
		echo "Login unsuccessfully";
	


?>