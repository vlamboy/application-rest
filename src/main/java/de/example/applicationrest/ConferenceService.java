package de.example.applicationrest;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class ConferenceService {

    private final ConferenceRepository conferenceRepository;

    public ConferenceService(ConferenceRepository conferenceRepository) {
        this.conferenceRepository = conferenceRepository;
    }

     public Conference updateConference(Conference conferenceToUpdate, Conference conferenceDetails){
         conferenceToUpdate.setConferenceName(conferenceDetails.getConferenceName());
         conferenceToUpdate.setConferenceDescription(conferenceDetails.getConferenceDescription());
         conferenceToUpdate.setConferenceLocation(conferenceDetails.getConferenceLocation());
         return conferenceToUpdate;
    }

    public Conference patchConference(Conference conference, Map<String, Object> updatesOnConference) {
        ObjectMapper mapper = new ObjectMapper();

        Map<String, Object> conferenceMap = mapper.convertValue(conference, Map.class);
        for (String key : updatesOnConference.keySet()) {
            conferenceMap.put(key, updatesOnConference.get(key));
        }
        var updatedConference = mapper.convertValue(conferenceMap, Conference.class);
        return updatedConference;
    }

//    public Conference patch(long id, JsonPatch jsonPatch) throws JsonPatchException, JsonProcessingException {
//        Conference conference = conferenceRepository.findById(id).orElseThrow(EntityNotFoundException::new);
//        JsonNode patched = jsonPatch.apply(objectMapper.convertValue(conference, JsonNode.class));
//        return objectMapper.treeToValue(patched, Conference.class);
//    }
}
