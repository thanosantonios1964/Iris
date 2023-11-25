package com.example.iris;

import com.example.iris.controller.IrisController;
import com.example.iris.domain.Flags;
import com.example.iris.domain.IrisJokes;
import com.example.iris.domain.IrisResponse;
import com.example.iris.domain.Joke;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import com.example.iris.constants.Constants;
class IrisControllerTest {

    @InjectMocks
    private IrisController irisController;

    @Mock
    private RestTemplate restTemplate;

    final String uri = "https://v2.jokeapi.dev/joke/Any?type=single&amount=16";
    @Test
    void testFindJoke() {
        // Arrange
        MockitoAnnotations.initMocks(this); // Initialize mocks

        // Mock the response from the external API
        IrisJokes irisJokes = new IrisJokes();
        Joke joke1 = new Joke(1, "small", new Flags(false, false), true);
        Joke joke2 = new Joke(2, "larger", new Flags(false, false), true);
        Joke joke3 = new Joke(3, "largest", new Flags(false, true), true);
        irisJokes.setJokes(Arrays.asList(joke1, joke2, joke3));

        when(restTemplate.getForObject(uri, IrisJokes.class)).thenReturn(irisJokes);

        // Act
        IrisResponse result = irisController.findjoke();

        // Assert
        assertEquals(1, result.id()); // Assuming the minimum length joke has ID 1 in this example
        assertEquals("small", result.randomJoke());
    }

    @Test
    void testJokeNotSafe() {
        // Arrange
        MockitoAnnotations.initMocks(this); // Initialize mocks

        // Mock the response from the external API
        IrisJokes irisJokes = new IrisJokes();
        Joke joke1 = new Joke(1, "small", new Flags(false, false), false);
        Joke joke2 = new Joke(2, "larger", new Flags(false, false), false);
        Joke joke3 = new Joke(3, "largest", new Flags(false, true), false);
        irisJokes.setJokes(Arrays.asList(joke1, joke2, joke3));

        when(restTemplate.getForObject(uri, IrisJokes.class)).thenReturn(irisJokes);

        // Act
        IrisResponse result = irisController.findjoke();

        // Assert
        assertEquals(-1, result.id());
        assertEquals(Constants.INAPPROPRIATE_JOKE, result.randomJoke());
    }

    @Test
    void testJokeNotFoundSexistsOrRacists() {
        // Arrange
        MockitoAnnotations.initMocks(this); // Initialize mocks

        // Mock the response from the external API
        IrisJokes irisJokes = new IrisJokes();
        Joke joke1 = new Joke(1, "small", new Flags(false, true), false);
        Joke joke2 = new Joke(2, "larger", new Flags(false, true), false);
        Joke joke3 = new Joke(3, "largest", new Flags(true, false), false);
        irisJokes.setJokes(Arrays.asList(joke1, joke2, joke3));

        when(restTemplate.getForObject(uri, IrisJokes.class)).thenReturn(irisJokes);

        // Act
        IrisResponse result = irisController.findjoke();

        // Assert
        assertEquals(-1, result.id());
        assertEquals(Constants.INAPPROPRIATE_JOKE, result.randomJoke());
    }

    @Test
    void testNoJokes() {
        // Arrange
        MockitoAnnotations.initMocks(this); // Initialize mocks

        // Mock the response from the external API
        IrisJokes irisJokes = new IrisJokes();

        when(restTemplate.getForObject(uri, IrisJokes.class)).thenThrow(RestClientException.class);

        // Act
        IrisResponse result = irisController.findjoke();

        // Assert
        assertEquals(-1, result.id());
        assertEquals(Constants.NO_JOKES, result.randomJoke());
    }
}