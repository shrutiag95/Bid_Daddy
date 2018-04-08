<?php
$con=mysqli_connect("localhost","root","","bid");

$email=$_POST['email'];
$phone=$_POST['phone'];
	$username=$_POST['username'];
	$password=$_POST['password'];
	
	
	$sql="insert into user(`username`,`password`,`email`,`phone`) values('$username','$password','$email','$phone');" ;
	$rs=mysqli_query($con,$sql);
	if($rs)
		print"registered successfully";
	else
		print"registeration unsuccessful";

?>
