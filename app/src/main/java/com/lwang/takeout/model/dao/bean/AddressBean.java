package com.lwang.takeout.model.dao.bean;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * AddressBean.class
 *
 * @author lwang
 * @date 2017/12/25.
 */
@DatabaseTable(tableName = "t_address")
public class AddressBean {

    //主键 自增
    @DatabaseField(generatedId = true)
    public int _id;

    //不能为空
    @DatabaseField(canBeNull = false)
    public String name;
    @DatabaseField(canBeNull = false)
    public String sex;
    @DatabaseField(canBeNull = false)
    public String phone;
    @DatabaseField(canBeNull = false)
    public String receiptAddress;
    @DatabaseField(canBeNull = false)
    public String detailAddress;
    @DatabaseField(canBeNull = false)
    public String label;
    @DatabaseField(canBeNull = false)
    public long timeStamp;
    @DatabaseField(canBeNull = false)
    public double longitude;
    @DatabaseField(canBeNull = false)
    public double latitude;


    //指定外键
    @DatabaseField(canBeNull = false, foreign = true, foreignColumnName = "_id", columnName = "user_id")
    public UserBean user;


    public AddressBean() {
    }

    public AddressBean(String name, String sex, String phone, String receiptAddress, String detailAddress, String label, double latitude, double longitude) {
        this.name = name;
        this.sex = sex;
        this.phone = phone;
        this.receiptAddress = receiptAddress;
        this.detailAddress = detailAddress;
        this.label = label;
        this.latitude = latitude;
        this.longitude = longitude;
        timeStamp = System.currentTimeMillis();
    }

}
