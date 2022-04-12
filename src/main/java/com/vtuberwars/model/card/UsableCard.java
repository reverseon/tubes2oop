package com.vtuberwars.model.card;

import com.vtuberwars.model.player.*;

public interface UsableCard {
    public void use(Player player, int fieldPosition, Card usingCard);
}
