package com.source.viewer.view.price.quality;

import com.source.viewer.view.model.View;
import lombok.*;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "price_qualities")
public class PriceQuality {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", columnDefinition = "varchar(10) not null")
    private String name;

    @OneToMany(mappedBy = "priceQuality", cascade = CascadeType.PERSIST)
    private Set<View> views = new HashSet<>();
}

