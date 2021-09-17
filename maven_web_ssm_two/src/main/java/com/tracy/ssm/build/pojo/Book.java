package com.tracy.ssm.build.pojo;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    private Integer bookID;
    private String bookName;
    private int bookCounts;
    private String detail;

}

