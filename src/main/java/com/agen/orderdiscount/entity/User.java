package com.agen.orderdiscount.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * 管理帐号
 *
 *
 * @author SXD
 * @date 2017/12/27
 */
@Data(staticConstructor = "of")
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@Entity
@GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator" )
public class User {

    /**
     * 管理ID
     */
    @Id
    @GeneratedValue(generator = "uuid2")
    @Column(length = 36)
    private String userId;

    /**
     * 管理帐号
     */
    @Column(length = 20)
    private String userName;
    /**
     * 管理密码
     */
    @Column(length = 36)
    private String password;

    /**
     * 管理员帐户备注
     */
    @Column(length = 500)
    private String userCre;
}
