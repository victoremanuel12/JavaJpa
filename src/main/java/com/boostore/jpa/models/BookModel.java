package com.boostore.jpa.models;

import jakarta.persistence.*;
import lombok.*;

// o Serializable mostra que a classe pode ser serializada
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "book")
public class BookModel implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    // nornalmente usar UUID como chave primaria é comum em arquiteturas distribuidas
    private Integer id;
    @Column(nullable = false, unique = true)
    private String title;

    @ManyToOne
    @JoinColumn(name = "publiser_id")
    private PublisherModel publisher;

    @ManyToMany
    @JoinTable(
            name = "book_author",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id")
    )
    private Set<AuthorModel> authors = new HashSet<>();

    @OneToOne(mappedBy = "book", cascade = CascadeType.ALL)
    private ReviewModel review;
}
