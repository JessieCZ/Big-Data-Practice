package job2;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class CommonFansStep2Reducer extends Reducer<Text, Text, Text, Text> {
    @Override
    protected void reduce(Text pair, Iterable<Text> fans, Context context) throws IOException, InterruptedException {
        StringBuilder sb = new StringBuilder();

        for (Text f : fans) {
            sb.append(f).append(",");
        }

        context.write(pair, new Text(sb.substring(0, sb.length() - 1)));
    }
}
