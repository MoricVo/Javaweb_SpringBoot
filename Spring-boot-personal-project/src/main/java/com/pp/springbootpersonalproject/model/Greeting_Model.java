package com.pp.springbootpersonalproject.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Greeting_Model {
    private int id;

    private String content;
}
