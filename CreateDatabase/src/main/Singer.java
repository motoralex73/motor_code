package main;

import lombok.Data;
import main.Album;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

@Data
public class Singer implements Serializable {
    private Long id;
    private String firstName;
    private String lastName;
    private Date birthDate;
    private List<Album> albums;

}
