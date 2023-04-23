package com.zz.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 朱喆
 * @version 1.0
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("tb_user")
public class User {

    private int id;
    private String userName;
    private String password;
    private String gender;
    private String addr;


}
