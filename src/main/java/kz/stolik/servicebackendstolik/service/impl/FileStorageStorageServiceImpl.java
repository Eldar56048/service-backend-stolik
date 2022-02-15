package kz.stolik.servicebackendstolik.service.impl;

import kz.stolik.servicebackendstolik.exception.domain.CouldNotStoreFileException;
import kz.stolik.servicebackendstolik.exception.domain.FileNameContainsInvalidPathSequenceException;
import kz.stolik.servicebackendstolik.exception.domain.FileNotFoundByIdException;
import kz.stolik.servicebackendstolik.model.entity.FileStorage;
import kz.stolik.servicebackendstolik.model.repository.FileStorageRepository;
import kz.stolik.servicebackendstolik.service.FileStorageService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;

@Service
public class FileStorageStorageServiceImpl implements FileStorageService {
    private final FileStorageRepository fileStorageRepository;

    public FileStorageStorageServiceImpl(FileStorageRepository fileStorageRepository) {
        this.fileStorageRepository = fileStorageRepository;
    }

    @Override
    public FileStorage upload(MultipartFile multipartFile) {
        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());

        try {
            if(fileName.contains("..")) {
                throw new FileNameContainsInvalidPathSequenceException();
            }
            FileStorage fileStorage = new FileStorage(fileName, multipartFile.getBytes(), multipartFile.getContentType(), multipartFile.getSize(), new Date());
            return fileStorageRepository.save(fileStorage);
        } catch (IOException ex) {
            throw new CouldNotStoreFileException();
        }
    }

    @Override
    public FileStorage getByFileId(String fileId) {
        return fileStorageRepository.findById(fileId).orElseThrow(() -> new FileNotFoundByIdException());
    }
}
