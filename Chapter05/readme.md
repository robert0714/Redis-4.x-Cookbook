# Chapter 5 : Replication

##  Setting up Redis replication


Prepare a configuration file for the Redis slave server. You can make a copy of redis.conf
and rename it redis-slave.conf , then make the following changes:

```
port 6380
pidfile /var/run/redis_6380.pid
dir ./slave
slaveof 127.0.0.1 6379
```

Don't forget to create /redis/slave directory if it doesn't exist:
```
$mkdir -p /redis/slave
```

Open two Terminals and connect to the master server at 127.0.0.1:6379 and
127.0.0.1:6380 using redis-cli :

```
$ bin/redis-cli -p 6379
127.0.0.1:6379>


$ bin/redis-cli -p 6380
127.0.0.1:6380>
```

Run INFO REPLICATION on both Terminals:

```
127.0.0.1:6379> INFO REPLICATION
# Replication
role:master
connected_slaves:1
slave0:ip=127.0.0.1,port=6380,state=online,offset=557,lag=1
master_replid:1fee079fc47716706a59225779c56b0e7033f3b1
master_replid2:0000000000000000000000000000000000000000
master_repl_offset:557
second_repl_offset:-1
repl_backlog_active:1
repl_backlog_size:1048576
repl_backlog_first_byte_offset:1
repl_backlog_histlen:557


127.0.0.1:6380> INFO REPLICATION
# Replication
role:slave
master_host:127.0.0.1
master_port:6379
master_link_status:up
master_last_io_seconds_ago:7
master_sync_in_progress:0
slave_repl_offset:557
slave_priority:100
slave_read_only:1
connected_slaves:0
master_replid:1fee079fc47716706a59225779c56b0e7033f3b1
master_replid2:0000000000000000000000000000000000000000
master_repl_offset:557
second_repl_offset:-1
repl_backlog_active:1
repl_backlog_size:1048576
repl_backlog_first_byte_offset:1
repl_backlog_histlen:557

```