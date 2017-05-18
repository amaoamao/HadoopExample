import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.mapreduce.Partitioner;

/**
 * Copyright (c) 2017 Peter Mao). All rights reserved.
 * Created by mao on 17-5-18.
 */
public class CityPartitioner extends Partitioner<CityBean, LongWritable> {
    @Override
    public int getPartition(CityBean cityBean, LongWritable longWritable, int i) {
        if (i < 2) {
            throw new RuntimeException("本程序不能在本地使用LocalJobRunner运行，请使用Hadoop：）");
        }
        return (int) (longWritable.get() % 2 % i);
    }
}
