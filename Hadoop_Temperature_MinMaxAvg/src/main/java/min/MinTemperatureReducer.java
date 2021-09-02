package min;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;


public class MinTemperatureReducer extends Reducer<Text, IntWritable, Text, IntWritable> {

    @Override
    protected void reduce(Text key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException {
        // -inf: keep renewing it when find a larger val
        int minValue = Integer.MAX_VALUE;
        for (IntWritable value : values) {
            // Maximum
            minValue = Math.max(minValue, value.get());
        }
        context.write(key, new IntWritable(minValue));

    }
}
