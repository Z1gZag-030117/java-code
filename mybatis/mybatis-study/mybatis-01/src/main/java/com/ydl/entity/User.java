package com.ydl.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author 朱喆
 * @version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {

    private static final Long serialVersionUID =1L;

    private int id;
    private String username;
    private String password;

}
