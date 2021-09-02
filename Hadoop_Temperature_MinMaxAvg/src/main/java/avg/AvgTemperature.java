package avg;

import common.TemperatureMapper;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;

/**
 * @program: ch2noaa, MapReduce calculating temperature data.
 * @description:
 * @author: Jessie
 * @create: 2021-08-27
 **/

// main method to set up mapper and reducer for computing average
public class AvgTemperature {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
        if (args.length != 2) {
            System.err.println("Usage: AVGTemperature <input path> <output path>");
            System.exit(-1);
        }
        // Create Mapreduce Job
        Job job = Job.getInstance();
        job.setJarByClass(AvgTemperature.class);
        job.setJobName("MapReduce-noaa-Temperature-AVG");

        FileInputFormat.addInputPath(job, new Path(args[0]));
        FileOutputFormat.setOutputPath(job, new Path(args[1]));

        job.setMapperClass(TemperatureMapper.class);
        job.setReducerClass(AvgTemperatureReducer.class);

        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(IntWritable.class);

        System.exit(job.waitForCompletion(true) ? 0 : 1);

    }
}
