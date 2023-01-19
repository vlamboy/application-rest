package de.example.applicationrest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Map;

@RestController
public class ConferenceRestController {

    @Autowired
    ConferenceRepository conferenceRepository;

    @Autowired
    ConferenceService conferenceService;

    @GetMapping("/api/v1/conferences")
    public List<Conference> getConferences() {
        return conferenceRepository.findAll();
    }

    @GetMapping("/api/v1/conferences/{id}")
    public ResponseEntity<Conference> getConferenceById(@PathVariable Long id)
            throws ResourceNotFoundException {
        var conferenceById = conferenceRepository.findById(id).
                orElseThrow(() -> new ResourceNotFoundException("Conference with id " + id + " does not exist."));
        return ResponseEntity.ok(conferenceById);
    }

    @PostMapping("/api/v1/conferences")
    public ResponseEntity<Conference> createConference(@RequestBody Conference conference) {
        conferenceRepository.save(conference);
        return ResponseEntity.ok(conference);
    }

    @PutMapping("/api/v1/conferences/{id}")
    public ResponseEntity<Conference> updateConference(@PathVariable Long id, @RequestBody Conference conferenceDetails) {
        Conference conferenceToUpdate = conferenceRepository.findById(id).get();
        conferenceService.updateConference(conferenceToUpdate, conferenceDetails);
        conferenceRepository.save(conferenceToUpdate);
        return ResponseEntity.ok(conferenceToUpdate);
    }

    @PatchMapping("/api/v1/conferences/{id}")
    public ResponseEntity<Conference> patchConference(@PathVariable Long id,
                                                      @RequestBody Map<String, Object> updatesOnConference) {
        Conference conferenceById = conferenceRepository.findById(id).get();
        Conference updatedConference = conferenceService.patchConference(conferenceById, updatesOnConference);
        conferenceRepository.save(updatedConference);
        return ResponseEntity.ok(updatedConference);
    }

    //jsonPtach oder Hibernate Annotation @DynamicUpdate

    @DeleteMapping("/api/v1/conferences/{id}")
    public void deleteConferenceById(@PathVariable Long id) {
        conferenceRepository.deleteById(id);
    }
    //https://www.dev-insider.de/rest-konforme-webservices-mit-spring-boot-a-1044892/


    //    @PatchMapping("/api/v1/conferences/{id}")
//    public ResponseEntity<Conference> patchConference1(@PathVariable Long id, @RequestBody Conference conference) {
//            var conferenceToUpdate = conferenceRepository.findById(id).get();
//            Conference updatedConference = conferenceRepository.save(conference);
//            URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(updatedConference.getId()).toUri();
//        return ResponseEntity.ok(conference);
//    }

    //https://stackoverflow.com/questions/45200142/spring-rest-partial-update-with-patch-method


//    @PatchMapping("/api/v1/conferences/{id}")
//    public ResponseEntity<Conference> patchManager(@PathVariable Long id, @RequestBody JsonPatch jsonPatch)
//            throws JsonPatchException, JsonProcessingException {
//        var conferenceToUpdate = conferenceService.patch(id, jsonPatch);
//        conferenceRepository.save(conferenceToUpdate);
//        return ResponseEntity.ok(conferenceToUpdate);
//    }

    // URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(createdConference.getId()).toUri();
}
