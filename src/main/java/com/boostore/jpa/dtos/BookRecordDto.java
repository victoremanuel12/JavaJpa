package com.boostore.jpa.dtos;

import java.util.Set;

public record BookRecordDto(String title, Long publisherId, Set<Long> authorIds, String reviewComent) {

}
