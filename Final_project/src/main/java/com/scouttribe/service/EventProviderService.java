package com.scouttribe.service;

import com.scouttribe.entity.EventProvider;
import com.scouttribe.repository.EventProviderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventProviderService {

    @Autowired
    private EventProviderRepository eventProviderRepository;

    // Method to create a new EventProvider
    public EventProvider saveEventProvider(EventProvider provider) {

        // Save the EventProvider in the database
        return eventProviderRepository.save(provider);
    }
}
