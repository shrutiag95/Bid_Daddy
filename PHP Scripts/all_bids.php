<?php
$con=mysqli_connect("localhost","root","","bid");
$sql="select * from `item`;";
$rs=mysqli_query($con,$sql);

while(($row=mysqli_fetch_assoc($rs))!=null){
	$output[]=$row;
}

print(json_encode(array("items"=>$output)));


?>