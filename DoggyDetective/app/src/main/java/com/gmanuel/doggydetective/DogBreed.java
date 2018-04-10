package com.gmanuel.doggydetective;

/**
 * Created by Olivia on 2018-04-08.
 */

public class DogBreed {

    private String breed;
    private String description;
    private String image;
    private String[] colors;
    private String coatPattern;
    private String coatLength;
    private String earShape;
    private String muzzleLength;
    private String size;
    private String tailLength;
    private String tailShape;
    private String[] behaviours;

    public DogBreed() {}

    public String getBreed() {
        return breed;
    }

    public String getDescription() {
        return description;
    }

    public String getImage() { return image; }

    public String[] getColors() {
        return colors;
    }

    public String getCoatPattern() {
        return coatPattern;
    }

    public String getCoatLength() {
        return coatLength;
    }

    public String getEarShape() {
        return earShape;
    }

    public String getMuzzleLength() {
        return muzzleLength;
    }

    public String getSize() {
        return size;
    }

    public String getTailLength() {
        return tailLength;
    }

    public String getTailShape() {
        return tailShape;
    }

    public String[] getBehaviours() {
        return behaviours;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setImage(String image) { this.image = image; }

    public void setColors(String[] colors) {
        this.colors = colors;
    }

    public void setCoatPattern(String coatPattern) {
        this.coatPattern = coatPattern;
    }

    public void setCoatLength(String coatLength) {
        this.coatLength = coatLength;
    }

    public void setEarShape(String earShape) {
        this.earShape = earShape;
    }

    public void setMuzzleLength(String muzzleLength) {
        this.muzzleLength = muzzleLength;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public void setTailLength(String tailLength) {
        this.tailLength = tailLength;
    }

    public void setTailShape(String tailShape) {
        this.tailShape = tailShape;
    }

    public void setBehaviours(String[] behaviours) {
        this.behaviours = behaviours;
    }
}
