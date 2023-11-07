package com.CinemaApp.entity;

import com.CinemaApp.Model.ExistStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "seat")
public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "price")
    private double price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hallId")
    private Hall hall;

    @ManyToOne(fetch = FetchType.LAZY)
    private SeatType seatType;

    @OneToMany(
            mappedBy = "seat",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private Set<Ticket> tickets=new HashSet<>();

    @Column(name = "seat_status")
    private int seatStatus;

    @PrePersist
    private void defaultSet(){
        seatStatus= ExistStatus.ACTIVE.getId();
    }

    @CreationTimestamp
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

}
