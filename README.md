# StudentCrm

```
DROP DATABASE IF EXISTS `crm`;
CREATE DATABASE `crm` DEFAULT CHARACTER SET UTF8;
```

## 人力资源部
```
CREATE TABLE IF NOT EXISTS `crm_department` (
    `depID` VARCHAR(32) NOT NULL COMMENT '主键ID',
    `depName` VARCHAR(50) COMMENT '部门名称',
    PRIMARY KEY (`depID`)
) ENGINE=InnoDB DEFAULT CHARSET=UTF8 COMMENT='部门表';
------------------------------------------------------
CREATE TABLE IF NOT EXISTS `crm_post` (
    `postID` VARCHAR(32) NOT NULL COMMENT '主键ID',
    `postName` VARCHAR(100) COMMENT '职务名称',
    `depID` VARCHAR(32) COMMENT '部门ID',
    PRIMARY KEY (`postID`)
) ENGINE=InnoDB DEFAULT CHARSET=UTF8 COMMENT='职务表';
------------------------------------------------------
CREATE TABLE IF NOT EXISTS `crm_user` (
    `userID` VARCHAR(32) NOT NULL COMMENT '用户ID',
    `logonName` VARCHAR(100) COMMENT '登录名',
    `logonPwd` VARCHAR(100) COMMENT '密码',
    `userName` VARCHAR(100) COMMENT '员工姓名',
    `gender` VARCHAR(20) COMMENT '性别',
    `onDutyDate` DATETIME COMMENT '员工姓名',
    `postId` VARCHAR(32) COMMENT '职务ID',
    PRIMARY KEY (`userID`)
) ENGINE=InnoDB DEFAULT CHARSET=UTF8 COMMENT='员工表';
```

## 教学部
```
CREATE TABLE IF NOT EXISTS `crm_class` (
    `classID` VARCHAR(32) NOT NULL COMMENT '主键ID',
    `lessonTypeID` VARCHAR(32) COMMENT '所属课程',
    `name` VARCHAR(50) COMMENT '班级名称',
    `beginTime` DATETIME COMMENT '开班时间',
    `endTime` DATETIME COMMENT '毕业时间',
    `status` VARCHAR(20) COMMENT '状态(未开课/已开课/已结束)',
    `totalCount` INT COMMENT '学生总数',
    `upgradeCount` INT COMMENT '升学数',
    `changeCount` INT COMMENT '转班数(转来)',
    `runoffCount` INT COMMENT '退费数(流失)',
    `remark` VARCHAR(500) COMMENT '其他说明',
    `uploadPath` VARCHAR(200) COMMENT '课表路径',
    `uploadFileName` VARCHAR(200) COMMENT '课表名称',
    `uploadTime` DATETIME COMMENT '上传时间',
    PRIMARY KEY (`classID`)
) ENGINE=InnoDB DEFAULT CHARSET=UTF8 COMMENT='班级表';
------------------------------------------------------
CREATE TABLE IF NOT EXISTS `crm_lessontype` (
    `lessonTypeID` VARCHAR(32) NOT NULL COMMENT '主键ID',
    `lessonCost` DOUBLE COMMENT '课程费用',
    `total` BIGINT(11) COMMENT '总课时',
    `lessonName` VARCHAR(500) COMMENT '课程类别名称',
    `remark` VARCHAR(5000) COMMENT '课程介绍模板',
    PRIMARY KEY (`lessonTypeID`)
) ENGINE=InnoDB DEFAULT CHARSET=UTF8 COMMENT='课程类别表';
```

## 咨询部
```
CREATE TABLE IF NOT EXISTS `crm_refer` (
    `referId` VARCHAR(32) NOT NULL COMMENT '主键ID',
    `name` VARCHAR(50) COMMENT '姓名',
    `telephone` VARCHAR(50) COMMENT '电话',
    `QQ` VARCHAR(30) COMMENT 'QQ(手动填写)',
    `createDate` datetime COMMENT '建档日期,新增时系统时间,编辑时不能编辑',
    `intentionLevel` VARCHAR(50) COMMENT '意向级别',
    `lessonTypeId` VARCHAR(32) COMMENT '意向学科',
    `classId` VARCHAR(32) COMMENT '意向班级',
    `Source` VARCHAR(50) COMMENT '来源',
    `status` VARCHAR(50) COMMENT '状态(1.咨询中、2.已报名)',
    `Remark` VARCHAR(500) COMMENT '备注(手动填写)',
    `userId` VARCHAR(32) COMMENT '营销人员(从Session中获取),当前登录人的ID',
    PRIMARY KEY (`referId`)
) ENGINE=InnoDB DEFAULT CHARSET=UTF8 COMMENT='学生咨询表';
------------------------------------------------------
CREATE TABLE IF NOT EXISTS `crm_Follow` (
    `followId` VARCHAR(32) NOT NULL COMMENT '主键ID',
    `followTime` DATETIME COMMENT '跟踪时间',
    `content` VARCHAR(1000) COMMENT '内容',
    `userID` VARCHAR(32) COMMENT '营销人员(从Session中获取),当前登录人的ID',
    `referID` VARCHAR(32) COMMENT '学生咨询表的主键ID',
    PRIMARY KEY (`followId`)
) ENGINE=InnoDB DEFAULT CHARSET=UTF8 COMMENT='学生跟踪表';
```

## 学工部
```
CREATE TABLE IF NOT EXISTS `crm_Student` (
    `studentId` VARCHAR(32) NOT NULL COMMENT '学员主键ID',
    `Name` VARCHAR(50) COMMENT '姓名(从咨询表中带过来)',
    `telephone` VARCHAR(50) COMMENT	'电话(从咨询表中带过来)',
    `identity` VARCHAR(18) COMMENT '身份证号',
    `QQ` VARCHAR(11) COMMENT 'QQ(从咨询表中带过来)',
    `gender` VARCHAR(1) COMMENT	'性别',
    `mustTuition` INT COMMENT '应付学费',
    `actualTuition` INT COMMENT '实付学费',
    `email`	VARCHAR(50) COMMENT 'Email',
    `school` VARCHAR(100) COMMENT '毕业学校',
    `education` VARCHAR(50) COMMENT '学历',
    `professional` VARCHAR(50) COMMENT '专业',
    `identityAddress` VARCHAR(100) COMMENT '身份证地址',
    `address` VARCHAR(100) COMMENT '在京地址',
    `remark` VARCHAR(200) COMMENT '学员描述',
    `homeTelephone` VARCHAR(11) COMMENT '家庭联系电话',
    `homeContact` VARCHAR(50) COMMENT '家庭联系人',
    `status` VARCHAR(3) COMMENT '状态:1.新生,2.转班,3.升级,4.退费,5.毕业',
    `classID` VARCHAR(32) COMMENT '班级表的外键classID(一个学生对应一个班级，一个班级对应多个学生)',
    `referID` VARCHAR(32) COMMENT '学员咨询ID(正式学习的学员，与学生咨询表对应)',
    PRIMARY KEY (`studentId`)
) ENGINE=InnoDB DEFAULT CHARSET=UTF8 COMMENT='学员信息表';
------------------------------------------------------
CREATE TABLE IF NOT EXISTS `crm_Station` (
    `stationID` VARCHAR(32) NOT NULL COMMENT '升级转班主键ID',
    `studentID` VARCHAR(32) COMMENT '学员主键ID',
    `flag` VARCHAR(50) COMMENT '升级/转班(标识):1表示升级,2表示转班,可以通过选择班级的日期判断',
    `userId` VARCHAR(32) COMMENT '经办人(登录用户)',
    `createDate` DATETIME COMMENT '操作时间(当前时间)',
    `beforeClassId` VARCHAR(32) COMMENT '之前的班级ID',
    `afterClassId` VARCHAR(32) COMMENT '之后的班级ID',
    PRIMARY KEY (`stationID`)
) ENGINE=InnoDB DEFAULT CHARSET=UTF8 COMMENT='学生升级/转班信息表';
------------------------------------------------------
CREATE TABLE IF NOT EXISTS `crm_RunOff` (
    `runOffId` VARCHAR(32) NOT NULL COMMENT '流失主键ID',
    `studentId` VARCHAR(32) COMMENT '学员主键ID',
    `userId` VARCHAR(32) COMMENT '业务人员,经办人',
    `createDate` DATETIME COMMENT '流失时间',
    `isRefund` VARCHAR(20) COMMENT '是否退款',
    `refundAmount` VARCHAR(20) COMMENT '退款金额',
    `remark` VARCHAR(20) COMMENT '描述(流失原因)',
    PRIMARY KEY (`runOffId`)
) ENGINE=InnoDB DEFAULT CHARSET=UTF8 COMMENT='学生流失情况信息表';
```

## 就业部
```
CREATE TABLE IF NOT EXISTS `crm_graduate` (
    `granduateId` VARCHAR(32) NOT NULL COMMENT '学生就业ID',
    `studentId` VARCHAR(32) COMMENT '学员主键ID',
    `companyName` VARCHAR(100) COMMENT '就业公司名称',
    `salary` VARCHAR(50) COMMENT '薪资',
    `post` VARCHAR(50) COMMENT '职务',
    `entryTime` DATETIME COMMENT '入职时间',
    `remark` VARCHAR(500) COMMENT '备注',
    `classID` VARCHAR(50) COMMENT '班级主键ID',
    PRIMARY KEY (`granduateId`)
) ENGINE=InnoDB DEFAULT CHARSET=UTF8 COMMENT='学生就业信息表';
```