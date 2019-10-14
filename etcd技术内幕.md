# Raft协议

1. nextIndex 和 matchIndex的关系， 看上去好像nextIndex 就是 matchIndex + 1.  设置这两个值，是为了区分Leader认为已发送和实际被Follower成功结构的index， 这样可以应对Leader切换的情况. Leader切换后，nextIndex被置为自身Log已提交的最后一条日志的index, 而matchIndex被置为0.
2. Follower在投票时并不是简单地将票投给最早收到的请求节点, 还需要比较该Candidate节点的日志记录与自身的日志记录, 拒绝那些日志没有自己心的Candidate节点的投票请求, 确保将选票投给包含了全部已提交日志记录的Candidate节点. 保证已提交的日志记录不丢失. 
3. 为什么新Leader就一定保存了全部的日志记录?
4. 为了防止网络分区时, 某分区没有leader频繁选举导致Term不断增长, Raft协议中有个优化: 当某个节点要发起选举之前, 需要先进入一个叫做PreVote的状态, 在该状态下, 节点会先尝试连接集群中的其他节点, 如果能够成功连接到半数以上的节点, 才能真正发起新一轮的选举.
5. 网络分区情况下, 两个Leader都在接收用户提交, 日志不一致怎么办? (回滚)
6. Linearizable语义的实现: 客户端对于每个请求都产生一个唯一的序列号, 然后由服务端为每个客户端维护一个session, 并对每个请求去重
7. 只读请求: 可以不写日志, 也就省去了日志复制, 但是需要一定的处理防止脏读
8. Leader节点转移(手动转移的方案): 首先暂停接收客户端请求, 让一个特定的Follower节点的本地日志与当前Leader节点完全同步, 在完成同步之后, 该特定的Follower节点立刻发起新一轮的选举. 由于其Term值较大, 原Leader自然被其替换下来. 该方案需要控制好选举计时器及特定Follower与Leader节点同步的时间, 防止其他Follower节点在这段时间内发起选举.

# etcd-raft模块详解

1. Raft 结构体
2. 
3. 

