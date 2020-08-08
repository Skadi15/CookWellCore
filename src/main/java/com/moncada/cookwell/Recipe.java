package com.moncada.cookwell;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.immutables.value.Value;

import java.util.List;

@Value.Immutable
@JsonDeserialize(builder = Recipe.Builder.class)
public interface Recipe {

    static Builder builder() {
        return new Builder();
    }

    String getName();

    List<String> getInstructions();

    List<Tag> getEvents();

    @Value.Immutable
    @JsonDeserialize(builder = Tag.Builder.class)
    interface Tag {

        static Builder builder() {
            return new Builder();
        }

        String getType();

        String getValue();

        class Builder extends ImmutableTag.Builder {}

    }

    @Value.Immutable
    @JsonDeserialize(builder = Ingredient.Builder.class)
    interface Ingredient {

        static Builder builder() {
            return new Builder();
        }

        String getName();

        String getQuantity();

        String getQuantityUnit();

        String getPrepNotes();

        class Builder extends ImmutableIngredient.Builder {}

    }

    class Builder extends ImmutableRecipe.Builder {}

}
