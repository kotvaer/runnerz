package dev.example.springbootrunnerz.pojo;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@NoArgsConstructor
@Data
@Entity
@Table(name = "run")
public class Run {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotEmpty
    @Column(unique = true, nullable = false)
    private String title;
    @NotNull
    @Column(nullable = false)
    private LocalDateTime startOn;
    @NotNull
    @Column(nullable = false)
    private LocalDateTime completeOn;
    @Positive
    @Column(nullable = false)
    private Integer miles;
    @NotNull
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Location location;

    public Run(String title, LocalDateTime startOn, LocalDateTime completeOn, Integer miles, Location location) {
        this.title = title;
        this.startOn = startOn;
        this.completeOn = completeOn;
        this.miles = miles;
        this.location = location;
    }
}

