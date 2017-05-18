import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;


/**
 * Copyright (c) 2017 Peter Mao). All rights reserved.
 * Created by mao on 17-5-17.
 */
public class Main {

    public static void main(String[] args) throws Exception {
        Configuration conf = new Configuration();
        Job job = Job.getInstance(conf, "City Sort");
        job.setJarByClass(Main.class);
        job.setMapperClass(CityMapper.class);
        job.setMapOutputKeyClass(CityBean.class);
        job.setMapOutputValueClass(LongWritable.class);
        job.setPartitionerClass(CityPartitioner.class);
        job.setNumReduceTasks(2);
        job.setReducerClass(CityReducer.class);
        job.setOutputKeyClass(CityBean.class);
        job.setOutputValueClass(NullWritable.class);
        FileInputFormat.addInputPath(job, new Path(args[0]));
        FileOutputFormat.setOutputPath(job, new Path(args[1]));
        System.exit(job.waitForCompletion(true) ? 0 : 1);
    }
}
