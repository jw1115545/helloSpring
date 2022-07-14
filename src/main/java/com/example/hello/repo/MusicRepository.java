package com.example.hello.repo;

import com.example.hello.vo.MusicVo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MusicRepository extends JpaRepository<MusicVo, Long> {
}