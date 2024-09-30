package com.boostore.jpa.models;

import jakarta.persistence.*;
import lombok.*;

// o Serializable mostra que a classe pode ser serializada
import java.io.Serializable;

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
    //nome da chave estrangeira na tabela book
    @JoinColumn(name = "publiser_id")
    private PublisherModel publisher;
}
