<?php
	require 'ketnoi.php';

	$query="Select * from nuocuong";

	$data=mysqli_query($con,$query);


	/**
	 * 
	 */
	class NuocUong{
		
		function NuocUong ($idnuoc,$tennuoc,$dongia,$hinhnuoc)
		{
			$this->IdNuoc= $idnuoc;	
			$this->TenNuoc = $tennuoc;
			$this->DonGia = $dongia;
			$this->HinhNuoc = $hinhnuoc;
			
		

		}
	}

	$mangNuocUong=array();

	while ($row = mysqli_fetch_assoc($data)) {
		array_push($mangNuocUong, new NuocUong($row['idnuoc'],$row['tennuoc'],$row['dongia'],$row['hinhnuoc']
			));
	}

	
	echo json_encode($mangNuocUong);
?>