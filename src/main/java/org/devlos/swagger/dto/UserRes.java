package org.devlos.swagger.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserRes {

    @ApiModelProperty(value="사용자의 이름", example = "devlos", required = true)
    private String name;

    @ApiModelProperty(value="사용자의 나이", example = "32", required = true)
    private int age;
}
