import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

/**
 * Copyright (c) 2017 Peter Mao). All rights reserved.
 * Created by mao on 17-5-17.
 */
public class CityMapper extends Mapper<Object, Text,
        CityBean, LongWritable> {
    @Override
    protected void map(Object key, Text value, Context context) throws IOException, InterruptedException {
        String[] strings = value.toString().split("\\s+");
        if (strings.length != 4) {
            throw new InterruptedException("输入文件非法");
        }
        context.write(
                new CityBean(Long.parseLong(strings[0]), strings[1], Long.parseLong(strings[2]), Long.parseLong(strings[3])),
                new LongWritable(Long.parseLong(strings[0]))
        );
    }
}
