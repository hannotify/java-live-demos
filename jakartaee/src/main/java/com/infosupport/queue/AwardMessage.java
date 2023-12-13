package com.infosupport.queue;

import com.infosupport.model.MovieWithActor;

import java.io.Serializable;

public record AwardMessage(String message, MovieWithActor movie) implements Serializable {
}
