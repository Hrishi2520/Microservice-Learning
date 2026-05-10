package com.microservice.cards.mapper;

import com.microservice.cards.dto.CardsDto;
import com.microservice.cards.entity.Cards;

public class CardsMapper {

    public static CardsDto mapToCardsDto(Cards cards, CardsDto dto) {
        dto.setCardNumber(cards.getCardNumber());
        dto.setMobileNumber(cards.getMobileNumber());
        dto.setCardType(cards.getCardType());
        dto.setTotalLimit(cards.getTotalLimit());
        dto.setAmountUsed(cards.getAmountUsed());
        dto.setAvailableAmount(cards.getAvailableAmount());
        return dto;
    }

    public static Cards mapToCards(CardsDto dto, Cards cards) {
        cards.setCardNumber(dto.getCardNumber());
        cards.setCardType(dto.getCardType());
        cards.setMobileNumber(dto.getMobileNumber());
        cards.setTotalLimit(dto.getTotalLimit());
        cards.setAmountUsed(dto.getAmountUsed());
        cards.setAvailableAmount(dto.getAvailableAmount());
        return cards;
    }
}
