package kz.stolik.servicebackendstolik.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import java.util.Date;

@Entity(name = "files")
@Getter
@Setter
@NoArgsConstructor
public class FileStorage {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    private String name;
    @Lob
    private byte[] data;
    private String contentType;
    private Long size;
    private Date uploadDate;

    public FileStorage(String name, byte[] data, String contentType, Long size, Date uploadDate) {
        this.name = name;
        this.data = data;
        this.contentType = contentType;
        this.size = size;
        this.uploadDate = uploadDate;
    }
}
