

step.7
```
redis@192.168.1.58:~> bin/redis-cli -h 192.168.1.57 -p 6379 CLUSTER MEET 192.168.1.57 6379
OK
...
redis@192.168.1.58:~> bin/redis-cli -h 192.168.1.57 -p 6379 CLUSTER MEET 192.168.1.58 6380
OK
redis@192.168.1.58:~> bin/redis-cli -h 192.168.1.57 -p 6379 CLUSTER MEET 192.168.1.58 6381
OK

```

step.8
```
redis@192.168.1.57:~>  for i in {0..5400}; do redis-cli -h 192.168.1.57 -p 6379 CLUSTER ADDSLOTS $i; done
OK
...
OK
redis@192.168.1.57:~> for i in {5401..11000}; do redis-cli -h 192.168.1.59 -p 6380 CLUSTER ADDSLOTS $i; done
OK
...
OK
redis@192.168.1.57:~> for i in {11001..16383}; do redis-cli -h 192.168.1.58 -p 6381 CLUSTER ADDSLOTS $i; done
OK
...
OK

```

step.9

```
redis@192.168.1.57:~> bin/redis-cli -h 192.168.1.57 -p 6379 CLUSTER NODES
```

step.10

