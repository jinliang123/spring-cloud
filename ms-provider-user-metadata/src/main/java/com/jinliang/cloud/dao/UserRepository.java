package com.jinliang.cloud.dao;

import com.jinliang.cloud.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by jinliang on 2017/11/24.
 */
public interface UserRepository extends JpaRepository<User,Long>{
}
