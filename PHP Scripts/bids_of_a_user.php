<?php
//$user="shrutiag95";
$user=$_GET['username'];

$con=mysqli_connect("localhost","root","","bid");
$sql="select * from `item` where `current_user`='$user';";
$rs=mysqli_query($con,$sql);

while(($row=mysqli_fetch_assoc($rs))!=null){
	$output[]=$row;
}

print(json_encode(array("items"=>$output)));


?>