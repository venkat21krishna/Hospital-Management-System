

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";



CREATE TABLE `app` (
  `id` int(11) NOT NULL,
  `name` text NOT NULL,
  `email` text NOT NULL,
  `date` text NOT NULL,
  `time` varchar(100) NOT NULL,
  `description` text NOT NULL,
  `regtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `app`
--

INSERT INTO `app` (`id`, `name`, `email`, `date`, `time`, `description`, `regtime`) VALUES
(6, 'venkat', 'venkat@gmail.com', '1/20/2024', '11:00pm', 'Cold', '2024-07-11 10:12:24'),
(7, 'sai', 'sai@gmail.com', '5/19/2024', '10:00pm', 'Fever', '2024-09-12 11:02:18'),
(8, 'krishna', 'krishna@gmail.com', '9/4/2024', '01:30am', 'Cough', '2024-06-10 12:14:16'),
(9, 'ebhuthi', 'ebhuthi@gmail.com', '5/5/2024', '12:40am', 'Fever', '2024-05-08 09:00:45'),
(1, 'Sreenivasulu', 'sreenivasulu@gmail.com', '8/3/2024', '6:30pm', 'Headache', '2024-01-09 03:26:17');



CREATE TABLE `hibernate_sequence` (
  `next_value` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;



INSERT INTO `hibernate_sequence` (`next_value`) VALUES
(25),
(25);



CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `confirmation_token` varchar(255) DEFAULT NULL,
  `username` varchar(255) NOT NULL,
  `enabled` bit(1) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `authority` varchar(255) DEFAULT NULL,
  `lastseen` varchar(200) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `confirmation_token`, `username`, `enabled`, `first_name`, `gender`, `last_name`, `password`, `authority`, `lastseen`) VALUES
(11, '36983cce-975b-4a92-bf73-a4f41978e01c', 'venkat@gmail.com', b'1', 'ebhuthi', 'MALE', 'nani', 'password', 'ROLE_ADMIN', 'Thu Aug 22 00:00:56 IST 2024'),
(12, 'ByAdmin-Panel', 'venkat1@gmail.com', b'1', 'venkat', 'Male', 'ebhuthi', 'password', 'ROLE_DOCTOR', 'Fri Jun 04 17:11:47 IST 2024'),
(13, 'ByAdmin-Panel', 'venkat2@gmail.com', b'1', 'venkat', 'MALE', 'ebhuthi', 'password', 'ROLE_DOCTOR', 'Wed Jul 23 14:06:52 IST 2024'),
(15, 'ByAdmin-Panel', 'venkat3@gmail.com', b'1', 'venkat', 'MALE', 'ebhuthi', 'password', 'ROLE_DOCTOR', 'Wed Jul 25 23:59:07 IST 2024'),
(17, 'ByAdmin-Panel', 'venkat4@gmail.com', b'1', 'venkat', 'MALE', 'ebhuthi', 'password', 'ROLE_ADMIN', 'Sat Jun 08 18:25:03 IST 2024'),
(22, 'a6866ee4-f568-47a9-9a23-2297ec37c293', 'sai@gmail.com', b'1', 'sai', 'Male', 'ebhuthi', 'password', 'ROLE_USER', 'Wed Jun 21 23:57:20 IST 2024'),
(20, 'ByAdmin-Panel', 'krishna@gmail.com', b'1', 'Sanket', 'Male', 'krishna', 'ebhuthi', 'ROLE_DOCTOR', 'Fri Jun 14 17:14:51 IST 2024');

--

ALTER TABLE `app`
  ADD PRIMARY KEY (`id`);


ALTER TABLE `user`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_sb8bbouer5wak8vyiiy4pf2bx` (`username`);


ALTER TABLE `app`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;
COMMIT;


