package com.boostore.jpa.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "publisher")
public class PublisherModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(nullable = false, unique = true)
    private String name;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    //    JsonProperty.Access.WRITE_ONLY significa que essa propriedade (bookModel) será usada apenas durante a deserialização
    //    (quando você estiver convertendo JSON para um objeto Java).
    //    Ou seja, essa propriedade não será incluída ao serializar o objeto para JSON,
    //    mas pode ser definida quando recebida via JSON (ao criar ou modificar um objeto).
    @OneToMany(mappedBy = "publisher", fetch = FetchType.LAZY)
    //    mappedBy = "publisher" significa que o atributo publisher na classe BookModel é o que mapeia o relacionamento entre a entidades
    //    FetchType.LAZY os dados relacionados só serão carregados quando explicitamente acessados,
    //    em vez de serem carregados automaticamente quando a entidade Publisher for carregada.
    private Set<BookModel> books = new HashSet<>();
}
