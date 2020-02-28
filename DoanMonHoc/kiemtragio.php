<?php 
	require 'ketnoi.php';
	$thoigianbatdau=$_POST['thoigianbatdauSan'];
	$ngay=$_POST['ngaySan'];
	
	
	$query="SELECT idhoadon from hoadon where ngaydat ='$ngay' and thoigianbatdau<'$thoigianbatdau' and thoigianketthuc>'$thoigianbatdau'";

	$data=mysqli_query($con,$query);


	if(mysqli_num_rows($data) == 0){
		echo "success";
	}
	else{
		echo "error";
	}
?>