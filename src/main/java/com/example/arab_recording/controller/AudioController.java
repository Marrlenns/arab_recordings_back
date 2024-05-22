package com.example.arab_recording.controller;
import com.example.arab_recording.entities.Audio;
import com.example.arab_recording.service.AudioService;
import lombok.AllArgsConstructor;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.logging.Logger;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Optional;
@RestController
@RequestMapping("/audio")
@AllArgsConstructor
public class AudioController {

    private final AudioService audioService;
    private static final Logger logger = Logger.getLogger(AudioController.class.getName());

    @PostMapping("/upload")
    public ResponseEntity<String> uploadAudioFile(@RequestParam("file") MultipartFile file,@RequestParam("email") String email) {
        try {
            audioService.saveAudioFile(file,email);
            return new ResponseEntity<>("File uploaded successfully", HttpStatus.OK);
        } catch (IOException | IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/download/{id}")
    public ResponseEntity<?> downloadAudioFile(@PathVariable Long id) {
        Optional<Audio> audioFileOptional = audioService.getAudioFile(id);
        if (audioFileOptional.isPresent()) {
            Audio audioFile = audioFileOptional.get();
            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + audioFile.getName() + "\"")
                    .contentType(MediaType.APPLICATION_OCTET_STREAM)
                    .contentLength(audioFile.getBytes().length)
                    .body(new InputStreamResource(new ByteArrayInputStream(audioFile.getBytes())));
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

//@GetMapping("/download/{id}")
//public ResponseEntity<?> downloadAudioFile(@PathVariable Long id) {
//    Optional<Audio> audioFileOptional = audioService.getAudioFile(id);
//    if (audioFileOptional.isPresent()) {
//        Audio audioFile = audioFileOptional.get();
//        byte[] audioBytes = audioFile.getBytes();
//
//        if (audioBytes == null || audioBytes.length == 0) {
//            logger.severe("Audio file bytes are empty");
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Audio file is empty");
//        }
//
//        InputStreamResource resource = new InputStreamResource(new ByteArrayInputStream(audioBytes));
//        logger.info("Serving audio file: " + audioFile.getName());
//
//        return ResponseEntity.ok()
//                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + audioFile.getName() + "\"")
//                .header(HttpHeaders.CONTENT_TYPE, "audio/mpeg") // Измените, если нужно
//                .contentLength(audioBytes.length)
//                .body(resource);
//    } else {
//        logger.warning("Audio file not found for id: " + id);
//        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Audio file not found");
//    }
//}
}