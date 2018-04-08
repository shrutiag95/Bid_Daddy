<?php

$con=mysqli_connect("localhost","root","","bid");
$new_bid=$_POST['bid'];
$new_user=$_POST['username'];
$Id= $_POST['id'];
$sql="update `item` set `current_max_bid`='$new_bid',`current_user`='$new_user' where `id`='$Id';" ;
	$rs=mysqli_query($con,$sql);
	if($rs)
		print $new_bid;
	else
		print"Try Again";


?>