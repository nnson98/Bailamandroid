<?php
	require 'ketnoi.php';
	$query="Select * from sanbanh";

	$data=mysqli_query($con,$query);


	/**
	 * 
	 */
	class SanBanh{
		
		function SanBanh ($idsan,$tensan,$loaisan,$dongiasan,$hinhsan)
		{
			$this->IdSan= $idsan;	
			$this->TenSan = $tensan;
			$this->LoaiSan = $loaisan;
			$this->DonGiaSan = $dongiasan;
			$this->HinhSan = $hinhsan;
			
		

		}
	}

	$mangSanBanh=array();

	while ($row = mysqli_fetch_assoc($data)) {
		array_push($mangSanBanh, new SanBanh($row['idsan'],$row['tensan'],$row['loaisan'],$row['dongiasan'],$row['hinhsan']
			));
	}

	
	echo json_encode($mangSanBanh);
?>