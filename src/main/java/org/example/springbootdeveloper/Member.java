package org.example.springbootdeveloper;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity
public class Member {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id", updatable=false)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

}
