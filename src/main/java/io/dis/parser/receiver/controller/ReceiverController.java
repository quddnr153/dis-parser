package io.dis.parser.receiver.controller;

import io.dis.parser.receiver.model.Sentence;
import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Byungwook Lee on 10/1/2017
 * quddnr153@gmail.com
 * https://github.com/quddnr153
 */
@Slf4j
@RestController
public class ReceiverController {
    @GetMapping("/receiver")
    public Sentence receiveSentence(@RequestParam(value = "sentence") String clientSentence) throws IOException, InterruptedException {
        if (clientSentence.isEmpty()) {
            throw new IllegalArgumentException("Sentence sent by client should not be empty.");
        }

        log.info("Get receiveSentence. sentence = {}", clientSentence);

        if (clientSentence.toLowerCase().equals("jarvis")) {
            log.info("Say hello");
            Process process = Runtime.getRuntime().exec("python ~/Document/git-projects/dis-tts/hello-jarvis.py");
            process.waitFor();

            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

            String line;
            while ((line = reader.readLine())!= null) {
                log.info(line);
            }
        }

        Sentence sentence = new Sentence();
        sentence.setId(1L);
        sentence.setSentence(clientSentence);
        return sentence;
    }
}
