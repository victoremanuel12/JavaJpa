package com.boostore.jpa.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "review")
public class ReviewModel implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(nullable = false)
    private String comment;


    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToOne
    @JoinColumn(name = "book_id")
    private BookModel book;

}
