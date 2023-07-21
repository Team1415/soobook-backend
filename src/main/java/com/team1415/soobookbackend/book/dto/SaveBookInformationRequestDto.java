package com.team1415.soobookbackend.book.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Data
public class SaveBookInformationRequestDto {

    @NotEmpty List<@NotNull String> queryList;
}
