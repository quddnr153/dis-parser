package io.dis.parser.receiver.controller;

import io.dis.parser.receiver.model.Sentence;
import lombok.extern.slf4j.Slf4j;

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
    public Sentence receiveSentence(@RequestParam(value = "sentence") String clientSentence) {
        if (clientSentence.isEmpty()) {
            throw new IllegalArgumentException("Sentence sent by client should not be empty.");
        }

        log.info("Get receiveSentence. sentence = {}", clientSentence);

        Sentence sentence = new Sentence();
        sentence.setId(1L);
        sentence.setSentence(clientSentence);
        return sentence;
    }
}
