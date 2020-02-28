-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th2 28, 2020 lúc 03:31 AM
-- Phiên bản máy phục vụ: 10.1.39-MariaDB
-- Phiên bản PHP: 7.3.5

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `qlsanbong`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `hoadon`
--

CREATE TABLE `hoadon` (
  `idhoadon` int(11) NOT NULL,
  `ngaydat` char(50) COLLATE utf8_unicode_ci NOT NULL,
  `tensan` varchar(150) COLLATE utf8_unicode_ci NOT NULL,
  `thoigianbatdau` char(50) COLLATE utf8_unicode_ci NOT NULL,
  `thoigianketthuc` char(50) COLLATE utf8_unicode_ci NOT NULL,
  `tentt` varchar(150) COLLATE utf8_unicode_ci NOT NULL,
  `tennuoc` varchar(150) COLLATE utf8_unicode_ci NOT NULL,
  `thanhtien` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `phone` char(11) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `hoadon`
--

INSERT INTO `hoadon` (`idhoadon`, `ngaydat`, `tensan`, `thoigianbatdau`, `thoigianketthuc`, `tentt`, `tennuoc`, `thanhtien`, `phone`) VALUES
(1, '2019/12/03', 'Sân 4', '07:00', '08:00', 'Nguyễn Văn B', 'Pepsi', '400000', '0944705204');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `nuocuong`
--

CREATE TABLE `nuocuong` (
  `idnuoc` int(11) NOT NULL,
  `tennuoc` varchar(150) COLLATE utf8_unicode_ci NOT NULL,
  `dongia` int(111) NOT NULL,
  `hinhnuoc` varchar(300) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `nuocuong`
--

INSERT INTO `nuocuong` (`idnuoc`, `tennuoc`, `dongia`, `hinhnuoc`) VALUES
(1, 'Pepsi', 10000, 'https://cdn.production.telio.me/media/catalog/product/cache/ecd051e9670bd57df35c8f0b122d8aea/1/6/16568750047262_1_.jpg'),
(2, 'Sting', 10000, 'https://image.pharmacity.vn/live/uploads/2019/04/P08084_1_l.jpg'),
(3, '7Up', 10000, 'https://image.pharmacity.vn/live/uploads/2019/04/P07296_1_l.jpg'),
(4, 'Revive', 12000, 'https://image.pharmacity.vn/live/uploads/2019/04/P09445_1_l.jpg'),
(5, 'Nước Rivive chanh muối', 12000, 'https://img.sosanhgia.com/images/500x0/472f566adccd40adbb1235580b4a4219/nuoc-ngot-co-ga-revive-chanh-muoi.jpeg');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `sanbanh`
--

CREATE TABLE `sanbanh` (
  `idsan` int(11) NOT NULL,
  `tensan` varchar(150) COLLATE utf8_unicode_ci NOT NULL,
  `loaisan` varchar(150) COLLATE utf8_unicode_ci NOT NULL,
  `dongiasan` int(11) NOT NULL,
  `hinhsan` varchar(300) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `sanbanh`
--

INSERT INTO `sanbanh` (`idsan`, `tensan`, `loaisan`, `dongiasan`, `hinhsan`) VALUES
(1, 'Sân 1', 'Sân ngoài trời', 100000, 'https://2.bp.blogspot.com/-pEwE5_d2Cys/WvAd-4tWcKI/AAAAAAAAAYE/PUc98kaZ1CYqviC_j2erSL6aV6_rHiojwCEwYBhgL/s1600/12.jpg'),
(2, 'Sân 2', 'Sân ngoài trời', 100000, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRH6f_M1Od62N1W5mtghn_ckwnHhDDDs89qWnsV57QymUC1GQUB&s'),
(3, 'Sân 3', 'Sân ngoài trời', 100000, 'https://www.potech.com.vn/wp-content/uploads/2017/03/giai-phap-chieu-sang-san-bong.jpg'),
(4, 'Sân 4', 'Sân trong nhà', 200000, 'https://thegioiconhantao.com.vn/wp-content/uploads/2016/11/san-bong-futsal.jpg'),
(5, 'Sân 5', 'Sân trong nhà', 200000, 'http://sangiare.com.vn/uploads/images/images/San-bong-da-futsan-sangiare.jpg');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `tichdiem`
--

CREATE TABLE `tichdiem` (
  `idtd` int(11) NOT NULL,
  `iduser` int(11) NOT NULL,
  `sodiem` int(11) NOT NULL,
  `phone` char(11) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `trongtai`
--

CREATE TABLE `trongtai` (
  `idtt` int(11) NOT NULL,
  `hotentt` varchar(150) COLLATE utf8_unicode_ci NOT NULL,
  `tuoitt` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `kntt` varchar(150) COLLATE utf8_unicode_ci NOT NULL,
  `hinhtt` varchar(300) COLLATE utf8_unicode_ci NOT NULL,
  `dongia` char(20) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `trongtai`
--

INSERT INTO `trongtai` (`idtt`, `hotentt`, `tuoitt`, `kntt`, `hinhtt`, `dongia`) VALUES
(1, 'Nguyễn Văn A', '30 tuổi', '3 năm', 'https://vcdn-vnexpress.vnecdn.net/2019/11/17/Untitled-6041-1573980735.jpg', '100000'),
(2, 'Nguyễn Văn B', '27 tuổi ', '2 năm ', 'https://znews-photo.zadn.vn/w660/Uploaded/zatmtz/2018_01_22/faref16081a.jpg', '100000'),
(3, 'Trần Văn C', '26 tuổi', '2 năm', 'https://znews-photo.zadn.vn/w660/Uploaded/ofh_fdmzsofw/2018_12_15/h23.jpg', '150000');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `username`
--

CREATE TABLE `username` (
  `iduser` int(11) NOT NULL,
  `user` char(150) COLLATE utf8_unicode_ci NOT NULL,
  `name` varchar(150) COLLATE utf8_unicode_ci NOT NULL,
  `pass` char(150) COLLATE utf8_unicode_ci NOT NULL,
  `phone` char(11) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `username`
--

INSERT INTO `username` (`iduser`, `user`, `name`, `pass`, `phone`) VALUES
(4, 'son12@gmail.com', 'Nguyễn Sơn', '123456', '0944705204');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `hoadon`
--
ALTER TABLE `hoadon`
  ADD PRIMARY KEY (`idhoadon`);

--
-- Chỉ mục cho bảng `nuocuong`
--
ALTER TABLE `nuocuong`
  ADD PRIMARY KEY (`idnuoc`);

--
-- Chỉ mục cho bảng `sanbanh`
--
ALTER TABLE `sanbanh`
  ADD PRIMARY KEY (`idsan`);

--
-- Chỉ mục cho bảng `tichdiem`
--
ALTER TABLE `tichdiem`
  ADD PRIMARY KEY (`idtd`);

--
-- Chỉ mục cho bảng `trongtai`
--
ALTER TABLE `trongtai`
  ADD PRIMARY KEY (`idtt`);

--
-- Chỉ mục cho bảng `username`
--
ALTER TABLE `username`
  ADD PRIMARY KEY (`iduser`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `hoadon`
--
ALTER TABLE `hoadon`
  MODIFY `idhoadon` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT cho bảng `nuocuong`
--
ALTER TABLE `nuocuong`
  MODIFY `idnuoc` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT cho bảng `sanbanh`
--
ALTER TABLE `sanbanh`
  MODIFY `idsan` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT cho bảng `tichdiem`
--
ALTER TABLE `tichdiem`
  MODIFY `idtd` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `trongtai`
--
ALTER TABLE `trongtai`
  MODIFY `idtt` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT cho bảng `username`
--
ALTER TABLE `username`
  MODIFY `iduser` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
