<?php 

	require 'ketnoi.php';

	$user=$_POST['userKH'];
	$pass=$_POST['passKH'];
	$name=$_POST['nameKH'];
	$phone=$_POST['phoneKH'];
	
	

	$query ="INSERT INTO username VALUES(null,'$user','$name','$pass','$phone')";

	if(mysqli_query($con,$query)){
			echo "success";
	}else{

		echo "error";
	}




?>