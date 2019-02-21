/*
SQLyog Community v13.1.1 (64 bit)
MySQL - 10.1.19-MariaDB : Database - sudais
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`sudais` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `sudais`;

/*Table structure for table `guru` */

DROP TABLE IF EXISTS `guru`;

CREATE TABLE `guru` (
  `alamat` varchar(255) DEFAULT NULL,
  `jk` varchar(255) DEFAULT NULL,
  `nama_guru` varchar(255) DEFAULT NULL,
  `nip` bigint(20) DEFAULT NULL,
  `no_hp` varchar(255) DEFAULT NULL,
  `tanggal_lahir` date DEFAULT NULL,
  `tempat_lahir` varchar(255) DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  `user_id` int(11) NOT NULL,
  `kelas_id` int(11) DEFAULT NULL,
  `subject_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  KEY `FK9557gaww7o9nqmflll65kmx64` (`kelas_id`),
  KEY `FK6ov8anp7d5esu2gh995lsw7t8` (`subject_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

/*Data for the table `guru` */

insert  into `guru`(`alamat`,`jk`,`nama_guru`,`nip`,`no_hp`,`tanggal_lahir`,`tempat_lahir`,`version`,`user_id`,`kelas_id`,`subject_id`) values 
('asdfghjkl','Perempuan','Devi Sarumpaet',12345678,'34567890','2010-10-10','asdfghjk',1,1,1,1),
('test','Laki -  laki','test',2345678,'0283737','2010-10-10','test',1,3,2,5),
('sdfghjk','Laki -  laki','amzes',234567,'345678','2010-10-10','wertyui',1,6,3,3);

/*Table structure for table `guru_pengumumans` */

DROP TABLE IF EXISTS `guru_pengumumans`;

CREATE TABLE `guru_pengumumans` (
  `guru_user_id` int(11) NOT NULL,
  `pengumumans_id` int(11) NOT NULL,
  UNIQUE KEY `UK_ravb0nr81ddj2do56kfmmfvbg` (`pengumumans_id`),
  KEY `FKfhrgagit0amexe4qcknnmsbi3` (`guru_user_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

/*Data for the table `guru_pengumumans` */

/*Table structure for table `guru_role` */

DROP TABLE IF EXISTS `guru_role`;

CREATE TABLE `guru_role` (
  `guru_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  KEY `FKc33a9up6i48fo9blrff7qhids` (`role_id`),
  KEY `FKddunt18mf8tklwe3fn5s9bwo` (`guru_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

/*Data for the table `guru_role` */

insert  into `guru_role`(`guru_id`,`role_id`) values 
(3,2);

/*Table structure for table `jurusan` */

DROP TABLE IF EXISTS `jurusan`;

CREATE TABLE `jurusan` (
  `id_jurusan` int(11) NOT NULL AUTO_INCREMENT,
  `jurusan` varchar(255) DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_jurusan`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

/*Data for the table `jurusan` */

insert  into `jurusan`(`id_jurusan`,`jurusan`,`version`) values 
(1,'IPA',0),
(2,'IPS',0);

/*Table structure for table `jurusan_siswas` */

DROP TABLE IF EXISTS `jurusan_siswas`;

CREATE TABLE `jurusan_siswas` (
  `jurusan_id_jurusan` int(11) NOT NULL,
  `siswas_id` int(11) NOT NULL,
  `siswas_user_id` int(11) NOT NULL,
  UNIQUE KEY `UK_qrmuddemicu63gca8cy63dltt` (`siswas_id`),
  UNIQUE KEY `UK_ctfsg9ktwtatgfxjtbuw08ra2` (`siswas_user_id`),
  KEY `FK2srbb3h6kv3o5v2d6g54tfynn` (`jurusan_id_jurusan`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

/*Data for the table `jurusan_siswas` */

/*Table structure for table `kelas` */

DROP TABLE IF EXISTS `kelas`;

CREATE TABLE `kelas` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nama_kelas` varchar(255) DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

/*Data for the table `kelas` */

insert  into `kelas`(`id`,`nama_kelas`,`version`) values 
(1,'Kelas X',0),
(2,'Kelas XI',0),
(3,'Kelas XII',0);

/*Table structure for table `kelas_gurus` */

DROP TABLE IF EXISTS `kelas_gurus`;

CREATE TABLE `kelas_gurus` (
  `kelas_id` int(11) NOT NULL,
  `gurus_user_id` int(11) NOT NULL,
  UNIQUE KEY `UK_gaax74554xy3i7jagr9nt7r72` (`gurus_user_id`),
  KEY `FKpdlgcn4nv7tlf0dbnqm5kajs9` (`kelas_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

/*Data for the table `kelas_gurus` */

/*Table structure for table `kelas_siswas` */

DROP TABLE IF EXISTS `kelas_siswas`;

CREATE TABLE `kelas_siswas` (
  `kelas_id` int(11) NOT NULL,
  `siswas_user_id` int(11) NOT NULL,
  UNIQUE KEY `UK_pb6yifsfk7w60n22r3g1fnsw6` (`siswas_user_id`),
  KEY `FKdqwdlsrlataase922kk6wotl1` (`kelas_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

/*Data for the table `kelas_siswas` */

/*Table structure for table `mapel` */

DROP TABLE IF EXISTS `mapel`;

CREATE TABLE `mapel` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `mapel` varchar(255) DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

/*Data for the table `mapel` */

insert  into `mapel`(`id`,`mapel`,`version`) values 
(1,'Bahasa Inggris',0),
(2,'Bahasa Indonesia',0),
(3,'Matematika',0),
(4,'Biologi',0),
(5,'Kimia',0),
(6,'Fisika',0),
(7,'Sejarah',0),
(8,'Akuntansi',0),
(9,'Sosiologi',0);

/*Table structure for table `mapel_gurus` */

DROP TABLE IF EXISTS `mapel_gurus`;

CREATE TABLE `mapel_gurus` (
  `subject_id` int(11) NOT NULL,
  `gurus_user_id` int(11) NOT NULL,
  UNIQUE KEY `UK_makumaemntygl7vwve16fa52m` (`gurus_user_id`),
  KEY `FK4ehre3fme1c967ln0yor52632` (`subject_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

/*Data for the table `mapel_gurus` */

/*Table structure for table `mapel_nilais` */

DROP TABLE IF EXISTS `mapel_nilais`;

CREATE TABLE `mapel_nilais` (
  `subject_id` int(11) NOT NULL,
  `nilais_id` int(11) NOT NULL,
  UNIQUE KEY `UK_4o4e9icu9l00bd71v7yby49wn` (`nilais_id`),
  KEY `FKrwrbef8lup66mp5tiv82p1dih` (`subject_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

/*Data for the table `mapel_nilais` */

/*Table structure for table `materi` */

DROP TABLE IF EXISTS `materi`;

CREATE TABLE `materi` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `deskripsi` varchar(255) DEFAULT NULL,
  `judul` varchar(255) DEFAULT NULL,
  `file_upload` varchar(255) DEFAULT NULL,
  `judul_materi` varchar(255) DEFAULT NULL,
  `modul` varchar(255) DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  `semester_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKowb8iq4afwl4oqdfss63c0w95` (`semester_id`)
) ENGINE=MyISAM AUTO_INCREMENT=15 DEFAULT CHARSET=latin1;

/*Data for the table `materi` */

insert  into `materi`(`id`,`deskripsi`,`judul`,`file_upload`,`judul_materi`,`modul`,`version`,`semester_id`) values 
(14,'HTML dan CSS',NULL,'W02S01_HTML5&CSS.pdf','Web Page: HTML & CSS ','Week 2',0,1),
(13,'Pengembangan Aplikasi Web',NULL,'W01S00-Perkenalan_Perkuliahan.pdf','Introduction to Web Techology','Week 1',0,1);

/*Table structure for table `nilai` */

DROP TABLE IF EXISTS `nilai`;

CREATE TABLE `nilai` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `kuis` int(11) DEFAULT NULL,
  `nilai_akhir` float DEFAULT NULL,
  `tugas` int(11) DEFAULT NULL,
  `uas` int(11) DEFAULT NULL,
  `uts` int(11) DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  `semester_id` int(11) DEFAULT NULL,
  `siswa_id` int(11) DEFAULT NULL,
  `subject_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKdxf0p7589m31he3ok5yfmie8g` (`semester_id`),
  KEY `FKhp7sxe3b1frr7mhx71bl7xpvo` (`siswa_id`),
  KEY `FKnltrs30v48ojjj2yomke1uvtf` (`subject_id`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

/*Data for the table `nilai` */

insert  into `nilai`(`id`,`kuis`,`nilai_akhir`,`tugas`,`uas`,`uts`,`version`,`semester_id`,`siswa_id`,`subject_id`) values 
(1,100,100,100,100,100,0,1,1,1),
(2,100,100,100,100,100,0,1,1,2),
(3,10,10,10,10,10,0,1,2,5);

/*Table structure for table `pengumuman` */

DROP TABLE IF EXISTS `pengumuman`;

CREATE TABLE `pengumuman` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `created_at` date DEFAULT NULL,
  `deskripsi` varchar(5000) DEFAULT NULL,
  `judul` varchar(255) DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  `guru_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKkusvy64i3tq8rd9js4qilqhf4` (`guru_id`)
) ENGINE=MyISAM AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

/*Data for the table `pengumuman` */

insert  into `pengumuman`(`id`,`created_at`,`deskripsi`,`judul`,`version`,`guru_id`) values 
(1,'2019-01-06','silahkan revisi data','revisi',1,3),
(3,'2019-01-05','Silahkan balik keasrama, lakukan kurve dan silahkan istirahat dengan baik!!\r\nSalam','Asrama',0,3),
(4,'2019-01-05','Test','Kuis',0,6),
(7,'2019-01-01','pabwe','pabwe',1,6),
(8,'2010-10-10','TestYou','TestYou',0,3);

/*Table structure for table `role` */

DROP TABLE IF EXISTS `role`;

CREATE TABLE `role` (
  `role_id` int(11) NOT NULL AUTO_INCREMENT,
  `role` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

/*Data for the table `role` */

insert  into `role`(`role_id`,`role`) values 
(1,'AKADEMIK'),
(2,'GURU'),
(3,'SISWA');

/*Table structure for table `semester` */

DROP TABLE IF EXISTS `semester`;

CREATE TABLE `semester` (
  `id_semester` int(11) NOT NULL AUTO_INCREMENT,
  `nama_semester` varchar(255) DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_semester`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

/*Data for the table `semester` */

insert  into `semester`(`id_semester`,`nama_semester`,`version`) values 
(1,'Semester Ganjil',0),
(2,'Semester Genap',0);

/*Table structure for table `semester_nilais` */

DROP TABLE IF EXISTS `semester_nilais`;

CREATE TABLE `semester_nilais` (
  `semester_id_semester` int(11) NOT NULL,
  `nilais_id` int(11) NOT NULL,
  UNIQUE KEY `UK_tqpjmfw5w7n2ufoyh3wgvhwlj` (`nilais_id`),
  KEY `FKdy246aylul9rmog8o8ui2rt4q` (`semester_id_semester`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

/*Data for the table `semester_nilais` */

/*Table structure for table `semester_upload_materis` */

DROP TABLE IF EXISTS `semester_upload_materis`;

CREATE TABLE `semester_upload_materis` (
  `semester_id_semester` int(11) NOT NULL,
  `upload_materis_id` int(11) NOT NULL,
  UNIQUE KEY `UK_j6k1ryvxjnd9kdxxkmxdbrxsu` (`upload_materis_id`),
  KEY `FKqhfejapekmqx2g95uahu2jdtb` (`semester_id_semester`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

/*Data for the table `semester_upload_materis` */

/*Table structure for table `siswa` */

DROP TABLE IF EXISTS `siswa`;

CREATE TABLE `siswa` (
  `alamat` varchar(255) DEFAULT NULL,
  `tempat_lahir` varchar(255) DEFAULT NULL,
  `tanggal_lahir` date DEFAULT NULL,
  `jk` varchar(255) DEFAULT NULL,
  `nama_ayah` varchar(255) DEFAULT NULL,
  `nama_ibu` varchar(255) DEFAULT NULL,
  `nama` varchar(255) DEFAULT NULL,
  `nisn` varchar(255) DEFAULT NULL,
  `no_hp` varchar(255) DEFAULT NULL,
  `agama` varchar(255) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  `user_id` int(11) NOT NULL,
  `jurusan_id` int(11) DEFAULT NULL,
  `kelas_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  KEY `FK8nv3awy442wgsi3v1okokhf9i` (`jurusan_id`),
  KEY `FKv35xn48ywafkg6h271m2nj15` (`kelas_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

/*Data for the table `siswa` */

insert  into `siswa`(`alamat`,`tempat_lahir`,`tanggal_lahir`,`jk`,`nama_ayah`,`nama_ibu`,`nama`,`nisn`,`no_hp`,`agama`,`status`,`version`,`user_id`,`jurusan_id`,`kelas_id`) values 
('dfghjk','sdfghjk','2010-10-10','Laki -  laki','asdfghjkl','sdfghjk','Amzesmoro','23456789','23456789','asdfghjk',0,0,2,1,1),
('sdfghjk','sdfghj','2010-02-20','Laki -  laki','wertyui','sdfghjk','asdfghjk','456789','234567890','sdfghjk',0,1,4,1,1),
('fgh','dfghjk','2000-02-10','Laki -  laki','sdfghjk','dfghj','wertyui','3456789','45678','sdfghjk',0,1,5,1,1),
('sdfghj','asdfghjk','2001-02-20','Laki -  laki','dfghj','dfghj','amzesmoro','2345678','345678','sdfghj',0,0,7,1,1),
('bsdh','qwdfghj','2010-10-10','Laki -  laki','vdfgsdva','bvdsfhk','testing','345678','345678','asdfghj',0,0,8,2,3),
('sdfghj','sdfghjk','2010-10-10','Laki -  laki','wsdfghj','sdfghj','wertyui','2345678','345678','asdfghj',0,1,9,2,2);

/*Table structure for table `siswa_nilais` */

DROP TABLE IF EXISTS `siswa_nilais`;

CREATE TABLE `siswa_nilais` (
  `siswa_user_id` int(11) NOT NULL,
  `nilais_id` int(11) NOT NULL,
  UNIQUE KEY `UK_bpul2dpx7ox0ipn6fol01pqkq` (`nilais_id`),
  KEY `FK1kdi3vgyj3cqg6va54u6g5t55` (`siswa_user_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

/*Data for the table `siswa_nilais` */

/*Table structure for table `siswa_role` */

DROP TABLE IF EXISTS `siswa_role`;

CREATE TABLE `siswa_role` (
  `siswa_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  KEY `FK7gx6ivom7b4wigcrgbxbu4np6` (`role_id`),
  KEY `FK4xw8ysso1q3n3pb4q6rowpxvl` (`siswa_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

/*Data for the table `siswa_role` */

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `active` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_sb8bbouer5wak8vyiiy4pf2bx` (`username`)
) ENGINE=MyISAM AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

/*Data for the table `user` */

insert  into `user`(`id`,`password`,`username`,`active`) values 
(1,'gurus','guru',1),
(2,'siswas','siswa',1),
(3,'test','test',1),
(4,'asd123','asd',1),
(5,'asus','asus',1),
(6,'amzes','amzes',1),
(7,'amzesmoro','amzesmoro',1),
(8,'testing','testing',1),
(9,'sdfghj','asdfghjk',1);

/*Table structure for table `user_role` */

DROP TABLE IF EXISTS `user_role`;

CREATE TABLE `user_role` (
  `user_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  KEY `FKa68196081fvovjhkek5m97n3y` (`role_id`),
  KEY `FK859n2jvi8ivhui0rl0esws6o` (`user_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

/*Data for the table `user_role` */

insert  into `user_role`(`user_id`,`role_id`) values 
(1,2),
(2,3),
(5,1),
(6,1),
(7,1),
(8,1),
(9,1);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
