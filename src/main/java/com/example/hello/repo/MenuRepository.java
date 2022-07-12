package com.example.hello.repo;

import com.example.hello.vo.MenuVo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuRepository extends JpaRepository<MenuVo, Long> {


}
