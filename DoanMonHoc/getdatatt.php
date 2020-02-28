<?php
 require 'ketnoi.php';

 	$query="Select * from trongtai";

	$data=mysqli_query($con,$query);


	/**
	 * 
	 */
	class TrongTai{
		
		function TrongTai ($idtt,$hotentt,$tuoitt,$kntt,$hinhtt,$dongia)
		{
			$this->IdTT= $idtt;	
			$this->HoTenTT = $hotentt;
			$this->TuoiTT = $tuoitt;
			$this->KNTT = $kntt;
			$this->HinhTT = $hinhtt;
			$this->DonGia = $dongia;
		

		}
	}

	$mangTrongTai=array();

	while ($row = mysqli_fetch_assoc($data)) {
		array_push($mangTrongTai, new TrongTai($row['idtt'],$row['hotentt'],$row['tuoitt'],$row['kntt']
			,$row['hinhtt'],$row['dongia']));
	}

	
	echo json_encode($mangTrongTai);
?>