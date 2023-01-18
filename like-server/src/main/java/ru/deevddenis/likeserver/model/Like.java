package ru.deevddenis.likeserver.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "like_table")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Like {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "name", unique = true, length = 15)
    private String name;

    @Column(name = "like_count")
    private long likeCount;

    @Column(name = "view_count")
    private long viewCount;

    public void increment() {
        likeCount++;
        viewCount++;
    }

}
