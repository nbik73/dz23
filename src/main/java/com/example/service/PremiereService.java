package com.example.service;

import com.example.annotations.MessageSend;
import com.example.model.Premiere;
import com.example.repositories.PremiereRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
public class PremiereService {

    private final PremiereRepository premiereRepository;

    public Premiere getPremiereByName(String nameOfThePremiere) {
        return premiereRepository.findByNameOfThePremiere(nameOfThePremiere).orElse(null);
    }

    @MessageSend
    public void addPremiere(String nameOfThePremiere, String description, int ageCategory, int count) {//описание премьеры
        premiereRepository.save(new Premiere(nameOfThePremiere, description, ageCategory, count));
    }

    @MessageSend
    @Transactional
    public void deletePremiere(String nameOfThePremiere) {
        premiereRepository.deleteByNameOfThePremiere(nameOfThePremiere);
    }

    @MessageSend
    @Transactional
    public void updatePremiere(String oldNameOfThePremiere, String newNameOfThePremiere, String description, int ageCategory, int count) {
        deletePremiere(oldNameOfThePremiere);
        addPremiere(newNameOfThePremiere, description, ageCategory, count);
    }

    public void printPremiers() {
        for (Premiere premiere : premiereRepository.findAll()) {
            System.out.println(premiere.getNameOfThePremiere());
        }
        System.out.println("****************************");
    }

    public void printFullDescription(String nameOfThePremiere) {
        System.out.println(getPremiereByName(nameOfThePremiere));
        System.out.println("****************************");
    }

}
