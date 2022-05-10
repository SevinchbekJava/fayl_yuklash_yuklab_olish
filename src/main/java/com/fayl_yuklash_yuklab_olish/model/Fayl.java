package com.fayl_yuklash_yuklab_olish.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Fayl {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer faylId;
    @Column(nullable = false)
    private String OrginalFaylNomi;
    @Column(nullable = false)
    private Long FaylSize;
    @Column(nullable = false)
    private String ContentType;
}
