package by.tc.task02.view;

import by.tc.task02.entity.ComplexEntity;
import by.tc.task02.entity.Entity;
import by.tc.task02.entity.SimpleEntity;
import java.util.List;

public class PrintEntity {
    public static void print(Entity entity) {
        StringBuilder sb = new StringBuilder();

        appendEntity(sb, entity);

        System.out.println(sb);
    }
    private static void appendEntity(StringBuilder sb, Entity entity) {
        sb.append("\t");
        if (entity instanceof SimpleEntity) {
            SimpleEntity simpleEntity = (SimpleEntity) entity;
            sb.append("\t\t");
            sb.append(simpleEntity.getName());
            sb.append(": ");
            sb.append(simpleEntity.getValue());
            if (!simpleEntity.getAttributes().isEmpty()) {
                sb.append(simpleEntity.getAttributes());
            }
            sb.append("\n");
        }
        else if (entity instanceof ComplexEntity){
            ComplexEntity complexEntity = (ComplexEntity) entity;
            sb.append("\t");
            sb.append(complexEntity.getName());
            if (!complexEntity.getAttributes().isEmpty()) {
                sb.append("\t");
                sb.append(complexEntity.getAttributes());
            }
            sb.append("\n");
            if (!complexEntity.isEmptyNestedEntities()) {
                List<Entity> nestedEntities = complexEntity.getNestedEntities();
                nestedEntities.forEach((nestedEntity) -> {
                    appendEntity(sb, nestedEntity);
                });
            }
        }
    }
}
