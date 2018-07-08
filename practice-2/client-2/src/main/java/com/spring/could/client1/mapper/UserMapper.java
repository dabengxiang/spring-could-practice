package com.spring.could.client1.mapper;

import com.spring.could.client1.entity.User;
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
