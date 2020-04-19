package com.tw.hellocosmoss.model;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DevTask {
    private String id;

    private String taskName;
    private String developerName;
    private String status;
}
