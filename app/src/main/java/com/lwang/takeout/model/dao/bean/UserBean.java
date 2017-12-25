package com.lwang.takeout.model.dao.bean;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * UserBean.class
 *
 * @author lwang
 * @date 2017/12/25.
 */
@DatabaseTable(tableName = "t_user")
public class UserBean {

    // columnName 默认可不写 为属性名 id 是否为主键  默认false
    @DatabaseField(columnName = "_id", id = true)
    public int _id;

    @DatabaseField()
    public String name;
    @DatabaseField()
    public float balance;
    @DatabaseField()
    public int discount;
    @DatabaseField()
    public int integral;
    @DatabaseField()
    public String phone;
    @DatabaseField
    public boolean login;


    //当通过 userbean 查询到数据后 把查到的数据装到一个集合中.
    @ForeignCollectionField(eager = true)
    private ForeignCollection<AddressBean> addressList;

    public UserBean() {
    }

}
