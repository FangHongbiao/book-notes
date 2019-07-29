### RocketMQ消息发送
1. RocketMQ发送普通消息有三种实现方式: 可靠同步发送, 可靠异步发送, 单向发送(Oneway)
   1. 同步: 发送者向MQ执行发送消息API时, 同步等待, 知道消息服务器返回发送结果
   2. 异步: 发送者向MQ执行发送消息API时, 指定发送成功后的回调函数, 然后调用消息发送API后, 立即返回, 消息发送者线程不阻塞, 直到运行结束, 消息发送成功或者失败的回调任务在一个新线程中执行
   3. 单向: 发送者向MQ执行发送消息API时, 直接返回, 不等待消息服务器的结果, 也不注册回调函数, 简单地说, 就是只管发, 不在乎消息是否成功地存储在消息服务器上.
2. RocketMQ消息发送需要考虑的问题
   1. 消息队列如何进行负载
   2. 消息发送如何实现高可用
   3. 批量消息发送如何实现一致性


### RocketMQ消息存储
1. 存储概要设计
   1. RocketMQ主要存储的文件包括Comitlog文件, ConsumeQueue文件, IndexFile文件
2. MappedFile 初始化
   1. transientStorePoolEnable = true
      1. 先存储在堆外内存, 然后通过Commit线程将数据提交到内存映射Buffer中, 再通过Flush线程将内存映射Buffer中的数据持久化到磁盘中
   2. transientStorePoolEnable = false
   3. 