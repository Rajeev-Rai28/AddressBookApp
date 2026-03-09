package com.addressbookapp.util;

import com.addressbookapp.model.Contact;
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.Reader;
import java.io.Writer;
import java.lang.reflect.Type;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AddressBookJSONIO {

    private static final Gson gson = new GsonBuilder()
            .registerTypeAdapter(LocalDate.class, new JsonSerializer<LocalDate>() {
                @Override
                public JsonElement serialize(LocalDate src, Type typeOfSrc, JsonSerializationContext context) {
                    return src == null ? JsonNull.INSTANCE : new JsonPrimitive(src.toString());
                }
            })
            .registerTypeAdapter(LocalDate.class, new JsonDeserializer<LocalDate>() {
                @Override
                public LocalDate deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
                        throws JsonParseException {
                    return (json == null || json.isJsonNull() || json.getAsString().isEmpty())
                            ? null
                            : LocalDate.parse(json.getAsString());
                }
            })
            .setPrettyPrinting()
            .create();

    public static void writeContactsToJSON(String path, List<Contact> contacts) {
        try (Writer writer = new FileWriter(path)) {
            gson.toJson(contacts, writer);
        } catch (Exception e) {
            throw new RuntimeException("JSON write error", e);
        }
    }

    public static List<Contact> readContactsFromJSON(String path) {
        try (Reader reader = new FileReader(path)) {
            Type listType = new TypeToken<List<Contact>>() {}.getType();
            List<Contact> contacts = gson.fromJson(reader, listType);
            return contacts != null ? contacts : new ArrayList<>();
        } catch (Exception e) {
            throw new RuntimeException("JSON read error", e);
        }
    }
}