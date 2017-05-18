import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.mapreduce.Partitioner;

/**
 * Copyright (c) 2017 Peter Mao). All rights reserved.
 * Created by mao on 17-5-18.
 */
public class CityPartitioner extends Partitioner<CityBean, LongWritable> {
    @Override
    public int getPartition(CityBean cityBean, LongWritable longWritable, int i) {
        System.out.println("Value = " + longWritable + " i = " + i);
        return (int) (longWritable.get() % 2 % i);
    }
}
