<?php 
require 'ketnoi.php';

$query="Select name,phone from username";

	$data=mysqli_query($con,$query);


	/**
	 * 
	 */
	class ThongTin{
		
		function ThongTin ($name,$phone)
		{
			
			$this->NameKH = $name;
			$this->PhoneKH = $phone;
			
		

		}
	}

	$mangTT=array();

	while ($row = mysqli_fetch_assoc($data)) {
		array_push($mangTT, new ThongTin($row['name'],$row['phone']
			));
	}

	
	echo json_encode($mangTT);
?>