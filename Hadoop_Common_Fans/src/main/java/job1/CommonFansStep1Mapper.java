package job1;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;


public class CommonFansStep1Mapper extends Mapper<LongWritable, Text, Text, Text> {
    // output format: A:B,C,D,F,E,O
    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {

        String[] splits = value.toString().split(":");
        // Users
        String user = splits[0];
        // fans
        String[] fans = splits[1].split(",");

        // fans as key，user as value
        for (String fan : fans) {
            context.write(new Text(fan), new Text(user));
        }
    }
}
