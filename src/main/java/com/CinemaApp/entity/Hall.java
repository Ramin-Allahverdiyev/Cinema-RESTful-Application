package com.CinemaApp.entity;

import com.CinemaApp.Model.ExistStatus;
import com.CinemaApp.validation.SeatLimit;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.validation.constraints.Size;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@ToString
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "hall")
@SeatLimit
public class Hall {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @OneToMany(
            mappedBy = "hall",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private Set<Seat> seats=new HashSet<>();

    @OneToMany(
            mappedBy = "hall",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private Set<Ticket> tickets=new HashSet<>();


    @ManyToMany
    @JoinTable(name = "hall_session",
            joinColumns = @JoinColumn(name = "hall_id"),
            inverseJoinColumns = @JoinColumn(name = "session_id")
    )
    private Set<Session> sessions=new HashSet<>();

    @Column(name = "hall_status")
    private int hallStatus;

    @PrePersist
    private void defaultSet(){
        hallStatus= ExistStatus.ACTIVE.getId();
    }

    @CreationTimestamp
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}
