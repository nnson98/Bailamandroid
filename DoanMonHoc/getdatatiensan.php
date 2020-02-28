<?php 
	require'ketnoi.php';
	$id=1;
	$query="Select dongiasan from sanbanh where tensan=Sân 1";

	$data=mysqli_query($con,$query);



	

	while (mysqli_result($data,$row['dongiasan'])) {
		echo json_encode($row['dongiasan']);
		
	}

	
	
?>