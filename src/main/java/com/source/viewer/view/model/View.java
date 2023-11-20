package com.source.viewer.view.model;


import com.source.viewer.user.User;
import com.source.viewer.view.company.Company;
import com.source.viewer.view.price.quality.PriceQuality;
import lombok.*;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "views")
public class View {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "item_name", columnDefinition = "varchar(200) not null, unique")
    private String itemName;

    @Column(name = "creating_date", columnDefinition = "date")
    private LocalDate creatingDate;

    @Column(name = "mview_path", columnDefinition = "text not null, unique")
    private String mviewPath;

    @ManyToOne
    @JoinColumn(name = "price_quality_id")
    private PriceQuality priceQuality;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
