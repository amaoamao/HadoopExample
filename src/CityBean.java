import org.apache.hadoop.io.WritableComparable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

/**
 * Copyright (c) 2017 Peter Mao). All rights reserved.
 * Created by mao on 17-5-17.
 */
public class CityBean implements WritableComparable<CityBean> {
    private Long provenceId;
    private String provenceName;
    private Long gdp;
    private Long population;

    public CityBean() {

    }

    public CityBean(Long provenceId, String provenceName, Long gdp, Long population) {
        this.provenceId = provenceId;
        this.provenceName = provenceName;
        this.gdp = gdp;
        this.population = population;
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeLong(provenceId);
        dataOutput.writeUTF(provenceName);
        dataOutput.writeLong(gdp);
        dataOutput.writeLong(population);
    }

    @Override
    public void readFields(DataInput dataInput) throws IOException {
        provenceId = dataInput.readLong();
        provenceName = dataInput.readUTF();
        gdp = dataInput.readLong();
        population = dataInput.readLong();
    }

    public Long getProvenceId() {
        return provenceId;
    }

    public String getProvenceName() {
        return provenceName;
    }

    public Long getGDP() {
        return gdp;
    }

    public Long getPopulation() {
        return population;
    }

    @Override
    public String toString() {
        return provenceId + "\t" + provenceName + "\t" + gdp + "\t" + population;
    }


    @Override
    public int compareTo(CityBean cityBean) {
        int result = getProvenceId().compareTo(cityBean.getProvenceId());
        if (result == 0) {
            result = getGDP().compareTo(cityBean.getGDP());
        }
        if (result == 0) {
            result = getPopulation().compareTo(cityBean.getPopulation());
        }
        if (result == 0) {
            result = getProvenceName().compareTo(cityBean.getProvenceName());
        }
        return result;
    }
}
