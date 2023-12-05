package com.infosupport.topic;

import com.infosupport.model.Movie;

import java.io.Serializable;

public record AwardMessage(String message, Movie movie) implements Serializable {
}
