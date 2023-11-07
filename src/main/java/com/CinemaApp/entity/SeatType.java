package com.CinemaApp.entity;

import com.CinemaApp.Model.ExistStatus;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor

@Table(name = "seatType")
public class SeatType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @OneToMany(
            mappedBy = "seatType",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private Set<Seat> seat=new HashSet<>();

    @Column(name = "stype_status")
    private int seatTypeStatus;

    @PrePersist
    private void defaultSet(){
        seatTypeStatus= ExistStatus.ACTIVE.getId();
    }

    @CreationTimestamp
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}
