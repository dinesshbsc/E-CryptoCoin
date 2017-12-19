/**
 * Copyright Mineraltree 2015.
 */

package util;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
//import com.fasterxml.jackson.module.jaxb.JaxbAnnotationIntrospector;

import java.io.IOException;
import java.io.StringWriter;
import java.util.List;

/**
 * Utility class for JSON marshaling and unmarshaling.  
 *
 */
public class JaxbJsonParser {

  /**
   * Method to parse jsonTxt to clazz entity object and ignoring unknown properties.
   * 
   * @param jsonTxt
   *          json object as text
   * @param clazz
   *          entity to convert from jsonTxt
   * @return converted clazz
   * @throws IOException
   *           if any error ocurred while parsing or input
   */
  public static <T> T unmarshalJson(String jsonTxt, Class<T> clazz, 
      boolean failOnUnknown) throws IOException {
    T entity = null;
    ObjectMapper objectMapper = new ObjectMapper();
//    objectMapper.setAnnotationIntrospector(new JaxbAnnotationIntrospector(
//    		objectMapper.getTypeFactory()));
    objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, failOnUnknown);
    entity = objectMapper.readValue(jsonTxt, clazz);
    return entity;
  }

  /**
   * Method to parse jsonArrayText to clazz entity object and ignoring unknown properties.
   * 
   * @param jsonArrayText
   *          json array object as text
   * @param clazz
   *          entity to convert from jsonTxt
   * @return converted clazz
   * @throws IOException
   *           if any error ocurred while parsing or input
   */
  public static <T> List<T> unmarshalJsonArray(String jsonArrayText, Class<T> clazz, 
      boolean failOnUnknown) throws IOException {
    List<T> entityList = null;
    ObjectMapper objectMapper = new ObjectMapper();
    objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, failOnUnknown);
    entityList = objectMapper.readValue(jsonArrayText,
        objectMapper.getTypeFactory().constructCollectionType(List.class, clazz));
    return entityList;
  }
  
  /**
   * Marshal an object into a JSON string.
   * @param entity object to be marshaled 
   * @return JSON representation of the object
   * @throws IOException JSON printing exception
   */
  public static String marshalJson(Object entity) throws IOException {
    ObjectMapper mapper = new ObjectMapper();
    mapper.setSerializationInclusion(Include.NON_NULL);
//    mapper.setAnnotationIntrospector(new JaxbAnnotationIntrospector(mapper.getTypeFactory()));
    StringWriter writer = new StringWriter();
    mapper.writeValue(writer, entity);
    return writer.toString();
  }

}
