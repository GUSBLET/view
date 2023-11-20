package com.source.viewer.user;

import com.source.viewer.view.model.View;
import lombok.*;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "telegram_id", columnDefinition = "bigint unique")
    private Long telegramId;


    @OneToMany(mappedBy = "user", cascade = CascadeType.PERSIST)
    private Set<View> views = new HashSet<>();
}
