package kz.stolik.servicebackendstolik.controller;

import kz.stolik.servicebackendstolik.model.dto.FileDto;
import kz.stolik.servicebackendstolik.model.entity.FileStorage;
import kz.stolik.servicebackendstolik.service.FileStorageService;
import kz.stolik.servicebackendstolik.service.impl.FileStorageStorageServiceImpl;
import kz.stolik.servicebackendstolik.utils.FileUtils;
import org.modelmapper.ModelMapper;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/files")
public class FileController {
    private final FileStorageService fileStorageService;
    private final ModelMapper modelMapper;

    public FileController(FileStorageStorageServiceImpl fileStorageService) {
        this.fileStorageService = fileStorageService;
        modelMapper = new ModelMapper();
    }

    @PostMapping("/uploadFile")
    public ResponseEntity<?> uploadFile(@RequestParam("file")MultipartFile file) {
        FileStorage fileStorage = fileStorageService.upload(file);
        return ResponseEntity.ok(modelMapper.map(fileStorage, FileDto.class));
    }

    @GetMapping("/downloadFile/{fileId}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String fileId) {
        FileStorage file = fileStorageService.getByFileId(fileId);
        return FileUtils.returnFile(file);
    }
}
