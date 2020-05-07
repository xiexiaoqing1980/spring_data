package kingdee.test.platform.Excel;

import lombok.Builder;
import lombok.Data;

/**
 * 封装列的信息：
 */

@Data
@Builder
public class ColumnInfo {
    private String columnName;

    private String dataType;
}
