CREATE TABLE IF NOT EXISTS `hms`.`booking` (
 `customer_id` int(11) default '0' NOT NULL,
 `booking_id` int(11) DEFAULT '0' NOT NULL, 
 `booking_date` bigint(20) DEFAULT NULL,
 PRIMARY KEY (`booking_id`),
 constraint fk_customerid2 FOREIGN KEY (`customer_id`) references customer(`customer_id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='booking data';