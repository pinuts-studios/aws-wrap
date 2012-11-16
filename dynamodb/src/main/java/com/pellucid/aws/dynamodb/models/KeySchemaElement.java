package com.pellucid.aws.dynamodb.models;

public class KeySchemaElement {

    public static enum AttributeType {
        StringType, NumberType, BinaryType
    }

    private final String attributeName;
    private final AttributeType attributeType;

    public KeySchemaElement(String attributeName, AttributeType attributeType) {
        this.attributeName = attributeName;
        this.attributeType = attributeType;
    }

    public String attributeName() {
        return this.attributeName;
    }

    public AttributeType attributeType() {
        return this.attributeType;
    }

    public aws.dynamodb.models.KeySchemaElement toScala() {
        switch (attributeType) {
        case StringType: return new aws.dynamodb.models.StringKey(attributeName);
        case NumberType: return new aws.dynamodb.models.NumberKey(attributeName);
        case BinaryType: return new aws.dynamodb.models.BinaryKey(attributeName);
        }
        return null; // Never happens
    }
}