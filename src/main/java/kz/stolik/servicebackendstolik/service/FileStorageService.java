package kz.stolik.servicebackendstolik.service;

import kz.stolik.servicebackendstolik.model.entity.FileStorage;
import org.springframework.web.multipart.MultipartFile;

public interface FileStorageService {
    FileStorage upload(MultipartFile multipartFile);
    FileStorage getByFileId(String fileId);
}
