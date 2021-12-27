-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th12 27, 2021 lúc 03:03 PM
-- Phiên bản máy phục vụ: 10.4.22-MariaDB
-- Phiên bản PHP: 8.0.13

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `thu`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `cachly`
--

CREATE TABLE `cachly` (
  `ID` int(11) NOT NULL,
  `SoCMT` varchar(12) COLLATE utf8_unicode_ci NOT NULL,
  `tgian_bat_dau` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `muc_do_cach_ly` varchar(12) COLLATE utf8_unicode_ci DEFAULT NULL,
  `hinh_thuc_test` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `thoi_gian_test` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `Ket_qua_test` varchar(12) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `khaibao`
--

CREATE TABLE `khaibao` (
  `id_khaibao` int(11) NOT NULL,
  `SoCMT` varchar(12) COLLATE utf8_unicode_ci DEFAULT NULL,
  `da_di_qua` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `trang_thai_suc_khoe` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `ngay_khai_bao` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `khoan_thu`
--

CREATE TABLE `khoan_thu` (
  `ID_khoan_thu` int(11) NOT NULL,
  `ten_khoan_thu` varchar(50) DEFAULT NULL,
  `Sotien` int(11) NOT NULL,
  `Batbuoc` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `nhankhau`
--

CREATE TABLE `nhankhau` (
  `SoCMT` varchar(12) COLLATE utf8_unicode_ci NOT NULL,
  `Ho_ten` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `namSinh` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `gioiTinh` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `noiSinh` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `nguyenQuan` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `danToc` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `quocTich` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `noiThuongTru` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `diaChiHienNay` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `SDT` varchar(10) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `nhankhau`
--

INSERT INTO `nhankhau` (`SoCMT`, `Ho_ten`, `namSinh`, `gioiTinh`, `noiSinh`, `nguyenQuan`, `danToc`, `quocTich`, `noiThuongTru`, `diaChiHienNay`, `SDT`) VALUES
('20198327', 'Lê Hồng Quyết', '2001', 'Male', 'Unknown', NULL, 'Kinh', 'Việt Nam', NULL, 'Unknown', '03333333'),
('20207654', 'Lê Đình Hoàng Anh', '2002', 'Male', 'Unknown', NULL, 'Kinh', 'Việt Nam', NULL, 'Unknown', '0222222222'),
('20207662', 'Lê Văn Duẩn', '2002', 'Male', 'Unknown', NULL, 'Kinh', 'Việt Nam', NULL, 'Unknown', '42131414'),
('20207703', 'Nguyễn Hữu Thành', '2002', 'Male', 'Unknown', NULL, 'Kinh', 'Việt Nam', NULL, 'Unknown', '011111111'),
('20207705', 'Nguyễn Đức Tuân', '02/02/2002', 'Male', 'Thái Bình', NULL, 'Kinh', 'Việt Nam', NULL, 'Thái Bình', '011111111'),
('20207707', 'Nguyễn Sơn Tùng', '2002', 'Male', 'Unknown', '', 'Kinh', 'Viet Nam', NULL, 'Unknown', '01111111');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `ql_dong_gop`
--

CREATE TABLE `ql_dong_gop` (
  `id` int(11) NOT NULL,
  `SoCMT` varchar(12) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `ID_khoan_thu` int(11) DEFAULT NULL,
  `Ngaynop` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `userss`
--

CREATE TABLE `userss` (
  `username` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `userss`
--

INSERT INTO `userss` (`username`, `password`) VALUES
('Admin', '123456');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `cachly`
--
ALTER TABLE `cachly`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `SoCMT` (`SoCMT`);

--
-- Chỉ mục cho bảng `khaibao`
--
ALTER TABLE `khaibao`
  ADD PRIMARY KEY (`id_khaibao`),
  ADD KEY `id_nhankhau` (`SoCMT`);

--
-- Chỉ mục cho bảng `khoan_thu`
--
ALTER TABLE `khoan_thu`
  ADD PRIMARY KEY (`ID_khoan_thu`);

--
-- Chỉ mục cho bảng `nhankhau`
--
ALTER TABLE `nhankhau`
  ADD PRIMARY KEY (`SoCMT`);

--
-- Chỉ mục cho bảng `ql_dong_gop`
--
ALTER TABLE `ql_dong_gop`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_nhankhau` (`SoCMT`),
  ADD KEY `ID_khoan_thu` (`ID_khoan_thu`);

--
-- Chỉ mục cho bảng `userss`
--
ALTER TABLE `userss`
  ADD PRIMARY KEY (`username`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `cachly`
--
ALTER TABLE `cachly`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `khaibao`
--
ALTER TABLE `khaibao`
  MODIFY `id_khaibao` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `khoan_thu`
--
ALTER TABLE `khoan_thu`
  MODIFY `ID_khoan_thu` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `ql_dong_gop`
--
ALTER TABLE `ql_dong_gop`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `cachly`
--
ALTER TABLE `cachly`
  ADD CONSTRAINT `cachly_ibfk_1` FOREIGN KEY (`SoCMT`) REFERENCES `nhankhau` (`socmt`);

--
-- Các ràng buộc cho bảng `khaibao`
--
ALTER TABLE `khaibao`
  ADD CONSTRAINT `khaibao_ibfk_1` FOREIGN KEY (`SoCMT`) REFERENCES `nhankhau` (`socmt`);

--
-- Các ràng buộc cho bảng `ql_dong_gop`
--
ALTER TABLE `ql_dong_gop`
  ADD CONSTRAINT `ql_dong_gop_ibfk_1` FOREIGN KEY (`ID_khoan_thu`) REFERENCES `khoan_thu` (`ID_khoan_thu`),
  ADD CONSTRAINT `ql_dong_gop_ibfk_2` FOREIGN KEY (`SoCMT`) REFERENCES `nhankhau` (`socmt`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
