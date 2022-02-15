package kz.stolik.servicebackendstolik.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class FileDto {
    private String id;
    private String name;
    private String contentType;
    private Long size;
    private Date uploadDate;
}
