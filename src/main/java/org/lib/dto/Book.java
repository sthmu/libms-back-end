package org.lib.dto;

import jdk.jfr.DataAmount;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {
        private String isbn;
        private String title;
        private String author;
        private String category;
        private Integer qty;

}
