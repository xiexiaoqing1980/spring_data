package kingdee.test.platform.Test;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Tolerate;

import java.util.Date;


@Data
@Builder
public class data {
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

    @Tolerate   //这样才会生成无参的构造
    public data(){}
}
