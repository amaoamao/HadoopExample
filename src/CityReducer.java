import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

/**
 * Copyright (c) 2017 Peter Mao). All rights reserved.
 * Created by mao on 17-5-17.
 */
public class CityReducer extends Reducer<CityBean,
        LongWritable, CityBean, NullWritable> {


    @Override
    protected void reduce(CityBean key, Iterable<LongWritable> values, Context context) throws IOException, InterruptedException {

        for (LongWritable value : values) {
            context.write(key, NullWritable.get());
        }
    }
}
