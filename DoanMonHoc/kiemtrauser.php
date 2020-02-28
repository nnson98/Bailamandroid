<?php 
require 'ketnoi.php';


	$user=$_POST['userKH'];

	$query="SELECT user From username where user='$user'";

	$result=mysqli_query($con,$query);

	if(mysqli_num_rows($result)==0){
		echo "success";
	}else{
		echo "error";
	}
?>