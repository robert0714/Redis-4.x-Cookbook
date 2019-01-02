# Chapter 4 : Developing with Redis

### When to use Redis in your application

#### Session store

#### Analytics

#### Leaderboards


#### Queues


#### Latest N records

#### Caching



### Using the correct data types
 
### Using the correct Redis APIs

### Connecting to Redis with Java

### Connecting to Redis with Python

### Connecting to Redis with Spring Data Redis

we run the demo and test the API using Swagger-ui at http://127.0.0.1:8080/swagger-ui.html .

After the creation of a user called Mike , we view the user data with redis-cli :
```
127.0.0.1:6379> hgetall user
1) "0000088211"
2)
{\"id\":\"0000088211\",\"name\":\"Mike\",\"sex\":\"Male\",\"nation\
":\"US\",\"register_time\":1507448493}"
```

### Writing a MapReduce job for Redis
1. First, we prepare sample data using the shell script, preparedata_mr.sh :
```
$ bash preparedata_mr.sh
OK
unix2dos: converting file mr.data to DOS format ...
All data transferred. Waiting for the last reply...
Last reply received from server.
errors: 0, replies: 10000
```
2. We can explore the data with redis-cli :
```
127.0.0.1:6379> SCAN 0
1) "7"
2) 1) "user:0000006"
   2) "user:0000000"
   3) "user:0000008"
   4) "user:0000004"
   5) "user:0000003"
   6) "user:0000002"
   7) "user:0000007"
   8) "user:0000001"
   9) "user:0000009"
  10) "user:0000005"

127.0.0.1:6379> SCAN 7
1) "0"
2) 1) "user:0000010"
```


### Writing a Spark job for Redis

