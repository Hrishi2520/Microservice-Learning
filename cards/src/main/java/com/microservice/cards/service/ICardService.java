package com.microservice.cards.service;

import com.microservice.cards.dto.CardsDto;

public interface ICardService {

    void createCard(String mobileNumber);

    CardsDto fetchCard(String mobileNumber);

    boolean updateCard(CardsDto dto);

    boolean deleteCard(String mobileNumber);
}
