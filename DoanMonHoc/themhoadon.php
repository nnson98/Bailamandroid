<?php
	require 'ketnoi.php';

	$ngaydat=$_POST['ngaydatSan'];
	$tensan=$_POST['tenSan'];
	$thoigianbatdau=$_POST['thoigianbatdauSan'];
	$thoigianketthuc=$_POST['thoigianketthucSan'];
	$tentt=$_POST['tenttSan'];
	$tennuoc=$_POST['tennuocSan'];
	$thanhtien=$_POST['thanhtienSan'];
	$phone=$_POST['phoneSan'];
	

	$query ="INSERT INTO hoadon VALUES(null,'$ngaydat','$tensan','$thoigianbatdau','$thoigianketthuc','$tentt','$tennuoc','$thanhtien','$phone')";

	if(mysqli_query($con,$query)){
			echo "success";
	}else{

		echo "error";
	}



?>