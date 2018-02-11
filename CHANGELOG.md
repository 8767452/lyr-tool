# Changelog

-------------------------------------------------------------------------------------------------------------

## 4.0.5

### 新特性
* 【json】 toBean方法支持Map.class参数，消除歧义
* 【core】FileWriter和FileUtil增加writeMap方法
* 【core】新增CsvWriter和CsvUtil
* 【poi】  改进ExcelWriter.flush未指定文件时的报错信息
* 【db】   在配置文件不存在时优化错误提示
* 【core】BeanUtil.beanToMap方法支持自定义key
* 【core】增加ModifierUtil，修饰符工具类
* 【http】下载文件时文件名首先从头信息中获取
* 【poi】  ExcelReader增加getCell方法
* 【db】   Oracle驱动变更
* 【extra】扩充Sftp方法（感谢@【广西】Succy）
* 【core】ImageUtil增加binary方法，生成二值化图片（感谢@【天津】〓下页）

### Bug修复
* 【poi】  修复ExcelReader获取Workbook为空的问题
* 【core】修复ImageUtil.scale的问题（感谢@【北京】千古不见一人闲）
* 【json】 修复JSON转字符串时值中双引号转义问题（感谢@【深圳】jae）

-------------------------------------------------------------------------------------------------------------

## 4.0.4

### 新特性
* 【http】    HttpUtil.downloadFile增加超时重载（感谢@【深圳】富）
* 【setting】Setting增加构造重载（pr#8@Gitee）
* 【core】   IterUtil增加fieldValueMap方法（感谢@【苏州】陈华 万缕数据@【北京】宁静）

### Bug修复
* 【log】  修复StaticLog.warn打印级别错误问题（issue#IHMF9@Gitee）
* 【core】修复MapUtil.newHashMap中isOrder（感谢@【珠海】hzhhui）
* 【core】修复DateTime.season获取的问题（感谢@西湖断桥）
* 【cron】修复在秒匹配关闭时无法匹配的问题（感谢@【北京】宁静）

-------------------------------------------------------------------------------------------------------------

## 4.0.3

### 新特性
* 【core】新增LocalPortGenerater，本地端口生成器
* 【extra】新增Sftp类，用于SFTP支持
* 【core】StrUtil增加replace（支持参数从某个位置开始）和replaceIgnoreCase方法（感谢@【贵阳】shadow ）
* 【core】Number.equals方法迁移到CharUtil（NumberUtil中依旧保留）
* 【extra】mail增加抄送和密送支持（感谢【成都】出错）
* 【poi】ExcelReader别名在返回List时也被支持（第一行）
* 【poi】ExcelReader增加getSheets和getSheetNames方法（感谢@【帝都】宁静）
* 【poi】ExcelReader增加readCellValue和readRow方法（感谢@【苏州】马克）
* 【db】全局数据源工厂独立，使用懒加载方式，消除歧义
* 【log】全局日志工厂独立，懒加载方式，消除歧义
* 【extra】MailUtil增加快捷方法支持抄送和密送参数

### Bug修复
* 【core】修复获取子路径bug（issue#IHI5K@Gitee）
* 【poi】修复ExcelReader在读取文件后未关闭导致文件被占用问题（感谢@【昆明】-@_@）
* 【log】解决Tinylog实现显示类名和行行错误问题
* 【extra】修复Mail构造在MailAccount传入null时读取错误的问题

-------------------------------------------------------------------------------------------------------------

## 4.0.2

### 新特性
* 【core】优化BeanDesc，适配更多Getter和Setter方法
* 【extra】增加基于zxing的二维码生成和解码（zxing可选依赖）
* 【core】增加VersionComparator用于版本比较，同时添加StrUtil.compareVersion
* 【core】Convert支持Map、Bean之间的转换、enum，新增BeanConverter和CastBeanConverter
* 【extra】ServletUtil中增加获取body和上传文件支持
* 【json】在json与bean互相转换时支持enum和字符串转换（感谢@【帝都】宁静）
* 【core】增加OptArrayTypeGetter接口
* 【http】HttpUtil增加decodeParamMap方法，返回单值map（感谢@【帝都】宁静）
* 【poi】ExcelWriter增加writeCellValue方法
* 【cron】去除CronUtil以及Scheduler中的isMatchYear方法（年的匹配通过表达式自动判断）
* 【extra】邮件Mail对象增加setUseGlobalSession方法，用于自定义是否使用单例会话

### Bug修复
* 【setting】修复clear方法未清空group的问题，store方法未换行问题，set方法分组丢失问题（感谢@【广西】Succy）
* 【json】修复Map嵌套转JSONObject时判断失误导致的值错误（issue#@Gitee）
* 【core】修复betweenYear注释错误（感谢@【常州】在校学生）
* 【core】修复Convert.digitToChinese方法中角为0时显示问题（issue#IHHE1@Gitee）
* 【cron】修复在秒匹配模式下5位表达式执行异常问题，修复cron.setting文件不存在报错问题
* 【extra】邮件配置中参数值转为String解决可能存在的bug

-------------------------------------------------------------------------------------------------------------

## 4.0.1

### 新特性
* 新增CharUtil
* 新增ASCIIStrCache，对ASCII字符做String对应表，提升字符转字符串性能
* 去除JschUtil中的同步修饰，改为锁
* 新增MapUtil.sort
* SymmetricCrypto支持加密后转为Base64和从Base64解密
* AsymmetricCrypto支持Hex和Base64加密解密
* 新增SecureUtil.signParams方法用于参数签名（感谢@【帝都】宁静）
* 新增Loader和LazyLoader，抽象懒加载
* 新增CsvReader,CSV读取
* HttpRequest支持可选get请求下的url参数编码
* ExcelReader增加read重载方法，ExcelUtil增加isEmpty(Sheet)方法（pr#5@Gitee）
* db模块针对IS NULL优化

### Bug修复
* 修复db模块中数据库为下划线而Bean为驼峰导致的注入失败问题（感谢@【广西】Succy）
* 修复findLike的bug（感谢@cici）
* 修复ArrayUtil.join循环引用bug
* FileTypeUtil针对pdf格式做修改（issue#IHDNH@Gitee）
* 修复Http模块中get方法拼接参数问题
* 修复db模块in方式查询错误问题
* 修复CollUtil.disjunction计算差集修复一个集合为空的情况（感谢@【天津】〓下页）
* 修复Db模块中Number参数丢失问题（感谢@【山东】小灰灰）

-------------------------------------------------------------------------------------------------------------

## 4.0.0

### 新特性
* 变更包名为cn.hutool.xxx
* 新增ObjecIdt类，用于实现MongoDB的ID生成策略
* 验证码单独成为一个模块hutool-captcha
* 新增NamedThreadFactory
* 新增BufferUtil
* POI新增StyleUtil，StyleSet新增方法可设置背景、边框等样式
* JDBC参数针对BigInteger处理
* db模块支持显示和格式化显示SQL
* 调整日志优先级：ConsoleLog优先于JDKLog，Log4j2优先于Log4j
* db模块的SqlRunner中可自定义Wrapper
* ExcelReader增加read重载方法（pr#4@Gitee）
* Convert.convert增加Class的重载，解决返回值歧义（感谢@t-io）
* Http中使用byte[]存储body，减少转换
* ExcelReader增加getWorkbook、getSheet方法
* 新增StrBuilder
* 新增JschUtil
* 新增UnicodeUtil
* db模块的BeanListHandler和BeanHandler支持Map、Collection、Array等类型
* NumberUtil加减乘支持多个值，解决float和double混合运算导致的坑

### Bug修复
* 修复ExcelReader空行导致空指针问题（pr#4@Gitee）
* 修复BeanUtil.getProperty不能获取父类属性的问题
* 修复BeanDesc类中boolean类型字段名为isXXX的情况无法注入问题
* 解决类扫描后加载类中引用依赖导致的报错（感谢@【帝都】宁静）