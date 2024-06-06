-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th12 21, 2021 lúc 06:21 PM
-- Phiên bản máy phục vụ: 10.4.18-MariaDB
-- Phiên bản PHP: 7.3.27

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `epj2_java`
--
CREATE DATABASE IF NOT EXISTS `epj2_java` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `epj2_java`;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `movie`
--

DROP TABLE IF EXISTS `movie`;
CREATE TABLE IF NOT EXISTS `movie` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(200) NOT NULL,
  `genre` varchar(15) NOT NULL,
  `cast` varchar(100) NOT NULL,
  `director` varchar(100) NOT NULL,
  `img` varchar(100) NOT NULL,
  `duration` int(10) NOT NULL,
  `description` varchar(800) NOT NULL,
  `released` date NOT NULL,
  `created_at` date NOT NULL,
  `updated_at` date NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `movie`
--

INSERT INTO `movie` (`id`, `title`, `genre`, `cast`, `director`, `img`, `duration`, `description`, `released`, `created_at`, `updated_at`) VALUES
(38, 'RESIDENT EVIL: WELCOME TO RACCOON CITY', 'Horror', 'Kaya Scodelario, Hannah John-Kamen, Robbie Amell', 'Johannes Roberts', 'evil.jpg', 167, 'Returning to the origins of the massively popular RESIDENT EVIL franchise, fan and filmmaker Johannes Roberts brings the games to life for a whole new generation of fans. In RESIDENT EVIL: WELCOME TO RACCOON CITY, once the booming home of pharmaceutical giant Umbrella Corporation, Raccoon City is now a dying Midwestern town. The company’s exodus left the city a wasteland... with great evil brewing below the surface. When that evil is unleashed, a group of survivors must work together to uncover the truth behind Umbrella and make it through the night.', '2021-11-24', '2021-12-16', '2021-12-17'),
(39, 'THE KING\'S MAN', 'Action', 'Ralph Fiennes, Harris Dickinson, Rhys Ifans', 'Matthew Vaughn', 'kings_man.jpg', 131, 'Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry\'s standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.', '2021-12-22', '2021-12-17', '2021-12-22'),
(40, 'SPIDER-MAN: NO WAY HOME', 'Action', 'Tom Holland, Zendaya, Benedict Cumberbatch', 'Jon Watts', 'spider_man.jpg', 148, 'For the first time in the cinematic history of Spider-Man, our friendly neighborhood hero\'s identity is revealed, bringing his Super Hero responsibilities into conflict with his normal life and putting those he cares about most at risk. When he enlists Doctor Strange\'s help to restore his secret, the spell tears a hole in their world, releasing the most powerful villains who\'ve ever fought a Spider-Man in any universe. Now, Peter will have to overcome his greatest challenge yet, which will not only forever alter his own future but the future of the Multiverse.', '2021-12-17', '2021-12-17', '2021-12-17'),
(41, 'DEMON SLAYER -KIMETSU NO YAIBA- THE MOVIE: MUGEN TRAIN', 'Anime', 'Natsuki Hanae, Akari Kitô, Hiro Shimono', 'Haruo Sotozaki', 'mugen_train.jpg', 117, 'Falling forever into an endless dream... Tanjiro and the group have completed their rehabilitation training at the Butterfly Mansion, and they arrive to their next mission on the Mugen Train, where over 40 people have disappeared in a very short period of time. Tanjiro and Nezuko, along with Zenitsu and Inosuke, join one of the most powerful swordsmen within the Demon Slayer Corps, Flame Hashira Kyojuro Rengoku, to face the demon aboard the Mugen Train on track to despair.', '2021-04-23', '2021-12-17', '2021-12-17'),
(42, 'SPIDER-MAN: FAR FROM HOME', 'Action', 'Tom Holland, Samuel L. Jackson, Jake Gyllenhaal', 'Jon Watts', 'far_from_home.jpg', 129, 'Peter Parker\'s relaxing European vacation takes an unexpected turn when Nick Fury shows up in his hotel room to recruit him for a mission. The world is in danger as four massive elemental creatures -- each representing Earth, air, water and fire -- emerge from a hole torn in the universe. Parker soon finds himself donning the Spider-Man suit to help Fury and fellow superhero Mysterio stop the evil entities from wreaking havoc across the continent.', '2019-08-27', '2021-12-17', '2021-12-17'),
(43, 'BLACK PANTHER', 'Action', 'Chadwick Boseman, Michael B. Jordan, Lupita Nyong\'o', 'Ryan Coogler', 'black_panther.jpg', 134, 'After the death of his father, T\'Challa returns home to the African nation of Wakanda to take his rightful place as king. When a powerful enemy suddenly reappears, T\'Challa\'s mettle as king -- and as Black Panther -- gets tested when he\'s drawn into a conflict that puts the fate of Wakanda and the entire world at risk. Faced with treachery and danger, the young king must rally his allies and release the full power of Black Panther to defeat his foes and secure the safety of his people.', '2016-02-16', '2021-12-17', '2021-12-17'),
(46, 'DEADPOOL 2', 'Comedy', 'Ryan Reynolds, Josh Brolin, Morena Baccarin', 'David Leitch', 'dead_pool.jpg', 120, 'Wisecracking mercenary Deadpool meets Russell, an angry teenage mutant who lives at an orphanage. When Russell becomes the target of Cable -- a genetically enhanced soldier from the future -- Deadpool realizes that he\'ll need some help saving the boy from such a superior enemy. He soon joins forces with Bedlam, Shatterstar, Domino and other powerful mutants to protect young Russell from Cable and his advanced weaponry.', '2018-05-18', '2021-12-17', '2021-12-17'),
(47, 'FATE/STAY NIGHT: HEAVENS FEEL: III. SPRING SONG', 'Anime', 'Noriaki Sugiyama, Noriko Shitaya, Ayako Kawasumi', 'Tomonori Sudô', 'fate_III.jpg', 122, 'As the final act of the war commences, the ideals Shirou believes are challenged by an excruciating dilemma.', '2020-08-15', '2021-12-17', '2021-12-17');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `role`
--

DROP TABLE IF EXISTS `role`;
CREATE TABLE IF NOT EXISTS `role` (
  `id` int(11) NOT NULL,
  `name` varchar(10) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `role`
--

INSERT INTO `role` (`id`, `name`) VALUES
(0, 'admin'),
(1, 'staff');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `room`
--

DROP TABLE IF EXISTS `room`;
CREATE TABLE IF NOT EXISTS `room` (
  `id` int(11) NOT NULL,
  `room` varchar(50) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `room`
--

INSERT INTO `room` (`id`, `room`) VALUES
(1, 'A'),
(2, 'B'),
(3, 'C'),
(4, 'D'),
(5, 'E'),
(6, 'F');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `schedule`
--

DROP TABLE IF EXISTS `schedule`;
CREATE TABLE IF NOT EXISTS `schedule` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `movie_id` int(11) NOT NULL,
  `time_id` int(11) NOT NULL,
  `room_id` int(11) NOT NULL,
  `date_schedule` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `movie_id` (`movie_id`),
  KEY `room_id` (`room_id`),
  KEY `time_id` (`time_id`)
) ENGINE=InnoDB AUTO_INCREMENT=86 DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `schedule`
--

INSERT INTO `schedule` (`id`, `movie_id`, `time_id`, `room_id`, `date_schedule`) VALUES
(72, 46, 6, 1, '2021-12-21'),
(74, 39, 6, 1, '2021-12-20'),
(75, 47, 4, 1, '2021-12-21'),
(77, 42, 6, 1, '2021-12-22'),
(78, 42, 5, 1, '2021-12-21'),
(79, 41, 3, 2, '2021-12-24'),
(80, 40, 5, 2, '2021-12-25'),
(81, 43, 2, 1, '2021-12-21'),
(82, 40, 2, 1, '2021-12-22'),
(83, 46, 7, 1, '2021-12-21'),
(84, 43, 4, 3, '2021-12-23'),
(85, 39, 2, 3, '2021-12-23');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `ticket`
--

DROP TABLE IF EXISTS `ticket`;
CREATE TABLE IF NOT EXISTS `ticket` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `schedule_id` int(11) NOT NULL,
  `seat_code` varchar(50) NOT NULL,
  `total` float NOT NULL,
  `created_at` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `schedule_id` (`schedule_id`),
  KEY `user_id` (`user_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=48 DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `ticket`
--

INSERT INTO `ticket` (`id`, `user_id`, `schedule_id`, `seat_code`, `total`, `created_at`) VALUES
(37, 27, 74, 'B5', 40000, '2021-12-20 08:43:05'),
(38, 26, 75, 'D1', 60000, '2021-12-20 11:05:40'),
(39, 23, 75, 'D3', 60000, '2021-12-20 11:05:40'),
(40, 26, 75, 'D2', 60000, '2021-12-20 11:05:40'),
(41, 27, 72, 'A1', 60000, '2021-12-20 11:50:32'),
(42, 27, 75, 'A2', 60000, '2021-12-20 11:50:32'),
(43, 23, 75, 'A3', 60000, '2021-12-20 11:50:32'),
(44, 27, 83, 'C3', 40000, '2021-12-21 10:11:21'),
(45, 27, 83, 'C4', 40000, '2021-12-21 10:11:21'),
(46, 27, 83, 'A3', 40000, '2021-12-21 10:13:08'),
(47, 27, 83, 'A4', 40000, '2021-12-21 10:13:08');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `time`
--

DROP TABLE IF EXISTS `time`;
CREATE TABLE IF NOT EXISTS `time` (
  `id` int(11) NOT NULL,
  `time` varchar(10) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `time` (`time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `time`
--

INSERT INTO `time` (`id`, `time`) VALUES
(2, '10:00'),
(3, '14:00'),
(5, '16:00'),
(4, '20:00'),
(6, '22:00'),
(7, '23:00'),
(1, '8:00');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `fullname` varchar(100) NOT NULL,
  `gender` varchar(10) NOT NULL,
  `email` varchar(50) NOT NULL,
  `phone_number` varchar(32) NOT NULL,
  `address` varchar(500) NOT NULL,
  `password` varchar(32) NOT NULL,
  `birthday` date NOT NULL,
  `role_id` int(11) NOT NULL,
  `active` int(11) NOT NULL,
  `created_at` date NOT NULL,
  `updated_at` date NOT NULL,
  PRIMARY KEY (`id`),
  KEY `role_id` (`role_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `user`
--

INSERT INTO `user` (`id`, `fullname`, `gender`, `email`, `phone_number`, `address`, `password`, `birthday`, `role_id`, `active`, `created_at`, `updated_at`) VALUES
(19, 'Nguyen Quoc Anh', 'Female', 'admin@gmail.com', '0936973577', 'Hai Phong', '21232f297a57a5a743894a0e4a801fc3', '2002-07-21', 0, 1, '2021-12-12', '2021-12-12'),
(23, 'Tran Van A', 'Male', 'a@gmail.com', '3333333333', 'kk', '202cb962ac59075b964b07152d234b70', '2021-12-02', 1, 1, '2021-12-13', '2021-12-18'),
(26, 'Do Xuan Dien', 'Male', 'quoc@gmail.com', '1234567890', 'hp', '202cb962ac59075b964b07152d234b70', '2021-12-02', 1, 1, '2021-12-18', '2021-12-18'),
(27, 'Nguyen Quoc Anh', 'Male', 'abc@gmail.com', '0936973577', 'Hải Phòng', '202cb962ac59075b964b07152d234b70', '2002-07-21', 1, 1, '2021-12-20', '2021-12-20');

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `schedule`
--
ALTER TABLE `schedule`
  ADD CONSTRAINT `schedule_ibfk_2` FOREIGN KEY (`movie_id`) REFERENCES `movie` (`id`),
  ADD CONSTRAINT `schedule_ibfk_3` FOREIGN KEY (`room_id`) REFERENCES `room` (`id`),
  ADD CONSTRAINT `schedule_ibfk_4` FOREIGN KEY (`time_id`) REFERENCES `time` (`id`);

--
-- Các ràng buộc cho bảng `ticket`
--
ALTER TABLE `ticket`
  ADD CONSTRAINT `ticket_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  ADD CONSTRAINT `ticket_ibfk_3` FOREIGN KEY (`schedule_id`) REFERENCES `schedule` (`id`);

--
-- Các ràng buộc cho bảng `user`
--
ALTER TABLE `user`
  ADD CONSTRAINT `user_ibfk_1` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
