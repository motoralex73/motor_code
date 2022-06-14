package main;

import lombok.Data;

import java.io.Serializable;
import java.sql.Date;

@Data
class Album implements Serializable {
    private Long id;
    private Long singerId;
    private String title;
    private Date releaseDate;
}
