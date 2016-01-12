自动升级

简述：
    1. 直接提供一个可完成app的更新检查和下载安装功能
    
    
思路：


UpdateManager是管理类
UpdateOptions配置选项
        配置包括：UpdatePeriod更新级别和周期
AbstractUpdateListener 抽象的更新接口
AbstractParser 抽象的检查结果解析器
UpdateInfo 更新的实体类



    