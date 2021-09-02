package avg;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class AvgTemperatureReducer extends Reducer<Text, IntWritable, Text, IntWritable> {

    protected void reduce(Text key, Iterable<IntWritable> values, Context context)
            throws IOException, InterruptedException {
        double sum = 0;
        long num = 0;

        for (IntWritable value : values) {
            sum = sum + Double.parseDouble(value.toString());
            num++;
        }

        int avgValue = (int) (sum / num);
        context.write(key, new IntWritable(avgValue));
    }
}
