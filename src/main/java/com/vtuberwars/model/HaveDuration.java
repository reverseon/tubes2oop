package com.vtuberwars.model;

interface HaveDuration {
    public void reduceDuration();
    public int getDuration();
    public void activedSpell();
    public void deactivedSpell();
    public boolean isActive();
}
