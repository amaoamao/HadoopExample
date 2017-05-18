import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.WritableComparator;

/**
 * Copyright (c) 2017 Peter Mao). All rights reserved.
 * Created by mao on 17-5-17.
 */
public class CityComparator extends WritableComparator {
    public CityComparator() {
        super(null);
    }

    protected CityComparator(Class<? extends WritableComparable> keyClass) {
        super(keyClass);
    }

    protected CityComparator(Class<? extends WritableComparable> keyClass, boolean createInstances) {
        super(keyClass, createInstances);
    }

    @Override
    public int compare(WritableComparable a, WritableComparable b) {
        assert a instanceof CityBean && b instanceof CityBean;
        return ((CityBean) a).compareTo(((CityBean) b));
    }
}
