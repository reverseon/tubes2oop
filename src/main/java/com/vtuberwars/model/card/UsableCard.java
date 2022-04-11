package com.vtuberwars.model.card;

import com.vtuberwars.model.player.*;

public interface UsableCard {
    public void useBuff(Player ourPlayer, int fieldPosition);
    public void useDebuff(Player ourPlayer, Player enemyPlayer, int fieldEnemyPosition);
}
