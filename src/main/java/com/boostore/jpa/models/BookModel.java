package com.boostore.jpa.models;

import com.fasterxml.jackson.annotation.JsonProperty;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // nornalmente usar UUID como chave primaria é comum em arquiteturas distribuidas
    private Long id;
    @Column(nullable = false, unique = true)
    private String title;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "publiser_id")
    private PublisherModel publisher;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "book_author",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id")
    )
    private Set<AuthorModel> authors = new HashSet<>();

    @OneToOne(mappedBy = "book", cascade = CascadeType.ALL)
    private ReviewModel review;
}
//SELECT
//b.title AS BookTitle,
//a.name AS AuthorName
//        FROM
//book AS b
//INNER JOIN
//book_author AS ba
//ON b.id = ba.book_id
//INNER JOIN
//author AS a
//ON ba.author_id = a.id
//WHERE a.id = 1
//Exemplo de query e entendimento do pq tevemos ter uma tabela central em relações muitos para muitos