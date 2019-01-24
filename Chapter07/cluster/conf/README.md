

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


```
root@hadoop-1:/redis/data# redis-cli -h 192.168.1.57 -p 6379 CLUSTER NODES
1ed460f2eea68d4684b2b019428b7e6483f45aba 192.168.1.57:6379@16379 myself,master - 0 0 0 connected 0-5400

root@hadoop-1:/redis/data# redis-cli -h 192.168.1.58 -p 6381 CLUSTER NODES
c693a085a7e543c7fedb17577cc37009d8045b28 :6381@16381 myself,master - 0 0 0 connected 11001-16383
 

root@hadoop-1:/redis/data# redis-cli -h 192.168.1.59 -p 6380 CLUSTER NODES
4edd0cc5130dc4d4e6ccddfe425c1aa15df896f6 :6380@16380 myself,master - 0 0 0 connected 5401-11000

```
step.10

```
redis@192.168.1.57:~> bin/redis-cli -h 192.168.1.59 -p 6379 CLUSTER REPLICATE 1ed460f2eea68d4684b2b019428b7e6483f45aba
OK
redis@192.168.1.57:~> bin/redis-cli -h 192.168.1.58 -p 6380 CLUSTER REPLICATE 4edd0cc5130dc4d4e6ccddfe425c1aa15df896f6
OK
redis@192.168.1.57:~> bin/redis-cli -h 192.168.1.57 -p 6381 CLUSTER REPLICATE c693a085a7e543c7fedb17577cc37009d8045b28
OK
```