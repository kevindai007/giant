create database test_db;
CREATE TABLE `giant_record_info` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `partner_code` varchar(32) NOT NULL COMMENT '合作方标示',
  `interface_id` varchar(32) NOT NULL COMMENT '接口标示',
  `id_number` varchar(32) DEFAULT NULL COMMENT '身份证号码',
  `mobile` varchar(32) DEFAULT NULL COMMENT '手机号',
  `name` varchar(32) DEFAULT NULL COMMENT '姓名',
  `extend_value` text COMMENT '扩展字段',
  `source_name` varchar(32) DEFAULT NULL COMMENT '数据源名称',
  `reason_code` char(3) NOT NULL COMMENT '结果状态码',
  `result` tinyint(4) DEFAULT NULL COMMENT '查询结果',
  `origin_result` mediumtext COMMENT '三方返回结果',
  `gmt_create` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modify` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='giant记录表';