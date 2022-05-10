package com.fayl_yuklash_yuklab_olish.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class FaylSource {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer sourceID;
    private byte[] SourceFayl;
    @OneToOne
    Fayl fayl;
}
