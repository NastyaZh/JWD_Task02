package by.tc.task02.dao.parser;

import by.tc.task02.dao.EntityCreator;
import by.tc.task02.entity.ComplexEntity;
import by.tc.task02.entity.Entity;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
    private static final Pattern OPEN_TAG =
            Pattern.compile("<([\\w-_.]+)[ \\t]*" +
                    "([ \\t]*[\\w-_.]+[ \\t]*=[ \\t]*\"[\\p{Graph}]+\")*>");

    private static final Pattern CLOSE_TAG =
            Pattern.compile("</[ \\t]*[\\w-_.]+[ \\t]*>");
    
    private static final Pattern ATTRIBUTE =
            Pattern.compile("([\\w-_.]+)[ \\t]*=[ \\t]*\"([\\p{Graph}]+)\"");
    
    private static final Pattern SIMPLE_NODE =
            Pattern.compile("<([\\w-_.]+)[ \\t]*" +
                    "([ \\t]*[\\w-_.]+[ \\t]*=[ \\t]*\"[\\p{Graph}]+\")*>" +
                    "([\\p{Graph}[ \\t]]+)" +
                    "</[ \\t]*[\\w-_.]+[ \\t]*>");
    
    public Entity parseXml(String xmlLine) {
        String charXml = "", nextChar = "";
        Stack<Entity> stack = new Stack<>();

        for (int i = 0; i < xmlLine.length() - 1; i++) {
            charXml += xmlLine.charAt(i);
            nextChar = String.valueOf(xmlLine.charAt(i + 1));

            if (OPEN_TAG.matcher(charXml).matches() && nextChar.equals("<")) { 
                stack.push(makeComplexEntity(charXml));
                charXml = "";
            } else {
                if (SIMPLE_NODE.matcher(charXml).matches()) {
                    Entity entity = makeSimpleEntity(charXml);
                    putInEntity(stack, entity);
                   charXml = "";
                } else {
                    if (CLOSE_TAG.matcher(charXml).matches()) {
                        Entity entity = stack.pop();
                        putInEntity(stack, entity);
                        charXml = "";
                    }
                }
            }
        }

        if (SIMPLE_NODE.matcher(charXml + nextChar).matches()) {
            return makeSimpleEntity(charXml + nextChar);
        }
        return stack.pop();
    }

    private Entity makeComplexEntity(String xmlEntity) {
        Matcher matcher = OPEN_TAG.matcher(xmlEntity);
        matcher.find();
        String name = matcher.group(1);
        return EntityCreator.createEntity(name, makeAttributes(xmlEntity));
    }

    private Entity makeSimpleEntity(String xmlEntity) {
        Matcher matcher = SIMPLE_NODE.matcher(xmlEntity);
        matcher.find();
        String name = matcher.group(1);
        String value = matcher.group(3);
        return EntityCreator.createEntity(name, value, makeAttributes(xmlEntity));
    }

    private Map<String, String> makeAttributes(String xmlEntity) {
        Map<String, String> attributes = new HashMap<>();

        Matcher matcher = ATTRIBUTE.matcher(xmlEntity);
        while (matcher.find()) {
            attributes.put(matcher.group(1), matcher.group(2));
        }

        return attributes;
    }

    private void putInEntity(Stack<Entity> stack, Entity entity) {
        ComplexEntity nestedEntities = (ComplexEntity) stack.pop();
        nestedEntities.addNestedEntities(entity);
        stack.push(nestedEntities);
    }
}
