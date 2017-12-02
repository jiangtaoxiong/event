# event
事件驱动

# 构件工具
Maven
# 框架
SpringBoot+Mybatis

# 注意点
1、Listener监听器需要指定特定的事件类型(比如此demo中的FlightOrderEvent,已经更改)
不然在事件处理时get不到发布的事件
2、数据源需要在application.properties中修改

#使用场景

在主业务中不需要关注具体监听业务的处理流程可以使用，不然不适用。
