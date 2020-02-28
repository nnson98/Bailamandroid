<?php
	require 'ketnoi.php';

	$idsv=$_POST['idKH'];
	$query="DELETE FROM hoadon where idhoadon='$idsv'";
	if(mysqli_query($con,$query))
	{
			echo"success";
	}else{
			echo "error";
	}
?>