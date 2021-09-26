package com.springProj.demo.spring;

public class Player {
    private final String name;
    public enum State {WALKING,STANDING,RUNNING}
    private final State currentState;
    private final State previousState;
    private float stateTimer;
    public enum Direction {UP,LEFT,DOWN,RIGHT,UP_LEFT,UP_RIGHT,DOWN_LEFT,DOWN_RIGHT}
    private final boolean isLeft;
    private final Direction direction;
    private final Direction previousDirection;

    public Player(String name) {
        currentState = State.STANDING;
        previousState = State.STANDING;
        stateTimer = 0;
        direction = Direction.DOWN;
        previousDirection = direction;
        isLeft=true;
        this.name = name;
    }

    public boolean isLeft() {
        return isLeft;
    }

    public Direction getDirection() {
        return direction;
    }

    public Direction getPreviousDirection() {
        return previousDirection;
    }

    public float getStateTimer() {
        return stateTimer;
    }

    public State getCurrentState() {
        return currentState;
    }

    public State getPreviousState() {
        return previousState;
    }

    public String getName() {
        return name;
    }

    public void setStateTimer(float time){
        stateTimer = time;
    }
}
