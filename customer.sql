CREATE TABLE IF NOT EXISTS `hms`.`customer` (
 `customer_id` int(11) DEFAULT '0' NOT NULL,
 `customer_name` varchar(64) COLLATE utf8_unicode_ci NOT NULL,
 `credit_card` varchar(64) COLLATE utf8_unicode_ci NOT NULL,
 `reg_date` bigint(20) DEFAULT NULL,
 PRIMARY KEY(`customer_id`),
 constraint fk_customerid FOREIGN KEY (`customer_id`) references person(`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='customer data';