<?php 
	require'ketnoi.php';
	$query="Select tensan from sanbanh";

	$data=mysqli_query($con,$query);


	/**
	 * 
	 */
	class TenSanBanh{
		
		function TenSanBanh ($tensan)
		{
			$this->TenSan = $tensan;
			
		

		}
	}

	$mangTenSan=array();

	while ($row = mysqli_fetch_assoc($data)) {
		array_push($mangTenSan, new TenSanBanh($row['tensan']));
	}

	
	echo json_encode($mangTenSan);
?>