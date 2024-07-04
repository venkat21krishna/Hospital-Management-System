

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
  `regtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `specialist` varchar(100) NOT NULL,
  `doctorDesc` varchar(100) NOT NULL,
  `age` int(2) NOT NULL,
  `phone` varchar(15) NOT NULL,
  `gender` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;




INSERT INTO `app` (`id`, `name`, `email`, `date`, `time`, `description`, `regtime`,`specialist`,`doctorDesc`,`age`,`gender`,`phone`) VALUES
(6, 'venkat', 'venkat@gmail.com', '1/20/2024', '11:00pm', 'Cold', '2024-07-11 10:12:24','cardiologist','done',40,'Male','9856985623'),
(7, 'sai', 'sai@gmail.com', '5/19/2024', '10:00pm', 'Fever', '2024-09-12 11:02:18','cardiologist','done',40,'Male','9856985623'),
(8, 'krishna', 'krishna@gmail.com', '9/4/2024', '01:30am', 'Cough', '2024-06-10 12:14:16','cardiologist','done',40,'Male','9856985623'),
(9, 'ebhuthi', 'ebhuthi@gmail.com', '5/5/2024', '12:40am', 'Fever', '2024-05-08 09:00:45','cardiologist','done',40,'Male','9856985623'),
(1, 'Sreenivasulu', 'sreenivasulu@gmail.com', '8/3/2024', '6:30pm', 'Headache', '2024-01-09 03:26:17','cardiologist','done',40,'Male','9856985623');
-- --------------------------------------------------------


CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;


INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(22),
(22);



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
  `lastseen` varchar(200) DEFAULT NULL,
  `phone` varchar(15) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;



INSERT INTO `user` (`id`, `confirmation_token`, `username`, `enabled`, `first_name`, `gender`, `last_name`, `password`, `authority`, `lastseen`,`phone`) VALUES
(11, '36983cce-975b-4a92-bf73-a4f41978e01c', 'venkat@gmail.com', b'1', 'ebhuthi', 'MALE', 'nani', 'password', 'ROLE_ADMIN', 'Thu Aug 22 00:00:56 IST 2024','7894561230'),
(12, 'ByAdmin-Panel', 'venkat1@gmail.com', b'1', 'venkat', 'Male', 'ebhuthi', 'password', 'ROLE_DOCTOR', 'Fri Jun 04 17:11:47 IST 2024','7894561231'),
(13, 'ByAdmin-Panel', 'venkat2@gmail.com', b'1', 'venkat', 'MALE', 'ebhuthi', 'password', 'ROLE_DOCTOR', 'Wed Jul 23 14:06:52 IST 2024','7894561232'),
(15, 'ByAdmin-Panel', 'venkat3@gmail.com', b'1', 'venkat', 'MALE', 'ebhuthi', 'password', 'ROLE_DOCTOR', 'Wed Jul 25 23:59:07 IST 2024','7894561233'),
(17, 'ByAdmin-Panel', 'venkat4@gmail.com', b'1', 'venkat', 'MALE', 'ebhuthi', 'password', 'ROLE_ADMIN', 'Sat Jun 08 18:25:03 IST 2024','7894561234'),
(22, 'a6866ee4-f568-47a9-9a23-2297ec37c293', 'sai@gmail.com', b'1', 'sai', 'Male', 'ebhuthi', 'password', 'ROLE_USER', 'Wed Jun 21 23:57:20 IST 2024','5894561230'),
(20, 'ByAdmin-Panel', 'krishna@gmail.com', b'1', 'Sanket', 'Male', 'krishna', 'ebhuthi', 'ROLE_DOCTOR', 'Fri Jun 14 17:14:51 IST 2024','7894561236');




ALTER TABLE `app`
  ADD PRIMARY KEY (`id`);



ALTER TABLE `user`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `Unique_Keyf654fs654` (`username`),
  ADD UNIQUE KEY `phonenumber_kldsfj` (`phone`);



ALTER TABLE `app`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;



CREATE TABLE `doctor` (
  `id` int(11) NOT NULL,
  `medicalnum` varchar(255) DEFAULT NULL,
  `specialist` varchar(255) NOT NULL,
   PRIMARY KEY (`id`),
   UNIQUE KEY `medicine_number123` (`medicalnum`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;


INSERT INTO `doctor` (`id`,`medicalnum`,`specialist`) VALUES
(12,'F27864','cardiologist'),
(13,'F27865','pathologist'),
(14,'F27866','surgeon'),
(20,'F27869','General');



CREATE TABLE `medicines` (
  `id` int(11) NOT NULL,
  `medName` varchar(255) DEFAULT NULL,
  `expDate` text NOT NULL,
  `regDate` text NOT NULL,
  `count` int(10) NOT NULL,
   PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

INSERT INTO `medicines` (`id`,`medName`,`expDate`,`regDate`,`count`) VALUES
(1,'paracetemol','21-04-2026','21-04-2024',1000),
(2,'paracetemol','21-04-2026','21-04-2024',1000),
(3,'paracetemol','21-04-2026','21-04-2024',1000),
(4,'paracetemol','21-04-2026','21-04-2024',1000),
(5,'paracetemol','21-04-2026','21-04-2024',1000);

COMMIT;