package kingdee.test.platform.pojo;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class user extends BaseRowModel implements Serializable {
    @ExcelProperty(value="id",index =0)
    private Integer id;

    @ExcelProperty(value="username",index =1)
    private String username;

    @ExcelProperty(value="sex",index =2)
    private String sex;

    @ExcelProperty(value="birthday",index =3)
    private Date birthday;

    @ExcelProperty(value="address",index =4)
    private String address;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }
}