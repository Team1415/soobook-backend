package com.team1415.soobookbackend.core.book.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import java.util.List;
import lombok.Data;

@Data
public class SaveBookInformationRequestDto {

    @NotEmpty List<@NotNull String> queryList;
}
