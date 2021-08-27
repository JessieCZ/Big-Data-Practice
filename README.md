# Big-Data-Practice
:pushpin: Big data projects using Hadoop、Spark、Kafka、Hbase、Flink.....

Data Resource：ftp://ftp.ncdc.noaa.gov/pub/data/noaa

### Steps

#### 1、 Donwload Data

Since the data size is too large, we only download data from year of 2016：

```
wget ftp://ftp.ncdc.noaa.gov/pub/data/noaa/2016 -r
```


#### 2、 Combination and aggregation

To prepare an all-in-one file for Hadoop, we group all .gz files into one.

```
zcat *.gz > coaa.sample.txt
```

#### 3、 And upload data to HDFS (Make sure you get correct path name here)

```
hdfs dfs -mkdir -p /hadoop/ch2
hdfs dfs -copyFromLocal coaa.sample.txt /hadoop/ch2
```

