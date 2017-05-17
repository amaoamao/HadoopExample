import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.output.MultipleOutputs;

import java.io.IOException;

/**
 * Copyright (c) 2017 Peter Mao). All rights reserved.
 * Created by mao on 17-5-17.
 */
public class CityReducer extends Reducer<CityBean,
        LongWritable, CityBean, NullWritable> {

    private MultipleOutputs<CityBean, NullWritable> multipleOutputs;

    @Override
    protected void setup(Context context) throws IOException, InterruptedException {
        multipleOutputs = new MultipleOutputs<>(context);
    }

    @Override
    protected void reduce(CityBean key, Iterable<LongWritable> values, Context context) throws IOException, InterruptedException {

        for (LongWritable value : values) {
            multipleOutputs.write(key, NullWritable.get(), value.get() % 2 == 0 ? "even" : "odd");
        }
    }

    @Override
    protected void cleanup(Context context) throws IOException, InterruptedException {
        multipleOutputs.close();
    }
}
