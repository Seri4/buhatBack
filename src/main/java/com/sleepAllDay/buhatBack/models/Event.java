package com.sleepAllDay.buhatBack.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "event")
@Data
@Builder
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name ="bar_id", referencedColumnName = "id")
    private Bar bar;

    @JsonBackReference
    @OneToMany(fetch = FetchType.EAGER)
    private List<User> participant;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "creator_id", referencedColumnName = "id")
    private User creator;

    @Column(name = "image_url")
    private String imageUrl;

    public Event() {
    }
}
