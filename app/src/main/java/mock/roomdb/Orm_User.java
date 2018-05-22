package mock.roomdb;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.Date;

/**
 * Created by BalaKrishnan on 23-02-2018.
 */

@DatabaseTable(tableName = "user")
public class Orm_User {

    @DatabaseField(columnName = "uid",generatedId = true)
    private int uid;

    @DatabaseField(columnName = "first_name")
    private String firstName;

    @DatabaseField(columnName = "last_name")
    private String lastName;

    @DatabaseField(columnName = "age")
    private int age;

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Orm_User(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public Orm_User(){}

}
