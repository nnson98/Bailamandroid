<?php 
	require'ketnoi.php';
	$query="Select tennuoc from nuocuong";

	$data=mysqli_query($con,$query);


	/**
	 * 
	 */
	class TenNuoc{
		
		function TenNuoc ($tennuoc)
		{
			$this->TenNuoc = $tennuoc;
			
		

		}
	}

	$mangTenNuoc=array();

	while ($row = mysqli_fetch_assoc($data)) {
		array_push($mangTenNuoc, new TenNuoc($row['tennuoc']));
	}

	
	echo json_encode($mangTenNuoc);
?>