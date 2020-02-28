<?php 
	require'ketnoi.php';
	$query="Select hotentt from trongtai";

	$data=mysqli_query($con,$query);


	/**
	 * 
	 */
	class TenTrongTai{
		
		function TenTrongTai ($hotentt)
		{
			$this->HoTenTT = $hotentt;
			
		

		}
	}

	$mangTenTrongTai=array();

	while ($row = mysqli_fetch_assoc($data)) {
		array_push($mangTenTrongTai, new TenTrongTai($row['hotentt']));
	}

	
	echo json_encode($mangTenTrongTai);
?>