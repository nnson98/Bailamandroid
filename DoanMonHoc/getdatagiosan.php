<?php
require"ketnoi.php";

	$query="Select * from hoadon";

	$data=mysqli_query($con,$query);


	/**
	 * 
	 */
	class HoaDon{
		
		function HoaDon ($idhoadon,$ngaydat,$tensan,$thoigianbatdau,$thoigianketthuc,$tentt,$tennuoc,$thanhtien,$phone)
		{
			$this->Id= $idhoadon;
			$this->NgayDat = $ngaydat;
			$this->TenSan = $tensan;
			$this->ThoiGianBatDau = $thoigianbatdau;
			$this->ThoiGianKetThuc = $thoigianketthuc;
			$this->TenTT = $tentt;
			$this->TenNC = $tennuoc;
			$this->ThanhTien = $thanhtien;
			$this->Phone = $phone;

		}
	}

	$mangHoaDon=array();

	while ($row = mysqli_fetch_assoc($data)) {
		array_push($mangHoaDon, new HoaDon($row['idhoadon'],$row['ngaydat'],$row['tensan'],$row['thoigianbatdau']
			,$row['thoigianketthuc'],$row['tentt'],$row['tennuoc'],$row['thanhtien'],$row['phone']));
	}

	
	echo json_encode($mangHoaDon);

?>