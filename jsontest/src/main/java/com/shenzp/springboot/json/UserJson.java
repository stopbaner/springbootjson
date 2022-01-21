package com.shenzp.springboot.json;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.TreeNode;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.node.TextNode;
import com.shenzp.springboot.domain.User;
import org.springframework.boot.jackson.JsonComponent;

import java.io.IOException;


@JsonComponent
public class UserJson {

    //对单个pojo进行序列化
    public static class UserSerializer extends JsonSerializer<User> {

        @Override
        public void serialize(User user, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            jsonGenerator.writeStartObject();
            jsonGenerator.writeObjectField("salary", user.getSalary());
            jsonGenerator.writeEndObject();
        }

    }

    public static class UserDeserializer extends JsonDeserializer<User> {

        @Override
        public User deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
            TreeNode treeNode = jsonParser.getCodec().readTree(jsonParser);
            TextNode salary = (TextNode) treeNode.get("salary");
            return new User(salary.asDouble());
        }
    }

}



