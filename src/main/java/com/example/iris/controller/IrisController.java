package com.example.iris.controller;

import java.util.Comparator;
import java.util.Optional;
import com.example.iris.domain.IrisResponse;
import com.example.iris.domain.IrisJokes;
import com.example.iris.domain.Joke;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import com.example.iris.constants.Constants;

@RestController
public class IrisController {
    final String uri = "https://v2.jokeapi.dev/joke/Any?type=single&amount=16";
    RestTemplate restTemplate = new RestTemplate();

    @GetMapping("/findjoke")
    public IrisResponse findjoke() {
        IrisJokes irisJokes = null;
        try {
            irisJokes = restTemplate.getForObject(uri, IrisJokes.class);
        } catch (RestClientException e) {
            return new IrisResponse(-1,
                    Constants.NO_JOKES);
        }

        Optional<Joke> theJoke = null;
        try {
            theJoke = irisJokes.getJokes().stream().filter(joke -> joke.getSafe() && !joke.getFlags().getRacist() && !joke.getFlags().getSexist()).min(Comparator.comparingInt(joke -> joke.getJoke().length()));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        if (theJoke.isEmpty()) {
            return new IrisResponse(-1, Constants.INAPPROPRIATE_JOKE);
        }

        return new IrisResponse(theJoke.get().getId(), theJoke.get().getJoke());
    }
}
