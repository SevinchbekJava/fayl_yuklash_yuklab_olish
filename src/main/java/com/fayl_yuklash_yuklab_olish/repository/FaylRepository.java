package com.fayl_yuklash_yuklab_olish.repository;

import com.fayl_yuklash_yuklab_olish.model.Fayl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FaylRepository extends JpaRepository<Fayl,Integer> {

}
