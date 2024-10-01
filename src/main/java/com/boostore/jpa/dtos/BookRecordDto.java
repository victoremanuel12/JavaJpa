package com.boostore.jpa.dtos;

import java.util.Set;

public record BookRecordDto(String title, Integer publicherId, Set<Integer> authorIds, String reviewComent) {

}
