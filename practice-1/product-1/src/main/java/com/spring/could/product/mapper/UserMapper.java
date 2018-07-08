package com.spring.could.product.mapper;

import com.spring.could.product.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Date:2018/7/7
 * Author:gyc
 * Desc:
 */

@Repository
public interface UserMapper extends JpaRepository<User,Long>{
}
