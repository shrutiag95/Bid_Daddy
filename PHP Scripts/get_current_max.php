<?php



$con=mysqli_connect("localhost","root","","bid");
    $id=$_POST['id'];

//$id="1";

    $sql="select `current_max_bid` from `item` where `id`='$id';" ;
    $rs=mysqli_query($con,$sql);
if(mysqli_num_rows($rs)>0){
        $r=mysqli_fetch_assoc($rs);
        print $r["current_max_bid"];}
    else
        print "";



?>