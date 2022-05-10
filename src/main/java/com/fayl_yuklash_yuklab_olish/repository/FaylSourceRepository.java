package com.fayl_yuklash_yuklab_olish.repository;

import com.fayl_yuklash_yuklab_olish.model.FaylSource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FaylSourceRepository extends JpaRepository<FaylSource,Integer> {

}
