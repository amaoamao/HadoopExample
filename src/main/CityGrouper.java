import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.WritableComparator;

/**
 * Copyright (c) 2017 Peter Mao). All rights reserved.
 * Created by mao on 17-5-17.
 */
public class CityGrouper extends WritableComparator {
    protected CityGrouper(Class<? extends WritableComparable> keyClass) {
        super(keyClass);
    }

    protected CityGrouper(Class<? extends WritableComparable> keyClass, boolean createInstances) {
        super(keyClass, createInstances);
    }
}
