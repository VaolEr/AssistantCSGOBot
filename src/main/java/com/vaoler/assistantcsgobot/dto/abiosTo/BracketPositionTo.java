package com.vaoler.assistantcsgobot.dto.abiosTo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BracketPositionTo {

    @NotNull
    private String part;    // The part of the bracket the series belongs to (upper bracket, lower bracket, grand final,
    // or 3rd place Series) (Enum)
    @NotNull
    private Integer col;    // The value of "column" denotes which column in that part of the bracket the series belongs.
    // Column numbers starts at 0 and are incrementally increased from right to left in each part
    // of the bracket.
    @NotNull
    private Integer offset; // Offset denotes the offset from the first Series in this part of the bracket,
    // starting with 1 in each part's respective final. Each Series offset is incrementally
    // counted from the top to the bottom in each column of the bracket.

}