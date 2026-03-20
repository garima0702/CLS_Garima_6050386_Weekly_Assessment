package com.example.Assessment2.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.Assessment2.entity.Track;
import com.example.Assessment2.repo.ITrackRepo;

@RestController
public class TrackController {

    @Autowired
    ITrackRepo iTrackRepo;

    
    @PostMapping("/tracks")
    public ResponseEntity<String> addTrack(@RequestBody Track track) {

        iTrackRepo.save(track);
        return ResponseEntity.ok("Track added successfully");
    }

    
    @GetMapping("/tracks")
    public ResponseEntity<List<Track>> getTracks() {

        List<Track> list = iTrackRepo.findAll();

        if (list.isEmpty()) {
            return ResponseEntity.noContent().build(); 
        }

        return ResponseEntity.ok(list);
    }

    
    @GetMapping("/tracks/Bytitle")
    public ResponseEntity<List<Track>> getTracksByTitle(@RequestParam("title") String track_title) {

        List<Track> list = iTrackRepo.findByTitle(track_title);

        if (list.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(list);
    }

   
    @GetMapping("/tracks/{id}")
    public ResponseEntity<Object> getTrack(@PathVariable Integer id) {

        Optional<Track> track = iTrackRepo.findById(id);

        if (track.isPresent()) {
            return ResponseEntity.ok(track.get());
        } else {
            return ResponseEntity.status(404).body("Track not found");
        }
    }
}
