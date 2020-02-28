<?php 
	require 'ketnoi.php';
	$user=$_POST['userKH'];
	$pass=$_POST['passKH'];

	$query="SELECT iduser FROM username WHERE user='$user'and pass='$pass'";

	$result=mysqli_query($con,$query);


	if(mysqli_num_rows($result) != 0){
		echo "success";
	}
	else{
		echo "error";
	}
?>